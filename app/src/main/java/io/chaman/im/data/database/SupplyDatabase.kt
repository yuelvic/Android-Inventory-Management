package io.chaman.im.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.chaman.im.data.dao.SupplyDao
import io.chaman.im.data.entities.Supply

@Database(entities = [Supply::class], version = 1)
abstract class SupplyDatabase: RoomDatabase() {

    abstract fun supplyDao(): SupplyDao

    companion object {
        private var INSTANCE: SupplyDatabase? = null

        fun getDatabase(context: Context): SupplyDatabase? {
            if (INSTANCE == null) {
                synchronized(SupplyDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                SupplyDatabase::class.java, "supply_database")
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}