package com.thesis.tuladhaapp.model.category

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: Int,
    val categoryImage: String,
    val categoryName: String
) : Parcelable
