package com.example.mangaapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT password from User where email=:email")
    fun getPaswd(email : String) : String

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(item : User)


}