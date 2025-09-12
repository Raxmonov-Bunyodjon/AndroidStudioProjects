package com.example.daggerhiltinandroid.di

import android.content.Context
import androidx.room.Room
import com.example.daggerhiltinandroid.database.AppDatabase
import com.example.daggerhiltinandroid.database.dao.GithubUserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "my_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideGithubUserDao(appDatabase: AppDatabase): GithubUserDao{
        return appDatabase.getGithubUserDao()
    }

}