package com.example.daggerhiltinandroid.di

import com.example.daggerhiltinandroid.networking.GithubService
import com.example.daggerhiltinandroid.networking.JsonPlaceHolderService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    @Named(value = "jsonplaceholder")
    fun provideJsonPlaceHolderBaseUrl(): String = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    @Named(value = "github")
    fun provideGithubBaseUrl(): String = "https://api.github.com/"

    @Provides
    @Singleton
    @Named("retrofit1")
    fun provideRetrofit1(@Named("jsonplaceholder") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("retrofit2")
    fun provideRetrofit2(@Named("github") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideJsonPlaceHolder1(@Named("retrofit1") retrofit: Retrofit): JsonPlaceHolderService {
        return retrofit.create(JsonPlaceHolderService::class.java)
    }

    @Provides
    @Singleton
    fun provideGithub(@Named("retrofit2") retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }


}