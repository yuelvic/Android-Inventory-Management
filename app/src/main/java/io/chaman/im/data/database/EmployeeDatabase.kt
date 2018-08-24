package io.chaman.im.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.chaman.im.data.dao.EmployeeDao
import io.chaman.im.data.entities.Employee


@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase: RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {
        private var INSTANCE: EmployeeDatabase? = null

        fun getDatabase(context: Context): EmployeeDatabase? {
            if (INSTANCE == null) {
                synchronized(EmployeeDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                EmployeeDatabase::class.java, "employee_database")
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}