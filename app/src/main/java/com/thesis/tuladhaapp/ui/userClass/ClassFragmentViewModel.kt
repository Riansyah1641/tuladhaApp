package com.thesis.tuladhaapp.ui.userClass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.repository.courseHome.CourseRepository
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ClassFragmentViewModel(
    private val repositoryCourse: CourseRepository,
    private val repositoryUser: UserRepository
) : ViewModel() {


    private val _selectedProgress = MutableLiveData<String>()
    val selectedProgress: LiveData<String>
        get() = _selectedProgress

    private val _userCourses = MutableLiveData<List<CourseData>>()
    val userCourses: LiveData<List<CourseData>> = _userCourses

    fun getCurrentUser() = repositoryUser.getCurrentUser()

    fun setSelectedProgress(progress: String) {
        _selectedProgress.value = progress
    }

    fun fetchUserCourses(userId: String) {
        viewModelScope.launch {
            try {
                repositoryCourse.getUserCourses(userId)
                    .collectLatest { courses ->
                        _userCourses.value = courses
                    }
            } catch (e: Exception) {
                _userCourses.value = emptyList()
            }
        }
    }
}