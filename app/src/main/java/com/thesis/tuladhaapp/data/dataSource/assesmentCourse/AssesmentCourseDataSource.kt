package com.thesis.tuladhaapp.data.dataSource.assesmentCourse

import com.thesis.tuladhaapp.model.kuis.Assesment

interface AssesmentCourseDataSource {
    fun getAssesmentById(id: Int): Assesment?
}