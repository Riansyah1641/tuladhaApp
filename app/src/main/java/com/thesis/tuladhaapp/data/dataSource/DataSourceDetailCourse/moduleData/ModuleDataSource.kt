package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.moduleData

import com.thesis.tuladhaapp.model.detailcourse.UserModuleData

interface ModuleDataSource {
    fun getModulesForChapter(chapterId: Int): List<UserModuleData>
}
