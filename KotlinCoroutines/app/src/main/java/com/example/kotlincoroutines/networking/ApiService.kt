package com.example.kotlincoroutines.networking

import com.example.kotlincoroutines.models.PostData
import com.example.kotlincoroutines.models.UserData
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<UserData>

    @GET("posts")
    suspend fun getPosts(): List<PostData>

}