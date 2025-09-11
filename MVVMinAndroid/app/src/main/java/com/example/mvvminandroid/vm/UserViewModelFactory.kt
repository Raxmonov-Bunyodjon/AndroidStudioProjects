package com.example.mvvminandroid.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvminandroid.database.AppDatabase
import com.example.mvvminandroid.networking.ApiService
import com.example.mvvminandroid.utils.NetworkHelper

class UserViewModelFactory(
    private val appDatabase: AppDatabase,
    private val apiService: ApiService,
    private val networkHelper: NetworkHelper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(appDatabase, apiService, networkHelper) as T
        }
        return throw Exception("Error")
        }
    }