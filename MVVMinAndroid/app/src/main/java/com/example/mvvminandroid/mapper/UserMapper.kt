package com.example.mvvminandroid.mapper

import com.example.mvvminandroid.database.entity.UserEntity
import com.example.mvvminandroid.models.UserData


fun UserData.mapToEntity(userData: UserData) : UserEntity{
    return UserEntity(userData.id,userData.login,userData.avatar_url)
}