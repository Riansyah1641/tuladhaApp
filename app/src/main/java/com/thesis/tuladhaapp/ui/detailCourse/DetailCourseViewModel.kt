package com.thesis.tuladhaapp.ui.detailCourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.repository.courseHome.CourseRepository
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailCourseViewModel(
    private val repository: CourseRepository
) : ViewModel() {

    private val _detailCourse = MutableLiveData<ResultWrapper<CourseData?>>()
    val detailCourseData: LiveData<ResultWrapper<CourseData?>>
        get() = _detailCourse

    fun getDetailCourse(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDetailCourse(id).collect {
                _detailCourse.postValue(it)
            }
        }
    }
}