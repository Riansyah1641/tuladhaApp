package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.chapterData

import com.thesis.tuladhaapp.model.detailcourse.ChapterData

interface DataSourseChapterData {
    fun getChaptersForCourse(courseId: Int?): List<ChapterData>
}