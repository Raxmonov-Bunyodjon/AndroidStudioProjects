package com.example.daggerhiltinandroid.networking

import com.example.daggerhiltinandroid.models.jsonplaceholder.JsonPlaceHolderUser
import retrofit2.http.GET

interface JsonPlaceHolderService {

    @GET("users")
    suspend fun getJsonPlaceHolderUsers(): List<JsonPlaceHolderUser>
}