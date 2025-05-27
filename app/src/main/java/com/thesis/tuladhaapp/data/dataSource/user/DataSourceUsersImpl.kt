package com.thesis.tuladhaapp.data.dataSource.user

import com.thesis.tuladhaapp.model.firebase.User
import com.thesis.tuladhaapp.model.firebase.toUser
import com.thesis.tuladhaapp.source.firebase.FirebaseService


class DataSourceUsersImpl(private val service: FirebaseService) : DataSourceUsers {

    override suspend fun doRegister(
        email: String,
        fullName: String,
        password: String,
    ): Boolean {
        return service.doRegister(email, fullName, password)
    }

    override suspend fun doLogin(
        email: String,
        password: String,
    ): Boolean {
        return service.doLogin(email, password)
    }

    override suspend fun updateProfile(fullName: String?, uri: String?): Boolean {
        return service.updateProfile(fullName, uri)
    }

    override suspend fun updatePassword(newPassword: String): Boolean {
        return service.updatePassword(newPassword)
    }

    override suspend fun updateEmail(newEmail: String): Boolean {
        return service.updateEmail(newEmail)
    }

    override fun requestChangePasswordByEmail(): Boolean {
        return service.requestChangePasswordByEmail()
    }

    override fun doLogout(): Boolean {
        return service.doLogout()
    }

    override fun isLoggedIn(): Boolean {
        return service.isLoggedIn()
    }

    override fun getCurrentUser(): User? {
        return service.getCurrentUser().toUser()
    }


}