package com.example.shoplist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoplist.database.dao.DaoItem
import com.example.shoplist.database.entity.Item
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Item::class], version = 1)
abstract class DataBaseApp : RoomDatabase() {

    abstract fun daoItem(): DaoItem

    // Singleton
    companion object {

        @Volatile
        private var INSTANCE: DataBaseApp? = null

        fun getDatabase(context: Context, scope: CoroutineScope): DataBaseApp {

            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this) {
                // Create data base
                val instance = Room.databaseBuilder(
                    context.applicationContext,DataBaseApp::class.java,
                    "itemdb")
                    .build()

                INSTANCE = instance

                return instance
            }

        }

    }

}