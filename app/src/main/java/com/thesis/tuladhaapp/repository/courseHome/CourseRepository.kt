package com.thesis.tuladhaapp.repository.courseHome

import com.thesis.tuladhaapp.model.course.Course
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface CourseRepository {
    fun getCourses(
        search: String? = null,
        type: String? = null,
        category: Int? = null,
        level: String? = null,
        sortBy: String? = null
    ): Flow<ResultWrapper<List<Course>>>
}