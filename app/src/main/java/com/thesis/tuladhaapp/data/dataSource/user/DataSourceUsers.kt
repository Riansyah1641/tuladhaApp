package com.thesis.tuladhaapp.data.dataSource.user

import com.group2.sinow.model.profile.ProfileData
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface DataSourceUsers {
    suspend fun getUserData(): ProfileData
}