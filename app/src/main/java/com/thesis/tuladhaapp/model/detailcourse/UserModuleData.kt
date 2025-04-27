package com.thesis.tuladhaapp.model.detailcourse

import android.os.Parcelable
import com.thesis.tuladhaapp.model.detailcourse.ModuleDataData
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModuleData(
    val id: Int?,
    val status: String?,
    val moduleData: ModuleDataData?
) : Parcelable
