package com.thesis.tuladhaapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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
    private val _childAgeRanges = MutableLiveData<List<String>>()
    val childAgeRanges: LiveData<List<String>> = _childAgeRanges

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("childData")


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

    fun getCourses(
        search: String? = null,
        type: Int? = null,
        category: List<Int>? = null,
        level: List<String>? = null,
        sortBy: String? = null
    ) {
        val mutableCategory: MutableList<Int> = category?.toMutableList() ?: mutableListOf()
        type?.let {
            mutableCategory.add(it)
        }
        viewModelScope.launch {
            courseRepository.getCoursesClass(
                search = null,
                type = search,
                category = mutableCategory,
                level = level,
                sortBy = null
            ).collect {
                _courses.postValue(it)
            }
        }
    }

    fun getAllChildAgeRanges() {
        val userId = getCurrentUser()?.id
        if (userId == null) {
            _childAgeRanges.postValue(emptyList())
            return
        }

        val childrenRef = database.child(userId).child("children")
        childrenRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val ageRangesList = mutableListOf<String>()
                if (snapshot.exists()) {
                    for (childSnapshot in snapshot.children) {
                        val ageRange = childSnapshot.child("ageRange").getValue(String::class.java)
                        ageRange?.let {
                            ageRangesList.add(it)
                        }
                    }
                }
                _childAgeRanges.postValue(ageRangesList) // Perbarui LiveData

            }

            override fun onCancelled(error: DatabaseError) {
                _childAgeRanges.postValue(emptyList())
            }
        })
    }

}
