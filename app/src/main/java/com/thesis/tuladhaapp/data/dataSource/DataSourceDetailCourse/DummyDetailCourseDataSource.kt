package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse

import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.benefitCourse.DataSourceBenefit
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.chapterData.DataSourseChapterData
import com.thesis.tuladhaapp.data.dataSource.course.DataSourceCourse
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.model.detailcourse.CourseDetailData
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import com.thesis.tuladhaapp.utils.Utils

class DummyDetailCourseDataSource(
    private val dataSourceCourse: DataSourceCourse,
    private val dataSourceBenefit: DataSourceBenefit,
    private val dataSourceChapter: DataSourseChapterData,
    private val userRepository: UserRepository
) : DataSourceDetailCourse {
    override suspend fun getDetailCourse(id: Int): CourseData? {
        val selectedCourse = dataSourceCourse.getCourses().first() { it.id == id } ?: return null
        val idUser = userRepository.getCurrentUser()
        return CourseData(
            id = 1,
            userId = idUser?.id,
            courseId = selectedCourse.id,
            isAccessible = true,
            isFollowing = true,
            lastSeen = Utils.lastseenTime(),
            progress = "Dalam Progress",
            progressPercentage = 35,
            createdAt = selectedCourse.createdAt,
            updatedAt = selectedCourse.updatedAt,
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
                promo = selectedCourse.promoDiscountPercentage,
                totalUser = selectedCourse.totalUser,
                courseBy = selectedCourse.courseBy,
                courseCreator = selectedCourse.courseCreator,
                benefits = dataSourceBenefit.getBenefitsForCourse(selectedCourse.id),
                createdAt = selectedCourse.createdAt,
                updatedAt = selectedCourse.updatedAt,
                createdBy = selectedCourse.createdBy,
                categoryId = selectedCourse.categoryId,
                chapters = dataSourceChapter.getChaptersForCourse(selectedCourse.id)
            )
        )
    }
}