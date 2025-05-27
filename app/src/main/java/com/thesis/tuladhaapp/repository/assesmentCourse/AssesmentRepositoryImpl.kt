package com.thesis.tuladhaapp.repository.assesmentCourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.thesis.tuladhaapp.data.dataSource.assesmentCourse.AssesmentCourseDataSource
import com.thesis.tuladhaapp.model.kuis.Assesment

class AssesmentRepositoryImpl(private val dataSource: AssesmentCourseDataSource) :
    AssesmentRepository {
    override fun getAssesmentById(id: Int): LiveData<Assesment?> {
        val assesment = dataSource.getAssesmentById(id)
        return MutableLiveData(assesment)
    }
}