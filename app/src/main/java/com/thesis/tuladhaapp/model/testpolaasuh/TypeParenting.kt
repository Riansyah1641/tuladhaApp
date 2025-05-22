package com.thesis.tuladhaapp.model.testpolaasuh

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeParenting (
    val id: Int?,
    val name: String?,
    val deskripsi: String?,
): Parcelable