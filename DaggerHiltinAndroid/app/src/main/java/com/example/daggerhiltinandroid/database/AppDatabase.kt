package com.example.daggerhiltinandroid.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggerhiltinandroid.database.dao.GithubUserDao
import com.example.daggerhiltinandroid.database.entity.GithubUserEntity

@Database(entities = [GithubUserEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getGithubUserDao (): GithubUserDao
}