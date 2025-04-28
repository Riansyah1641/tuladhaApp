package com.thesis.tuladhaapp.data.dataSource.user

import com.group2.sinow.model.profile.ProfileData
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface DataSourceUsers {
    suspend fun getUserData(): ProfileData
    @Throws(exceptionClasses = [Exception::class])
    suspend fun doRegister(
        email: String,
        fullName: String,
        password: String,
    ): Boolean

    @Throws(exceptionClasses = [Exception::class])
    suspend fun doLogin(
        email: String,
        password: String,
    ): Boolean
}