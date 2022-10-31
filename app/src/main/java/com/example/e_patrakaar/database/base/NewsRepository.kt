package com.example.e_patrakaar.database.base

import androidx.annotation.WorkerThread
import com.example.e_patrakaar.database.entity.NewsArticle
import kotlinx.coroutines.flow.Flow

class NewsRepository(private val newsDao: NewsDao) {

    @WorkerThread
    suspend fun insertNewsData(news: NewsArticle) {
        newsDao.insertNewsDetails(news)
    }

    val allNewsList: Flow<List<NewsArticle>> = newsDao.getAllNewsList()

}