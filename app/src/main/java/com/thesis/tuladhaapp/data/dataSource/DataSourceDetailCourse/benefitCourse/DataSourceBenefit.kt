package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.benefitCourse

import com.thesis.tuladhaapp.model.detailcourse.BenefitData

interface DataSourceBenefit {
    suspend fun getBenefitsForCourse(courseId: Int?): List<BenefitData>
}