package com.example.e_patrakaar.database.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.e_patrakaar.database.entity.NewsArticle

@Database(entities = [NewsArticle::class], version = 1)
abstract class NewsRoomDatabase : RoomDatabase(){

    abstract fun newsDao() : NewsDao

    companion object{
        @Volatile
        private var INSTANCE: NewsRoomDatabase? = null

        fun getDatabase(context: Context) : NewsRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NewsRoomDatabase::class.java,
                            "news_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

}