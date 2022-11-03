package com.example.e_patrakaar.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "news_table")
class NewsArticle(
    @ColumnInfo val image: String,
    @ColumnInfo val title: String,
    @ColumnInfo val description: String,
    @ColumnInfo val category: String,
    @ColumnInfo val uploadTime: String,
    @ColumnInfo val source: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Parcelable