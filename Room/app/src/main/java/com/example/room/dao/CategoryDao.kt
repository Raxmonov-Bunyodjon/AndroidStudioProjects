package com.example.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.room.entity.Category
import com.example.room.entity.CategoryNews

@Dao
interface CategoryDao {

    @Transaction
    @Query("select * from category")
    fun getCategoryByNews(): List<CategoryNews>

    @Query("select * from category")
    fun getAllCategories():List<Category>

    @Insert
    fun insertCategory(category: Category)

    @Insert
    fun insertAllCategory(vararg category: Category)

}