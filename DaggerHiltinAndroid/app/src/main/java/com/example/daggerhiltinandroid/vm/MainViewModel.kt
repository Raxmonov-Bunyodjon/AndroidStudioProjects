package com.example.daggerhiltinandroid.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltinandroid.models.MainUser
import com.example.daggerhiltinandroid.models.jsonplaceholder.JsonPlaceHolderUser
import com.example.daggerhiltinandroid.repository.GithubRepository
import com.example.daggerhiltinandroid.repository.JsonPlaceHolderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val jsonPlaceHolderRepository: JsonPlaceHolderRepository,
    private val githubRepository: GithubRepository
) : ViewModel() {

    private val _flow = MutableStateFlow<Resource<MainUser>>(Resource.Loading())
    val flow get() = _flow

    init {
        getJsonPlaceHolderUsers()
    }

    private fun getJsonPlaceHolderUsers() {
        viewModelScope.launch {
            combine(
                jsonPlaceHolderRepository.getJsonPlaceHolderUsers(),
                githubRepository.getGithubUsers()
            ) { it1, it2 ->
                _flow.emit(Resource.Success(MainUser(it1, it2)))
            }.catch {
                _flow.emit(Resource.Failure(it))
            }.collect {

            }
        }

    }
}