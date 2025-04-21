package com.thesis.tuladhaapp.repository.CategoriesHome

import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {
    fun getCategories(): Flow<ResultWrapper<List<Category>>>
}