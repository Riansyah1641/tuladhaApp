package com.thesis.tuladhaapp.repository.assesmentCourse

import androidx.lifecycle.LiveData
import com.thesis.tuladhaapp.model.kuis.Assesment

interface AssesmentRepository {
    fun getAssesmentById(id: Int): LiveData<Assesment?>
}