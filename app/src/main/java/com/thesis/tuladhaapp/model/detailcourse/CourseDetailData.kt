package com.thesis.tuladhaapp.model.detailcourse

import android.os.Parcelable
import com.thesis.tuladhaapp.model.course.CourseCategory
import com.thesis.tuladhaapp.model.course.CourseCreator
import kotlinx.parcelize.Parcelize

@Parcelize
data class CourseDetailData(
    val id: Int? = null,
    val name: String? = null,
    val imageUrl: String? = null,
    val videoPreviewUrl: String? = null,
    val level: String? = null,
    val rating: Double? = null,
    val categoryId: Int? = null,
    val description: String? = null,
    val classCode: String? = null,
    val totalModule: Int? = null,
    val totalDuration: Int? = null,
    val type: String? = null,
    val price: Int? = null,
    val promo: Int? = null,
    val totalUser: Int? = null,
    val courseBy: String? = null,
    val createdBy: Int? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val category: CourseCategory? = null,
    val courseCreator: CourseCreator? = null,
    val benefits: List<BenefitData?>? = null,
    val chapters: List<ChapterData>? = null,
) : Parcelable
