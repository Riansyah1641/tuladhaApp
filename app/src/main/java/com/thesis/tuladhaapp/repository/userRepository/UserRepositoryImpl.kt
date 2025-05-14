package com.thesis.tuladhaapp.repository.userRepository

import com.group2.sinow.model.profile.ProfileData
import com.thesis.tuladhaapp.data.dataSource.user.DataSourceUsers
import com.thesis.tuladhaapp.model.firebase.User
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

    override fun updateProfile(fullName: String?, url : String?): Flow<ResultWrapper<Boolean>> {
        return proceedFlow {
            dataSource.updateProfile(fullName, url)
        }
    }

    override fun updatePassword(newPassword: String): Flow<ResultWrapper<Boolean>> {
        return proceedFlow {
            dataSource.updatePassword(newPassword)
        }
    }

    override fun updateEmail(newEmail: String): Flow<ResultWrapper<Boolean>> {
        return proceedFlow {
            dataSource.updateEmail(newEmail)
        }
    }

    override fun requestChangePasswordByEmail(): Boolean {
        return dataSource.requestChangePasswordByEmail()
    }

    override fun doLogout(): Boolean {
        return dataSource.doLogout()
    }

    override fun isLoggedIn(): Boolean {
        return dataSource.isLoggedIn()
    }

    override fun getCurrentUser(): User? {
        return dataSource.getCurrentUser()
    }
}