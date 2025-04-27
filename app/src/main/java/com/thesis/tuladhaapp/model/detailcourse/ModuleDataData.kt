package com.thesis.tuladhaapp.model.detailcourse

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModuleDataData(
    val id: Int?,
    val no: Int?,
    val name: String?
) : Parcelable
