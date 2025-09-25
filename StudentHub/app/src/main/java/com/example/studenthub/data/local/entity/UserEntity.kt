package com.example.studenthub.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * UserEntity — Room entity representing the "users" table.
 */
@Entity(tableName = "users")
data class UserEntity(
    /** Unique ID (Primary Key, auto-generated). */
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    /** First name of the user. */
    val firstName: String,

    /** Last name of the user. */
    val lastName: String,

    /** Username (used for login, should be unique). */
    val username: String,

    /** User's password. */
    val password: String,
)

