package io.chaman.im.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.chaman.im.data.dao.RequestDao
import io.chaman.im.data.entities.Request

@Database(entities = [Request::class], version = 1)
abstract class RequestDatabase: RoomDatabase() {

    abstract fun requestDao(): RequestDao

    companion object {
        private var INSTANCE: RequestDatabase? = null

        fun getDatabase(context: Context): RequestDatabase? {
            if (INSTANCE == null) {
                synchronized(RequestDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                RequestDatabase::class.java, "request_database")
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}