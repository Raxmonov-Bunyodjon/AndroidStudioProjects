package com.example.mvvminandroid.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvminandroid.database.AppDatabase
import com.example.mvvminandroid.database.entity.UserEntity
import com.example.mvvminandroid.mapper.mapToEntity
import com.example.mvvminandroid.networking.ApiService
import com.example.mvvminandroid.repository.UserRepository
import com.example.mvvminandroid.utils.NetworkHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.launch

//viewmodel qismi
class UserViewModel(
    appDatabase: AppDatabase,
    apiService: ApiService,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private val userRepository = UserRepository(apiService, appDatabase.userDao())
    private val stateFlow = MutableStateFlow<Resource<List<UserEntity>>>(Resource.Loading())

    init {
        fetchUsers()
    }
    private fun fetchUsers() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                userRepository.getUsers()
                    .catch {
                        stateFlow.emit(Resource.Error(it))
                    }.flatMapConcat {
                        val list = ArrayList<UserEntity>()
                        it.forEach {
                            list.add(it.mapToEntity(it))
                        }
                        userRepository.addUsers(list)
                    }.collect {
                        stateFlow.emit(Resource.Success(userRepository.getDatabaseUsers()))
                    }
            } else {
                if (userRepository.getUserCount() > 0) {
                    stateFlow.emit(Resource.Success(userRepository.getDatabaseUsers()))
                } else
                    stateFlow.emit(Resource.Error(Throwable("Internet not connection")))
            }
        }
    }
    fun getStateFlow(): StateFlow<Resource<List<UserEntity>>> {
        return stateFlow
    }
}