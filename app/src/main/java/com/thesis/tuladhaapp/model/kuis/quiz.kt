package com.thesis.tuladhaapp.model.kuis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quiz(
    val id: Int = 0,
    val question: String = "",
    val option1: String = "",
    val option2: String = "",
    val option3: String = "",
    val option4: String = "",
    val answer: String = ""
): Parcelable