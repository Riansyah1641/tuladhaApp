package com.thesis.tuladhaapp.repository.typeParenting

import com.thesis.tuladhaapp.model.testpolaasuh.TypeParenting

interface TypeParentingRepository {
   suspend fun getTypeParenting(id: Int): TypeParenting?
}