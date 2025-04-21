package com.thesis.tuladhaapp.data.dataSource.Category

import com.thesis.tuladhaapp.model.category.Category

interface DataSourceCategory {
    fun getCategories(): List<Category>
}