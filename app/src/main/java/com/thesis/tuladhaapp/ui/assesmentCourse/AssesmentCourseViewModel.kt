package com.thesis.tuladhaapp.ui.assesmentCourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.model.kuis.Assesment
import com.thesis.tuladhaapp.repository.assesmentCourse.AssesmentRepository
import com.thesis.tuladhaapp.repository.courseHome.CourseRepository
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AssesmentCourseViewModel(
    private val repository: AssesmentRepository,
    private val repositoryCourse: CourseRepository
) : ViewModel() {
    private val _assesment = MutableLiveData<Assesment?>()
    val assesment: LiveData<Assesment?> = _assesment

    private val _detailCourse = MutableLiveData<ResultWrapper<CourseData?>>()
    val detailCourseData: LiveData<ResultWrapper<CourseData?>>
        get() = _detailCourse

    fun GetAssesmentById(id: Int) {
        _assesment.value = repository.getAssesmentById(id).value
    }

    fun getDetailCourse(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryCourse.getDetailCourse(id).collect {
                _detailCourse.postValue(it)
            }
        }
    }

    fun sendCourseData(courseData: CourseData,idUser: String, callback: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                val isSuccess =repositoryCourse.sendCourseDataToFirebase(courseData, idUser)
                callback(isSuccess, null)
            } catch (e: Exception) {
                callback(false, e.localizedMessage)
            }
        }
    }
}