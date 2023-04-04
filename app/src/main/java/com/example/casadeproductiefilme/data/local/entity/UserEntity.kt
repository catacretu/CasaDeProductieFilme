package com.example.casadeproductiefilme.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userID: Int = 0,
    val username: String,
    val password: String
) {
}