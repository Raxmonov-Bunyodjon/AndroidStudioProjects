package com.example.daggerhiltinandroid.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daggerhiltinandroid.database.entity.GithubUserEntity

@Dao
interface GithubUserDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUsers(list: List<GithubUserEntity>)

    @Query("select * from githubuserentity")
    fun getGithubUsers():List<GithubUserEntity>
}