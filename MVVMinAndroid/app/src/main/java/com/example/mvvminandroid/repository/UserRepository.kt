package com.example.mvvminandroid.repository

import com.example.mvvminandroid.database.dao.UserDao
import com.example.mvvminandroid.database.entity.UserEntity
import com.example.mvvminandroid.networking.ApiService
import kotlinx.coroutines.flow.flow

//model
class UserRepository(private val apiService: ApiService, private val userDao: UserDao) {

    fun getUsers() = apiService.getUsers()

    fun addUsers(list: List<UserEntity>) = flow { emit(userDao.addUsers(list)) }

    fun getDatabaseUsers() = userDao.getUsers()

    fun getUserCount() = userDao.getUserCount()
}