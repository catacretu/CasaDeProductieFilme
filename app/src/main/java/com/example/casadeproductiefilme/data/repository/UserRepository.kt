package com.example.casadeproductiefilme.data.repository

import com.example.casadeproductiefilme.data.local.dao.UserDAO
import com.example.casadeproductiefilme.data.local.entity.UserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDAO: UserDAO
) {

    fun insertUser(user: UserEntity) {
        userDAO.addUser(user)
    }

    fun getUser(username: String): UserEntity {
        return userDAO.getUser(username)
    }

    fun getAllUsers(): List<String> {
        return userDAO.getAllUsers()
    }

    fun deleteUser(username: String) {
        userDAO.delete(username)
    }
}