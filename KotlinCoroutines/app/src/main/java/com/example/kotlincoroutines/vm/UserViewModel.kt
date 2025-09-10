package com.example.kotlincoroutines.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutines.models.UserData
import com.example.kotlincoroutines.models.UserWithPost
import com.example.kotlincoroutines.networking.ApiClient
import com.example.kotlincoroutines.networking.ApiService
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val apiService = ApiClient.getRetrofit().create(ApiService::class.java)
    private val liveData = MutableLiveData<UserWithPost>()
    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val async1 = async { apiService.getUsers() }
                    val async2 = async { apiService.getPosts() }
                    val userList = async1.await()
                    val postList = async2.await()
                    liveData.postValue(UserWithPost(userList, postList))
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun getUsersLiveData(): LiveData<UserWithPost>{
        return liveData
    }

}