package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse

import com.thesis.tuladhaapp.model.detailcourse.CourseData

interface DataSourceDetailCourse {
    suspend fun getDetailCourse(id: Int): CourseData?
}