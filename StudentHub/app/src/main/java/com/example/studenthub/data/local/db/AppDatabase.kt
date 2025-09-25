package com.example.studenthub.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.studenthub.data.local.dao.UserDao
import com.example.studenthub.data.local.entity.UserEntity
//import com.example.studenthub.ui.main.faculty.FacultyFragment


/**
 * Main Database class for the Room library.
 * It combines all Entities (tables) and DAOs (data access objects).
 */
@Database(
    entities = [
        UserEntity::class,     // User table
  //      StudentEntity::class,  // Students table
       // FacultyFragment::class  // Faculties table
    ],
    version = 1,  // Database version (increase this when entities or columns are changed)
    exportSchema = false  // If true, Room exports schema into a folder (usually not needed for development)
)

abstract class AppDatabase: RoomDatabase() {

    /** DAO for the Users table (insert, delete, update, query operations). */
    abstract fun userDao(): UserDao

    /** DAO for the Students table (operations for handling student data). */
   // abstract fun studentDao(): StudentDao

    /** DAO for the Faculties table (operations for handling faculty data). */
   // abstract fun facultyDao(): FacultyDao
}