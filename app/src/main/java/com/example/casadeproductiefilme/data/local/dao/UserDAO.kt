package com.example.casadeproductiefilme.data.local.dao

import androidx.room.*
import com.example.casadeproductiefilme.data.local.entity.UserEntity

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun addUser(user: UserEntity)

    @Query("SELECT * FROM user_table WHERE username = :username")
    fun getUser(username: String): UserEntity

    @Query("SELECT * From user_table")
    fun getAllUsers(): List<UserEntity>

    @Delete
    fun delete(user: UserEntity)
}