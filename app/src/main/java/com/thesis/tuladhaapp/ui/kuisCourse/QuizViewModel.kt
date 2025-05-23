package com.thesis.tuladhaapp.ui.kuisCourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.thesis.tuladhaapp.model.kuis.Quiz
import com.thesis.tuladhaapp.repository.kuisCourse.KuisRepository

class QuizViewModel(private val repository: KuisRepository) : ViewModel() {

    fun getQuizById(id: Int): LiveData<List<Quiz>> {
        return repository.getQuizById(id)
    }

    fun getAllQuizzes(): Map<Int, List<Quiz>> {
        return repository.getAllQuizzes()
    }
}