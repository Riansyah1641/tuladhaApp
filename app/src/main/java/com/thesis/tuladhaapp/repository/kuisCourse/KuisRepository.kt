package com.thesis.tuladhaapp.repository.kuisCourse

import androidx.lifecycle.LiveData
import com.thesis.tuladhaapp.model.kuis.Quiz

interface KuisRepository {
        fun getAllQuizzes(): Map<Int, List<Quiz>>
        fun getQuizById(id: Int): LiveData<List<Quiz>>
}