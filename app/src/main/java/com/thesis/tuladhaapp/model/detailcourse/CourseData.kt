package com.thesis.tuladhaapp.model.detailcourse

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CourseData(
    val id: Int? = null,
    val userId: String? = null,
    val courseId: Int? = null,
    val isAccessible: Boolean? = null,
    val isFollowing: Boolean? = null,
    val lastSeen: String? = null,
    val progress: String? = null,
    val progressPercentage: Int? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val course: CourseDetailData? = null
) : Parcelable
