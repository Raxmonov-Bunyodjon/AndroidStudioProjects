package com.example.room.dao

import androidx.appcompat.widget.DialogTitle
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.room.entity.CategoryNews
import com.example.room.entity.News

@Dao
interface NewsDao {
    @Query("select * from news")
    fun getAllNews(): List<News>

    @Insert
    fun addNews(news: News)

    @Delete
    fun deleteNews(news: News)

    @Update
    fun updateNews(news: News)

    @Query("select * from news where id=:id")
    fun getNewsById(id: Int): News

    @Query("select id from news where news_title=:title and description=:desc")
    fun getNewsById(title: String, desc:String): Int
    @Insert
    fun addAllNews(vararg news: News)
}