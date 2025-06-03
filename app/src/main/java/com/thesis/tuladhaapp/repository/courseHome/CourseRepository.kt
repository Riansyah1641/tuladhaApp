package com.thesis.tuladhaapp.repository.courseHome

import com.thesis.tuladhaapp.model.course.Course
import com.thesis.tuladhaapp.model.detailcourse.CourseData
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

    fun getCoursesClass(
        search: String?,
        type: String?,
        category: List<Int>?,
        level: List<String>?,
        sortBy: String?
    ): Flow<ResultWrapper<List<Course>>>

    fun getDetailCourse(id: Int): Flow<ResultWrapper<CourseData?>>

    suspend fun sendCourseDataToFirebase(courseData: CourseData, idUser: String): Boolean

    fun getUserCourses(userId: String): Flow<List<CourseData>>

}