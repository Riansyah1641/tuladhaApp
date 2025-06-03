package com.thesis.tuladhaapp.model.detailcourse

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BenefitData(
    val id: Int? = null,
    val no: Int?= null,
    val description: String? = null,
) : Parcelable
