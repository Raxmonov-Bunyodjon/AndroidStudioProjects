package com.example.daggerhiltinandroid.repository

import com.example.daggerhiltinandroid.database.dao.GithubUserDao
import com.example.daggerhiltinandroid.networking.GithubService
import kotlinx.coroutines.flow.flow
import java.security.PrivateKey
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val githubService: GithubService,
    private val githubUserDao: GithubUserDao
) {

    fun getGithubUsers() = flow{emit(githubService.getGithubUsers())}
}