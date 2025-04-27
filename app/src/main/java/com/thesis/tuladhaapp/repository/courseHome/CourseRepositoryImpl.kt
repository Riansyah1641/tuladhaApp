package com.thesis.tuladhaapp.repository.courseHome

import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.DataSourceDetailCourse
import com.thesis.tuladhaapp.model.course.Course
import com.thesis.tuladhaapp.data.dataSource.course.DataSourceCourse
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.utils.ResultWrapper
import com.thesis.tuladhaapp.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

class CourseRepositoryImpl(private val dataSource: DataSourceCourse, private val dataSourceDetailCourse: DataSourceDetailCourse): CourseRepository {

    override fun getCourses(
        search: String?,
        type: String?,
        category: Int?,
        level: String?,
        sortBy: String?
    ): Flow<ResultWrapper<List<Course>>> {
        return proceedFlow {
            dataSource.getCourses(search, type, category, level, sortBy)  ?: emptyList()
        }
    }

    override fun getCoursesClass(
        search: String?,
        type: String?,
        category: List<Int>?,
        level: List<String>?,
        sortBy: String?
    ): Flow<ResultWrapper<List<Course>>> {
        return proceedFlow {
            dataSource.getCoursesClass(search, type, category, level, sortBy)  ?: emptyList()
        }
    }
    override fun getDetailCourse(id: Int): Flow<ResultWrapper<CourseData?>> {
        return proceedFlow {
            dataSourceDetailCourse.getDetailCourse(id)
        }
    }
}