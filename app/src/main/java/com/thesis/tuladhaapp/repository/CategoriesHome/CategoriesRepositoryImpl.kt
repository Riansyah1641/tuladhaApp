package com.thesis.tuladhaapp.repository.CategoriesHome

import com.thesis.tuladhaapp.data.dataSource.Category.DataSourceCategory
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.utils.ResultWrapper
import com.thesis.tuladhaapp.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

class CategoriesRepositoryImpl(private val dataDummy: DataSourceCategory): CategoriesRepository {

    override fun getCategories(): Flow<ResultWrapper<List<Category>>> {
        return proceedFlow {
            dataDummy.getCategories()
        }
    }
}