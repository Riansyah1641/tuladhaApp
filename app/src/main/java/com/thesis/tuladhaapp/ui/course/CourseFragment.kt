package com.thesis.tuladhaapp.ui.course

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.FragmentCourseBinding
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.ui.course.filtercourse.FilterDialogFragment
import com.thesis.tuladhaapp.ui.detailCourse.DetailCourseActivity
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel


class CourseFragment : Fragment(), FilterDialogFragment.OnFilterListener {
    private lateinit var binding: FragmentCourseBinding
    private val filterDialogFragment: FilterDialogFragment by lazy {
        FilterDialogFragment()
    }

    private val viewModel: CourseViewModel by viewModel()

    private var searchQuery: String? = null
    private var selectedType: String? = null
    private var selectedCategories: List<Category>? = null
    private var selectedLevel: List<String>? = null
    private var selectedSortBy: String? = null

    //adapter
    private val courseItemAdapter: CourseItemAdapter by lazy {
        CourseItemAdapter() {
            itemCourseListener(it.id)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeCourseList()
        openFilterDialog()
        setType()
        //setupSearch()
        observeFilterData()
        // receivedArguments()
        // refreshData()
        // buildChipItem()
        viewModel.resetFilter()
    }

    private fun itemCourseListener(courseId: Int?) {
        navigateToDetailCourse(courseId)
    }

    private fun navigateToDetailCourse(courseId: Int?) {
        DetailCourseActivity.startActivity(requireContext(), courseId)
    }

    private fun getData(
        search: String? = null,
        type: String? = null,
        category: List<Category>? = null,
        level: List<String>? = null,
        sortBy: String? = null
    ) {
        val categoryIdList = category?.map {
            it.id
        }
        viewModel.getCourses(search, type, categoryIdList, level, sortBy)
    }

    private fun refreshData() {
        binding.swipeRefresh.setOnRefreshListener {
            getData(searchQuery, selectedType, selectedCategories, selectedLevel, selectedSortBy)
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun setType() {
        binding.btnAll.setOnClickListener {
            viewModel.setSelectedType(TYPE_ALL)
        }
        binding.btnPremium.setOnClickListener {
            viewModel.setSelectedType(TYPE_PREMIUM)
        }
        binding.btnFree.setOnClickListener {
            viewModel.setSelectedType(TYPE_FREE)
        }
    }

    private fun setupSearch() {
        binding.searchBar.etSearchBar.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || event?.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER) {
                val searchQuery = binding.searchBar.etSearchBar.text.toString()
                viewModel.setSearchQuery(searchQuery)
                this.searchQuery = searchQuery
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }

    private fun observeFilterData() {
        viewModel.searchQuery.observe(viewLifecycleOwner) { query ->
            searchQuery = query
            getData(searchQuery, selectedType, selectedCategories, selectedLevel, selectedSortBy)
        }
        viewModel.selectedType.observe(viewLifecycleOwner) { type ->
            selectedType = type
            getData(searchQuery, selectedType, selectedCategories, selectedLevel, selectedSortBy)
        }
    }

    private fun receivedArguments() {
        val category = arguments?.getParcelable<Category>(KEY_CATEGORY)
        if (category == null) {
            selectedCategories = null
            binding.layoutStateClassTopic.root.isVisible = true
            binding.rvListCourse.isVisible = false
        } else {
            selectedCategories = listOf(category)
            viewModel.addSelectedCategory(category)
            binding.layoutStateClassTopic.root.isVisible = false
        }
        val query = arguments?.getString(KEY_QUERY)
        if (!query.isNullOrEmpty()) {
            searchQuery = query
            viewModel.setSearchQuery(query)
            binding.searchBar.etSearchBar.setText(query)
            binding.layoutStateClassTopic.root.isVisible = false
            binding.rvListCourse.isVisible = true
        } else {
            searchQuery = null
            binding.layoutStateClassTopic.root.isVisible = true
            binding.rvListCourse.isVisible = false
        }
        getData(searchQuery, selectedType, selectedCategories, selectedLevel, selectedSortBy)
        arguments = null
    }

    private fun buildChipItem() {
        if (selectedCategories != null) {
            selectedCategories?.map {
                addChipToGroup(it.categoryName)
            }

        }
        if (selectedLevel != null) {
            selectedLevel?.map {
                addChipToGroup(it)
            }

        }
        if (selectedSortBy != null) {
            addChipToGroup(selectedSortBy)

        }
    }

    private fun addChipToGroup(chipItem: String?) {
        if (!chipItem.isNullOrBlank()) {
            val chip = Chip(context, null, R.attr.CustomChipChoiceStyle)
            chip.text = chipItem
            chip.isChipIconVisible = false
            chip.isCheckable = false
            binding.chipGroup.addView(chip as View)
        }
    }

    private fun observeCourseList() {
        viewModel.courses.observe(viewLifecycleOwner) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.layoutStateClassTopic.root.isVisible = false
                    binding.layoutStateClassTopic.loadingAnimation.isVisible = false
                    binding.layoutStateClassTopic.tvError.isVisible = false
                    binding.rvListCourse.apply {
                        isVisible = true
                        adapter = courseItemAdapter
                    }
                    it.payload?.let { data ->

                        courseItemAdapter.submitData(data)
                    }
                },
                doOnLoading = {
                    binding.layoutStateClassTopic.root.isVisible = true
                    binding.layoutStateClassTopic.loadingAnimation.isVisible = true
                    binding.layoutStateClassTopic.tvError.isVisible = false
                    binding.rvListCourse.isVisible = false
                },
                doOnError = {
                    binding.layoutStateClassTopic.root.isVisible = true
                    binding.layoutStateClassTopic.loadingAnimation.isVisible = false
                    binding.rvListCourse.isVisible = false
                }
            )
        }
    }

    private fun openFilterDialog() {
        binding.tvFilter.setOnClickListener {
            filterDialogFragment.setFilterListener(this)
            filterDialogFragment.show(childFragmentManager, TAG_DIALOG)
        }
    }

    override fun onFilterApplied(
        search: String?,
        type: String?,
        category: List<Category>?,
        level: List<String>?,
        sortBy: String?
    ) {
        searchQuery = search
        selectedCategories = category
        selectedLevel = level
        selectedSortBy = sortBy
        val categoryIdList = category?.map {
            it.id
        }
        viewModel.getCourses(searchQuery, selectedType, categoryIdList, level, sortBy)
        binding.chipGroup.removeAllViews()
        buildChipItem()
    }

    companion object {
        const val TYPE_ALL = "all"
        const val TYPE_PREMIUM = "premium"
        const val TYPE_FREE = "gratis"
        const val KEY_QUERY = "searchQuery"
        const val KEY_CATEGORY = "selectedCategory"
        const val TAG_DIALOG = "FilterDialog"
    }
}