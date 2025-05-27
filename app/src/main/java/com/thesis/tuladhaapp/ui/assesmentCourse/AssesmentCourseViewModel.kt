package com.thesis.tuladhaapp.ui.assesmentCourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thesis.tuladhaapp.model.kuis.Assesment
import com.thesis.tuladhaapp.repository.assesmentCourse.AssesmentRepository
import com.thesis.tuladhaapp.repository.userRepository.UserRepository

class AssesmentCourseViewModel(private val repository: AssesmentRepository) : ViewModel() {


    private val _assesment = MutableLiveData<Assesment?>()
    val assesment: LiveData<Assesment?> = _assesment

    fun GetAssesmentById(id: Int) {
        _assesment.value = repository.getAssesmentById(id).value
    }
}