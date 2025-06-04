package com.thesis.tuladhaapp.ui.allPremiumCourse

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.thesis.tuladhaapp.databinding.ActivityAllPremiumCourseBinding
import com.thesis.tuladhaapp.databinding.DialogNonLoginBinding
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.ui.allPremiumCourse.adapter.PopularCourseAdapter
import com.thesis.tuladhaapp.ui.auth.login.LoginActivity
import com.thesis.tuladhaapp.ui.detailCourse.DetailCourseActivity
import com.thesis.tuladhaapp.ui.profile.ProfileViewModel
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllPremiumCourseActivity : AppCompatActivity() {
    private val binding: ActivityAllPremiumCourseBinding by lazy {
        ActivityAllPremiumCourseBinding.inflate(layoutInflater)
    }
    private val viewModel: AllPremiumCourseViewModel by viewModel()
    private val profileViewModel: ProfileViewModel by viewModel()


    private val courseAdapter: PopularCourseAdapter by lazy {
        PopularCourseAdapter {
            itemCourseListener(it.id)
        }
    }

    private var selectedType: String? = null

    private fun itemCourseListener(courseId: Int?) {
        if (profileViewModel.isUserLoggedIn()) {
            navigateToDetailCourse(courseId)
        } else {
            loginDialog()
        }
    }


    private var searchQuery: String? = null
    private var selectedCategory: Int? = null
    private var selectedCategories: List<Category>? = null
    private var selectedLevel: List<String>? = null
    private var selectedSortBy: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getData()
        observeCourseList()
        observeFilterData()
        setupSearch()
        setClickListener()
    }

    private fun loginDialog() {
        val binding: DialogNonLoginBinding = DialogNonLoginBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this, 0).create()

        dialog.apply {
            setView(binding.root)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }.show()

        binding.clSignUp.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToDetailCourse(courseId: Int?) {
        DetailCourseActivity.startActivity(this, courseId)
    }

    private fun observeFilterData() {
        viewModel.searchQuery.observe(this) { query ->
            searchQuery = query
            getData(searchQuery, selectedType, selectedCategories, selectedLevel, selectedSortBy)
        }
        viewModel.selectedCategory.observe(this) { category ->
            selectedCategory = category.id
            getData(searchQuery, selectedType, selectedCategories, selectedLevel, selectedSortBy)
        }
        viewModel.selectedType.observe(this) { type ->
            selectedType = type
            getData(searchQuery, selectedType, selectedCategories, selectedLevel, selectedSortBy)
        }
    }

    private fun setClickListener() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.swipeRefresh.setOnRefreshListener {
            refreshData()
        }
    }

    private fun refreshData() {
        getData(searchQuery, selectedType, selectedCategories, selectedLevel, selectedSortBy)
        binding.swipeRefresh.isRefreshing = false
    }

    private fun setupSearch() {
        binding.searchBar.etSearchBar.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || event?.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER) {
                val searchQuery = binding.searchBar.etSearchBar.text.toString()
                viewModel.setSearchQuery(searchQuery)
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        binding.searchBar.ivSearchButton.setOnClickListener {
            val searchQuery = binding.searchBar.etSearchBar.text.toString()
            viewModel.setSearchQuery(searchQuery)
        }
    }


    private fun getData(
        search: String? = null,
        type: String? = null,
        category: List<Category>? = null,
        level: List<String>? = null,
        sortBy: String? = null
    ) {
        viewModel.getCategories()
        val categoryIdList = category?.map {
            it.id
        }
        viewModel.getCourses(search, type, categoryIdList, level, sortBy)
    }


    private fun observeCourseList() {
        viewModel.courses.observe(this) { resultWrapper ->
            resultWrapper.proceedWhen(
                doOnSuccess = {
                    binding.layoutStatePopularCourse.root.isVisible = false
                    binding.layoutStatePopularCourse.loadingAnimation.isVisible = false
                    binding.layoutStatePopularCourse.tvError.isVisible = false

                    binding.rvListCourse.apply {
                        isVisible = true
                        adapter = courseAdapter
                    }
                    it.payload?.let { data -> courseAdapter.submitData(data) }
                },
                doOnLoading = {
                    binding.layoutStatePopularCourse.root.isVisible = true
                    binding.layoutStatePopularCourse.loadingAnimation.isVisible = true
                    binding.layoutStatePopularCourse.tvError.isVisible = false

                    binding.rvListCourse.isVisible = false
                },
                doOnError = {
                    binding.layoutStatePopularCourse.root.isVisible = true
                    binding.layoutStatePopularCourse.loadingAnimation.isVisible = false
                }
            )
        }

    }
}