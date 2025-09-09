package com.example.room.entity

import androidx.room.Embedded
import androidx.room.Relation


data class CategoryNews(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "id",
        entityColumn = "category_id" // ✅ to‘g‘ri ustun nomi
    )
    val newsList: List<News>
)
