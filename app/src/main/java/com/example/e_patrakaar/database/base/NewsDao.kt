package com.example.e_patrakaar.database.base

import androidx.room.*
import com.example.e_patrakaar.database.entity.NewsArticle
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

        @Insert
        suspend fun insertNewsDetails(news: NewsArticle)

        @Query("SELECT * FROM NEWS_TABLE ORDER BY ID")
        fun getAllNewsList() : Flow<List<NewsArticle>>

//        @Update
//        suspend fun updateFavDishDetails(news: NewsArticle)
//
//        @Query("SELECT * FROM NEWS_TABLE WHERE news = 1")
//        fun getFavDishList() : Flow<List<NewsArticle>>
//
//        @Delete
//        suspend fun deleteDish(dish: NewsArticle)
//
//        @Query("SELECT * FROM FAV_DISHES_TABLE WHERE TYPE = :filterType")
//        fun getFilterDishesList(filterType: String): Flow<List<NewsArticle>>

}