package com.thesis.tuladhaapp.data.dataSource.typePareting

import com.thesis.tuladhaapp.model.testpolaasuh.TypeParenting

interface DataSourceTypeParenting {
    suspend fun getTypeParenting(id: Int): TypeParenting?
}