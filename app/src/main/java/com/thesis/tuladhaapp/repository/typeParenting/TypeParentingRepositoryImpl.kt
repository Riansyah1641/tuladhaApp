package com.thesis.tuladhaapp.repository.typeParenting

import com.thesis.tuladhaapp.data.dataSource.course.DataSourceCourse
import com.thesis.tuladhaapp.data.dataSource.typePareting.DataSourceTypeParenting
import com.thesis.tuladhaapp.model.testpolaasuh.TypeParenting

class TypeParentingRepositoryImpl(private val dataSource: DataSourceTypeParenting): TypeParentingRepository {
    override suspend fun getTypeParenting(id: Int): TypeParenting? {
        return dataSource.getTypeParenting(id)
    }
}