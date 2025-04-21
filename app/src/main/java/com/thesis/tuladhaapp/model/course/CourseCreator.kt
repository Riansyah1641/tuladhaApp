package com.thesis.tuladhaapp.model.course

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CourseCreator(
    val id: Int?,
    val name: String?
) : Parcelable
