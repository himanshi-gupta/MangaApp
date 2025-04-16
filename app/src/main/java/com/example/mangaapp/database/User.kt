package com.example.mangaapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey
    var email: String,

    @ColumnInfo(name = "password")
    var password: String
)