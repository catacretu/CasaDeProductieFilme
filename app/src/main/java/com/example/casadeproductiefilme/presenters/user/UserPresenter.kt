package com.example.casadeproductiefilme.presenters.user

import com.example.casadeproductiefilme.data.local.entity.UserEntity
import com.example.casadeproductiefilme.data.repository.UserRepository
import javax.inject.Inject

class UserPresenter @Inject constructor(
    private val userRepository: UserRepository
) : UserInterface.Presenter {
    override fun checkCredentials(username: String, password: String): String? {
        val user = userRepository.getUser(username)
        if (user != null) {

            if (user.username == "admin" && user.password == "admin")
                return "admin"

            if (user.username == "manag" && user.password == "manag")
                return "manag"

            return "user"
        }
        return null
    }

    override fun saveUser(user: UserEntity) {
        userRepository.insertUser(user)
    }

    override fun getAllUsers() {
        userRepository.getAllUsers()
    }
}