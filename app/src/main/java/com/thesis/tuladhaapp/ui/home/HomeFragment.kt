package com.thesis.tuladhaapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.faltenreich.skeletonlayout.applySkeleton
import com.google.android.gms.common.api.ApiException
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.FragmentHomeBinding
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.ui.home.adapter.CategoryAdapter
import com.thesis.tuladhaapp.utils.SkeletonConfigWrapper
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()

    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter {
            navigateToCourseByCategory(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        observeCategoryData()
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    private fun setClickListener() {

        binding.searchBar.ivSearchButton.setOnClickListener {
            performSearch()
        }
        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun performSearch() {
        val query = binding.searchBar.etSearchBar.text.toString()
        navigateSearchToCourseFragment(query)
        binding.searchBar.etSearchBar.text.clear()
    }

    private fun navigateToCourseByCategory(category: Category) {
        val action = HomeFragmentDirections.actionNavigationHomeToNavigationCourse(null, category)
        findNavController().navigate(action)
    }

    private fun navigateSearchToCourseFragment(query: String) {
        val action = HomeFragmentDirections.actionNavigationHomeToNavigationCourse(query, null)
        findNavController().navigate(action)
    }

    private fun observeCategoryData() {
        homeViewModel.categories.observe(viewLifecycleOwner) { resultWrapper ->
            resultWrapper.proceedWhen(
                doOnSuccess = {
                    binding.layoutStateCategories.root.isVisible = false
                    binding.layoutStateCategories.loadingAnimation.isVisible = false
                    binding.layoutStateCategories.tvError.isVisible = false
                    binding.rvListCategories.apply {
                        isVisible = true
                        adapter = categoryAdapter
                    }
                    it.payload?.let { data -> categoryAdapter.submitData(data) }
                },
                doOnLoading = {
                    binding.layoutStateCategories.root.isVisible = false
                    binding.layoutStateCategories.loadingAnimation.isVisible = false
                    binding.layoutStateCategories.tvError.isVisible = false
                    binding.rvListCategories.isVisible = true
                    binding.rvListCategories.applySkeleton(
                        R.layout.item_grid_categories,
                        itemCount = 8,
                        SkeletonConfigWrapper(requireContext()).customSkeletonConfig()
                    ).showSkeleton()
                },
                doOnError = {
                    binding.layoutStateCategories.root.isVisible = true
                    binding.layoutStateCategories.loadingAnimation.isVisible = false
                    binding.layoutStateCategories.tvError.isVisible = true
                    if (it.exception is ApiException) {
                        binding.layoutStateCategories.tvError.text =
                            getString(R.string.exception_notif)
                    }
                    binding.rvListCategories.isVisible = false
                }
            )
        }
    }

    private fun observePopularCourseCategoryData() {
        homeViewModel.popularCourseCategories.observe(viewLifecycleOwner) { resultWrapper ->
            resultWrapper.proceedWhen(
                doOnSuccess = {
                    binding.layoutStatePopularCategories.root.isVisible = false
                    binding.layoutStatePopularCategories.loadingAnimation.isVisible = false
                    binding.layoutStatePopularCategories.tvError.isVisible = false
                    binding.rvCategoryPopularCourse.apply {
                        isVisible = true
                        adapter = popularCourseCategoryAdapter
                    }
                    it.payload?.let { data -> popularCourseCategoryAdapter.submitData(data) }
                },
                doOnLoading = {
                    binding.layoutStatePopularCategories.root.isVisible = false
                    binding.layoutStatePopularCategories.loadingAnimation.isVisible = false
                    binding.layoutStatePopularCategories.tvError.isVisible = false
                    binding.rvCategoryPopularCourse.isVisible = true
                    binding.rvCategoryPopularCourse.applySkeleton(
                        R.layout.item_list_category,
                        itemCount = 8,
                        SkeletonConfigWrapper(requireContext()).customSkeletonConfig()
                    ).showSkeleton()
                },
                doOnError = {
                    binding.layoutStatePopularCategories.root.isVisible = true
                    binding.layoutStatePopularCategories.loadingAnimation.isVisible = false
                    binding.layoutStatePopularCategories.tvError.isVisible = true
                    if (it.exception is ApiException) {
                        binding.layoutStatePopularCategories.tvError.text =
                            it.exception.getParsedError()?.message.orEmpty()
                    }
                    binding.rvCategoryPopularCourse.isVisible = false
                }
            )
        }
    }


    private fun getData() {
    homeViewModel.getCategories()
    }


}