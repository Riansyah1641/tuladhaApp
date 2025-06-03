package com.thesis.tuladhaapp.ui.userClass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thesis.tuladhaapp.repository.courseHome.CourseRepository
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.Error

class ClassFragmentViewModel(private val repositoryCourse: CourseRepository, private val repositoryUser: UserRepository) : ViewModel(){


    companion object {
        const val PROGRESS_ALL = "all"
    }


    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String>
        get() = _searchQuery

    private val _selectedProgress = MutableLiveData<String>()
    val selectedProgress: LiveData<String>
        get() = _selectedProgress


    private val _allUserCourses = MutableLiveData<ResultWrapper<List<CourseData>>>()
    val allUserCourses: LiveData<ResultWrapper<List<CourseData>>>
        get() = _allUserCourses

    private val _userCourses = MutableLiveData<List<CourseData>>()
    val userCourses: LiveData<List<CourseData>> = _userCourses


    fun getCurrentUser() = repositoryUser.getCurrentUser()


    private val _courses = MutableLiveData<List<CourseData>>()
    val courses: LiveData<List<CourseData>> = _courses

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error



    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setSelectedProgress(progress: String) {
        _selectedProgress.value = progress
    }

    fun resetFilter() {
        _searchQuery.postValue("")
        _selectedProgress.postValue(PROGRESS_ALL)
    }

    // tes kedua


//    private val _userCourses = MutableStateFlow<List<CourseData>>(emptyList())
//    val userCourses: StateFlow<List<CourseData>> = _userCourses

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

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