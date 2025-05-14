package com.thesis.tuladhaapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thesis.tuladhaapp.model.course.Course
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.repository.CategoriesHome.CategoriesRepository
import com.thesis.tuladhaapp.repository.courseHome.CourseRepository
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: CategoriesRepository , private val courseRepository: CourseRepository, private val userRepository: UserRepository) : ViewModel() {

    companion object {
        const val LIMIT_COURSE_SIZE = 6
        const val SORT_BY_POPULAR = "terpopuler"
    }

    //categories section
    private val _categories = MutableLiveData<ResultWrapper<List<Category>>>()
    val categories: LiveData<ResultWrapper<List<Category>>>
        get() = _categories

    fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCategories().collect {
                _categories.postValue(it)
            }
        }
    }

    fun getCurrentUser() = userRepository.getCurrentUser()

    fun isUserLoggedIn() = userRepository.isLoggedIn()

    // get populer category
    private val _popularCourseCategories = MutableLiveData<ResultWrapper<List<Category>>>()
    val popularCourseCategories: LiveData<ResultWrapper<List<Category>>>
        get() = _popularCourseCategories

    fun getPopularCourseCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCategories().collect { result ->
                if (result is ResultWrapper.Success && result.payload != null) {
                    val allCategory = Category(id = 0, categoryImage = "", categoryName = "All")
                    val newCategories = mutableListOf(allCategory)
                    newCategories.addAll(result.payload)
                    _popularCourseCategories.postValue(ResultWrapper.Success(newCategories))
                } else {
                    _popularCourseCategories.postValue(result)
                }
            }
        }
    }

    // get selecter category
    private val _selectedCategory = MutableLiveData<Category>()
    val selectedCategory: LiveData<Category>
        get() = _selectedCategory

    fun changeSelectedCategory(newCategory: Category) {
        _selectedCategory.value = newCategory
    }

    // get courses
    private val _courses = MutableLiveData<ResultWrapper<List<Course>>>()
    val courses: LiveData<ResultWrapper<List<Course>>>
        get() = _courses

    fun getCourses(categoryId: Int? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            courseRepository.getCourses(
                category = if (categoryId == 0) null else categoryId,
                sortBy = SORT_BY_POPULAR
            ).collect { result ->
                if (result is ResultWrapper.Success && result.payload != null) {
                    val limitCourse = result.payload.take(LIMIT_COURSE_SIZE)
                    _courses.postValue(ResultWrapper.Success(limitCourse))
                } else {
                    _courses.postValue(result)
                }
            }
        }
    }

}
