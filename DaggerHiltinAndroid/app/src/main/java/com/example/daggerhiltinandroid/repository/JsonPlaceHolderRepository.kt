package com.example.daggerhiltinandroid.repository

import com.example.daggerhiltinandroid.networking.JsonPlaceHolderService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JsonPlaceHolderRepository @Inject constructor(
    private val jsonPlaceHolderService: JsonPlaceHolderService
) {
    fun getJsonPlaceHolderUsers() = flow{emit(jsonPlaceHolderService.getJsonPlaceHolderUsers())}
}