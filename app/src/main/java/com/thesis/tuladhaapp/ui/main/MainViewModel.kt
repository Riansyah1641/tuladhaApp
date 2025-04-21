package com.thesis.tuladhaapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.group2.sinow.model.profile.ProfileData
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _userData = MutableLiveData<ResultWrapper<ProfileData>>()
    val userData: LiveData<ResultWrapper<ProfileData>>
        get() = _userData

    fun getUserData() {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getUserData().collect {
                _userData.postValue(it)
            }
        }
    }
}