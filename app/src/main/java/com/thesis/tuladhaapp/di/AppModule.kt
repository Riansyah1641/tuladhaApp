package com.thesis.tuladhaapp.di

import com.thesis.tuladhaapp.data.dataSource.Category.DataSourceCategory
import com.thesis.tuladhaapp.data.dataSource.Category.DummyCategoryDataSource
import com.thesis.tuladhaapp.data.dataSource.course.DataSourceCourse
import com.thesis.tuladhaapp.data.dataSource.course.DummyCourseDataSource
import com.thesis.tuladhaapp.repository.CategoriesHome.CategoriesRepository
import com.thesis.tuladhaapp.repository.CategoriesHome.CategoriesRepositoryImpl
import com.thesis.tuladhaapp.repository.courseHome.CourseRepository
import com.thesis.tuladhaapp.repository.courseHome.CourseRepositoryImpl
import com.thesis.tuladhaapp.ui.dashboard.DashboardViewModel
import com.thesis.tuladhaapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule {
    fun getModules(): List<Module> = listOf(
        viewModels,
        repository,
        dataSource,
    )
    private val viewModels = module {
        viewModel { HomeViewModel(get(), get()) }
        viewModel {DashboardViewModel()}
    }

    private val repository = module {
        single<CategoriesRepository> { CategoriesRepositoryImpl(get()) }
        single<CourseRepository> { CourseRepositoryImpl(get()) }
    }
    private val dataSource = module {
        single <DataSourceCategory> { DummyCategoryDataSource() }
        single <DataSourceCourse> { DummyCourseDataSource() }
    }

    }

