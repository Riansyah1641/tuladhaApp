package com.thesis.tuladhaapp.repository.userRepository

import com.group2.sinow.model.profile.ProfileData
import com.thesis.tuladhaapp.data.dataSource.user.DataSourceUsers
import com.thesis.tuladhaapp.utils.ResultWrapper
import com.thesis.tuladhaapp.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val dataSource: DataSourceUsers
) : UserRepository {

    override fun getUserData(): Flow<ResultWrapper<ProfileData>> {
        return proceedFlow {
            dataSource.getUserData()
        }
    }

    override fun doRegister(
        email: String,
        fullName: String,
        password: String,
    ): Flow<ResultWrapper<Boolean>> {
        return proceedFlow {
            dataSource.doRegister(email, fullName, password)
        }
    }

    override fun doLogin(
        email: String,
        password: String,
    ): Flow<ResultWrapper<Boolean>> {
        return proceedFlow {
            dataSource.doLogin(email, password)
        }
    }
}