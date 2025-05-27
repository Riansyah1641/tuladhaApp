package com.thesis.tuladhaapp.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import kotlinx.coroutines.Dispatchers

class ProfileViewModel(private val repo: UserRepository): ViewModel() {
    val isEditMode = MutableLiveData(false)

    fun changeEditMode() {
        val currentValue = isEditMode.value ?: false
        isEditMode.postValue(!currentValue)
    }

    fun changeProfile(fullName: String, uri: String) = repo.updateProfile(fullName, uri).asLiveData(Dispatchers.IO)

    fun changePassword() {
        repo.requestChangePasswordByEmail()
    }

    fun getCurrentUser() = repo.getCurrentUser()

    fun isUserLoggedIn() = repo.isLoggedIn()

    fun doLogout() {
        repo.doLogout()
    }
}