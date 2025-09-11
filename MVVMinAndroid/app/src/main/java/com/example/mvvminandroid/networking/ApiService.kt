package com.example.mvvminandroid.networking

import com.example.mvvminandroid.models.UserData
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Flow<List<UserData>>
}