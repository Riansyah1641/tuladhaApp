package com.thesis.tuladhaapp.model.detailcourse

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChapterData(
    val id: Int? = null,
    val no: Int? = null,
    val name: String? = null,
    val totalDuration: Int? = null,
    val userModules: List<UserModuleData>? = null,
) : Parcelable
