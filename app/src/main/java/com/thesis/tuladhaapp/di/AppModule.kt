package com.thesis.tuladhaapp.di

import com.google.firebase.auth.FirebaseAuth
import com.thesis.tuladhaapp.data.dataSource.Category.DataSourceCategory
import com.thesis.tuladhaapp.data.dataSource.Category.DummyCategoryDataSource
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.DataSourceDetailCourse
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.DummyDetailCourseDataSource
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.benefitCourse.DataSourceBenefit
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.benefitCourse.DummyBenefitCourseDataSource
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.chapterData.DataSourseChapterData
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.chapterData.DummyChapterDataSource
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.moduleData.DummyModuleDataDataSource
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.moduleData.ModuleDataSource
import com.thesis.tuladhaapp.data.dataSource.course.DataSourceCourse
import com.thesis.tuladhaapp.data.dataSource.course.DummyCourseDataSource
import com.thesis.tuladhaapp.data.dataSource.typePareting.DataSourceTypeParenting
import com.thesis.tuladhaapp.data.dataSource.typePareting.DataTypeParentingImpl
import com.thesis.tuladhaapp.data.dataSource.user.DataSourceUsers
import com.thesis.tuladhaapp.data.dataSource.user.DataSourceUsersImpl
import com.thesis.tuladhaapp.repository.CategoriesHome.CategoriesRepository
import com.thesis.tuladhaapp.repository.CategoriesHome.CategoriesRepositoryImpl
import com.thesis.tuladhaapp.repository.courseHome.CourseRepository
import com.thesis.tuladhaapp.repository.courseHome.CourseRepositoryImpl
import com.thesis.tuladhaapp.repository.typeParenting.TypeParentingRepository
import com.thesis.tuladhaapp.repository.typeParenting.TypeParentingRepositoryImpl
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import com.thesis.tuladhaapp.repository.userRepository.UserRepositoryImpl
import com.thesis.tuladhaapp.source.firebase.FirebaseService
import com.thesis.tuladhaapp.source.firebase.FirebaseServiceImpl
import com.thesis.tuladhaapp.ui.allPremiumCourse.AllPremiumCourseViewModel
import com.thesis.tuladhaapp.ui.auth.login.LoginViewModel
import com.thesis.tuladhaapp.ui.auth.register.RegisterViewModel
import com.thesis.tuladhaapp.ui.course.CourseViewModel
import com.thesis.tuladhaapp.ui.dashboard.DashboardViewModel
import com.thesis.tuladhaapp.ui.detailCourse.DetailCourseViewModel
import com.thesis.tuladhaapp.ui.home.HomeViewModel
import com.thesis.tuladhaapp.ui.main.MainViewModel
import com.thesis.tuladhaapp.ui.profile.ProfileViewModel
import com.thesis.tuladhaapp.ui.testPolaAsuh.QuickStartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.get
import org.koin.dsl.module
import kotlin.math.sin

object AppModule {
    fun getModules(): List<Module> = listOf(
        viewModels,
        repository,
        dataSource,
        firebaseModule,
    )
    private val viewModels = module {
        viewModel { HomeViewModel(get(), get(), get()) }
        viewModel { CourseViewModel(get(), get()) }
        viewModel {DashboardViewModel()}
        viewModel {RegisterViewModel(get())}
        viewModel { LoginViewModel(get()) }
        viewModel { AllPremiumCourseViewModel(get(), get()) }
        viewModel { ProfileViewModel(get()) }
        viewModel { MainViewModel(get()) }
        viewModel { QuickStartViewModel(get()) }
        viewModel { params -> DetailCourseViewModel(params.get(), get()) }
    }

    private val repository = module {
        single<CategoriesRepository> { CategoriesRepositoryImpl(get()) }
        single<CourseRepository> { CourseRepositoryImpl(get(), get()) }
        single<UserRepository> { UserRepositoryImpl(get()) }
        single<TypeParentingRepository> { TypeParentingRepositoryImpl(get()) }
    }
    private val dataSource = module {
        single <DataSourceCategory> { DummyCategoryDataSource() }
        single <DataSourceCourse> { DummyCourseDataSource() }
        single <DataSourceBenefit> { DummyBenefitCourseDataSource() }
        single <DataSourceTypeParenting> { DataTypeParentingImpl() }

        single <DataSourseChapterData> { DummyChapterDataSource() }
        single <DataSourceUsers> { DataSourceUsersImpl(get()) }
        single <DataSourceDetailCourse> { DummyDetailCourseDataSource(get(),get(),get()) }

    }
    private val firebaseModule =
        module {
            single<FirebaseService> { FirebaseServiceImpl() }
            single<FirebaseAuth> { FirebaseAuth.getInstance() }
        }

    }

