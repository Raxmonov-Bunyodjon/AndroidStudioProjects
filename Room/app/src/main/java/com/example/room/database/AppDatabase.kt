package com.example.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.dao.CategoryDao
import com.example.room.dao.NewsDao
import com.example.room.entity.Category
import com.example.room.entity.CategoryNews
import com.example.room.entity.News

@Database(entities = [News::class, Category::class], version = 1) // ✅ Qavs yopildi
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "news.db" // ✅ Database nomi
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() // ❗️Faqat test uchun
                    .build()
            }
            return instance!!
        }
    }
}




