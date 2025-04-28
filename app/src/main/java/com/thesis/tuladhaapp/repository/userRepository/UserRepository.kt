package com.thesis.tuladhaapp.repository.userRepository

import com.group2.sinow.model.profile.ProfileData
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserData(): Flow<ResultWrapper<ProfileData>>
    @Throws(exceptionClasses = [Exception::class])
    fun doRegister(
        email: String,
        fullName: String,
        password: String,
    ): Flow<ResultWrapper<Boolean>>
    @Throws(exceptionClasses = [Exception::class])
    fun doLogin(
        email: String,
        password: String,
    ): Flow<ResultWrapper<Boolean>>
}