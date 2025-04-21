package com.thesis.tuladhaapp.data.dataSource.course

import com.thesis.tuladhaapp.model.course.Course

interface DataSourceCourse {
    suspend fun getCourses(
        search: String? = null,
        type: String? = null,
        category: Int? = null,
        level: String? = null,
        sortBy: String? = null
    ): List<Course>
}