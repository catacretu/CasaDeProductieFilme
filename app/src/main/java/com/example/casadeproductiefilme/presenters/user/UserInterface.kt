package com.example.casadeproductiefilme.presenters.user

import com.example.casadeproductiefilme.data.local.entity.UserEntity

interface UserInterface {

    interface View {
        fun initUserList()
    }

    interface Presenter {
        fun checkCredentials(username: String, password: String): String?
        fun saveUser(user: UserEntity)
        fun getAllUsers()
    }
}