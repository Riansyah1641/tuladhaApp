package com.thesis.tuladhaapp.ui.allPremiumCourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.model.course.Course
import com.thesis.tuladhaapp.repository.CategoriesHome.CategoriesRepository
import com.thesis.tuladhaapp.repository.courseHome.CourseRepository
import com.thesis.tuladhaapp.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllPremiumCourseViewModel(
    private val repository: CourseRepository,
    private val categoriesRepository: CategoriesRepository
) : ViewModel() {

    companion object {
        const val SORT_BY_POPULAR = "terpopuler"
    }

    private val _categories = MutableLiveData<ResultWrapper<List<Category>>>()
    val categories: LiveData<ResultWrapper<List<Category>>>
        get() = _categories

    private val _selectedCategory = MutableLiveData<Category>()
    val selectedCategory: LiveData<Category>
        get() = _selectedCategory

    private val _courses = MutableLiveData<ResultWrapper<List<Course>>>()
    val courses: LiveData<ResultWrapper<List<Course>>>
        get() = _courses

    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String>
        get() = _searchQuery


    private val _selectedType = MutableLiveData<String>()
    val selectedType: LiveData<String>
        get() = _selectedType


    fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            categoriesRepository.getCategories().collect { result ->
                if (result is ResultWrapper.Success && result.payload != null) {
                    val allCategory = Category(id = 0, categoryImage = "", categoryName = "All")
                    val newCategories = mutableListOf(allCategory)
                    newCategories.addAll(result.payload)
                    _categories.postValue(ResultWrapper.Success(newCategories))
                } else {
                    _categories.postValue(result)
                }
            }
        }
    }


    fun getCourses(
        search: String? = null,
        type: String? = null,
        category: List<Int>? = null,
        level: List<String>? = null,
        sortBy: String? = null
    ) {
        viewModelScope.launch {
            repository.getCoursesClass(
                search = search,
                type = if (type == "all") null else type,
                category = category,
                level = level,
                sortBy = sortBy
            ).collect {
                _courses.postValue(it)
            }
        }
    }

    fun changeSelectedCategory(newCategory: Category) {
        _selectedCategory.value = newCategory
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setSelectedType(type: String) {
        _selectedType.value = type
    }
}