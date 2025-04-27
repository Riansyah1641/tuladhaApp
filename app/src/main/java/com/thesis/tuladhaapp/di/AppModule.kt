package com.thesis.tuladhaapp.di

import com.thesis.tuladhaapp.data.dataSource.Category.DataSourceCategory
import com.thesis.tuladhaapp.data.dataSource.Category.DummyCategoryDataSource
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.DataSourceDetailCourse
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.DummyDetailCourseDataSource
import com.thesis.tuladhaapp.data.dataSource.course.DataSourceCourse
import com.thesis.tuladhaapp.data.dataSource.course.DummyCourseDataSource
import com.thesis.tuladhaapp.data.dataSource.user.DataSourceUsers
import com.thesis.tuladhaapp.data.dataSource.user.DataSourceUsersImpl
import com.thesis.tuladhaapp.repository.CategoriesHome.CategoriesRepository
import com.thesis.tuladhaapp.repository.CategoriesHome.CategoriesRepositoryImpl
import com.thesis.tuladhaapp.repository.courseHome.CourseRepository
import com.thesis.tuladhaapp.repository.courseHome.CourseRepositoryImpl
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import com.thesis.tuladhaapp.repository.userRepository.UserRepositoryImpl
import com.thesis.tuladhaapp.ui.course.CourseViewModel
import com.thesis.tuladhaapp.ui.dashboard.DashboardViewModel
import com.thesis.tuladhaapp.ui.detailCourse.DetailCourseViewModel
import com.thesis.tuladhaapp.ui.home.HomeViewModel
import com.thesis.tuladhaapp.ui.main.MainViewModel
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
        viewModel { CourseViewModel(get(), get()) }
        viewModel {DashboardViewModel()}
        viewModel { MainViewModel(get()) }
        viewModel { params -> DetailCourseViewModel(params.get(), get()) }
    }

    private val repository = module {
        single<CategoriesRepository> { CategoriesRepositoryImpl(get()) }
        single<CourseRepository> { CourseRepositoryImpl(get(), get()) }
        single<UserRepository> { UserRepositoryImpl(get()) }
    }
    private val dataSource = module {
        single <DataSourceCategory> { DummyCategoryDataSource() }
        single <DataSourceCourse> { DummyCourseDataSource() }
        single <DataSourceUsers> { DataSourceUsersImpl() }
        single <DataSourceDetailCourse> { DummyDetailCourseDataSource(get()) }

    }

    }

