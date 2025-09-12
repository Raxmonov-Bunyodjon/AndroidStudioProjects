package com.example.daggerhiltinandroid.models

import com.example.daggerhiltinandroid.models.github.GithubUser
import com.example.daggerhiltinandroid.models.jsonplaceholder.JsonPlaceHolderUser

data class MainUser(
    val jsonPlaceHolderUsers: List<JsonPlaceHolderUser>,
    val githubUsers: List<GithubUser>
)
