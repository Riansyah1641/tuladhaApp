package com.thesis.tuladhaapp.repository.kuisCourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.thesis.tuladhaapp.data.dataSource.kuisCourse.kuisCourseDataSource
import com.thesis.tuladhaapp.model.kuis.Quiz

class KuisRepositoryImpl(  private val dataSource: kuisCourseDataSource
) : KuisRepository {

    override fun getAllQuizzes(): Map<Int, List<Quiz>> {
        return dataSource.getAllQuizzes()
    }

    override fun getQuizById(id: Int): LiveData<List<Quiz>> {
        return MutableLiveData(dataSource.getQuizById(id))
    }
}