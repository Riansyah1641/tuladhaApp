package com.thesis.tuladhaapp.data.dataSource.kuisCourse

import com.thesis.tuladhaapp.model.kuis.Quiz

interface kuisCourseDataSource {
    fun getAllQuizzes(): Map<Int, List<Quiz>>
    fun getQuizById(id: Int): List<Quiz>
}