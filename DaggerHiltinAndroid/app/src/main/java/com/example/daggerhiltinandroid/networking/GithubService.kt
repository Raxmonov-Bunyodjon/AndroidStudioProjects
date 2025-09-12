package com.example.daggerhiltinandroid.networking

import com.example.daggerhiltinandroid.models.github.GithubUser
import retrofit2.http.GET

interface GithubService {

    @GET("users")
    suspend fun getGithubUsers():List<GithubUser>
}