package com.thesis.tuladhaapp.repository.userRepository

import com.group2.sinow.model.profile.ProfileData
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserData(): Flow<ResultWrapper<ProfileData>>
}