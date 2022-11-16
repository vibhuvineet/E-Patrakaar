package com.example.e_patrakaar.application

import android.app.Application
import com.example.e_patrakaar.database.base.NewsRepository
import com.example.e_patrakaar.database.base.NewsRoomDatabase

class NewsApplication : Application(){

    private val database by lazy {
        NewsRoomDatabase.getDatabase(this@NewsApplication)
    }

    val repository by lazy { NewsRepository(database.newsDao()) }
}