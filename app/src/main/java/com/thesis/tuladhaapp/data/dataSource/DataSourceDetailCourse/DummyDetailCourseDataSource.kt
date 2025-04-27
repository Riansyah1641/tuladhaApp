package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse

import com.thesis.tuladhaapp.data.dataSource.course.DataSourceCourse
import com.thesis.tuladhaapp.model.detailcourse.BenefitData
import com.thesis.tuladhaapp.model.detailcourse.ChapterData
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.model.detailcourse.CourseDetailData

class DummyDetailCourseDataSource(private val dataSourceCourse: DataSourceCourse):DataSourceDetailCourse {
    override suspend fun getDetailCourse(id: Int): CourseData? {
        val selectedCourse = dataSourceCourse.getCourses().first() { it.id == id } ?: return null

        return CourseData(
            id = 1001,
            userId = null,
            courseId = selectedCourse.id,
            isAccessible = true,
            isFollowing = true,
            lastSeen = "2025-04-01T12:00:00Z",
            progress = "Module 2",
            progressPercentage = 35,
            createdAt = "2025-03-01T10:00:00Z",
            updatedAt = "2025-04-01T12:00:00Z",
            course = CourseDetailData(
                id = selectedCourse.id,
                name = selectedCourse.name,
                imageUrl = selectedCourse.imageUrl,
                videoPreviewUrl = selectedCourse.videoPreviewUrl,
                level = selectedCourse.level,
                rating = selectedCourse.rating,
                category = selectedCourse.category,
                description = selectedCourse.description,
                classCode = selectedCourse.classCode,
                totalModule = selectedCourse.totalModule,
                totalDuration = selectedCourse.totalDuration,
                type = selectedCourse.type,
                price = selectedCourse.price,
                promo= selectedCourse.promoDiscountPercentage,
                totalUser = selectedCourse.totalUser,
                courseBy = selectedCourse.courseBy,
                courseCreator = selectedCourse.courseCreator,
                benefits = listOf(
                    BenefitData(0,1,"Benefit 1"),
                    BenefitData(1,2,"Benefit 2"),
                    BenefitData(2,3,"Benefit 3")
                ),
                createdAt = selectedCourse.createdAt,
                updatedAt = selectedCourse.updatedAt,
                createdBy = selectedCourse.createdBy,
                categoryId = selectedCourse.categoryId,
                chapters = listOf(
                    ChapterData(0,1,"Introduction",120),
                    ChapterData(1,2,"Relationship",120),
                    ChapterData(2,3,"Family",120)
                )
            )
        )
    }

}