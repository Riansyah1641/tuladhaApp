package com.thesis.tuladhaapp.model.kuis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Assesment (
    val id: Int,
    val title: String,
    val deskripsi: String,
): Parcelable