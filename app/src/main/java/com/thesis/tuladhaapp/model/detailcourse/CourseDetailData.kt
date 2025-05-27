package com.thesis.tuladhaapp.model.detailcourse

import android.os.Parcelable
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.model.course.CourseBenefit
import com.thesis.tuladhaapp.model.course.CourseCategory
import com.thesis.tuladhaapp.model.course.CourseCreator
import com.thesis.tuladhaapp.model.detailcourse.BenefitData
import com.thesis.tuladhaapp.model.detailcourse.ChapterData
import kotlinx.parcelize.Parcelize

@Parcelize
data class CourseDetailData(
    val id: Int?,
    val name: String?,
    val imageUrl: String?,
    val videoPreviewUrl: String?,
    val level: String?,
    val rating: Double?,
    val categoryId: Int?,
    val description: String?,
    val classCode: String?,
    val totalModule: Int?,
    val totalDuration: Int?,
    val type: String?,
    val price: Int?,
    val promo: Int?,
    val totalUser: Int?,
    val courseBy: String?,
    val createdBy: Int?,
    val createdAt: String?,
    val updatedAt: String?,
    val category: CourseCategory?,
    val courseCreator: CourseCreator?,
    val benefits: List<BenefitData?>?,
    val chapters: List<ChapterData>?
) : Parcelable
