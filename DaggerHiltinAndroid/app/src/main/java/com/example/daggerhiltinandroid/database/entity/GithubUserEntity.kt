package com.example.daggerhiltinandroid.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class GithubUserEntity(
    @PrimaryKey val id: Int,
    val avatar: String,
    val login: String
)
