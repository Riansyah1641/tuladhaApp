package com.thesis.tuladhaapp.ui.home

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.faltenreich.skeletonlayout.applySkeleton
import com.thesis.tuladhaapp.AssesCourseActivity
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.DialogNonLoginBinding
import com.thesis.tuladhaapp.databinding.FragmentHomeBinding
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.ui.allPremiumCourse.AllPremiumCourseActivity
import com.thesis.tuladhaapp.ui.auth.login.LoginActivity
import com.thesis.tuladhaapp.ui.auth.register.RegisterActivity
import com.thesis.tuladhaapp.ui.detailCourse.DetailCourseActivity
import com.thesis.tuladhaapp.ui.home.adapter.CategoryAdapter
import com.thesis.tuladhaapp.ui.home.adapter.CourseAdapter
import com.thesis.tuladhaapp.ui.home.adapter.PopularCourseCategoryAdapter
import com.thesis.tuladhaapp.ui.kuisCourse.QuizActivity
import com.thesis.tuladhaapp.ui.main.MainViewModel
import com.thesis.tuladhaapp.ui.profile.ProfileActivity
import com.thesis.tuladhaapp.ui.testPolaAsuh.QuickStartActivity
import com.thesis.tuladhaapp.ui.testPolaAsuh.SplashTesPolaAsuhActivity
import com.thesis.tuladhaapp.utils.SkeletonConfigWrapper
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment() : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()
    private val mainViewModel: MainViewModel by activityViewModel()

    //define adapter
    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter {
            navigateToCourseByCategory(it)
        }
    }
    private val popularCourseCategoryAdapter: PopularCourseCategoryAdapter by lazy {
        PopularCourseCategoryAdapter { category ->
            homeViewModel.changeSelectedCategory(category)
        }
    }
    private val courseAdapter: CourseAdapter by lazy {
        CourseAdapter {
            itemCourseListener(it.id)
        }
    }

    private fun itemCourseListener(courseId: Int?) {
        navigateToDetailCourse(courseId)
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
        observePopularCourseCategoryData()
        observeSelectedCategory()
        observeCourseData()
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    private fun navigateToDetailCourse(courseId: Int?) {
        DetailCourseActivity.startActivity(requireContext(), courseId)
    }

    private fun setClickListener() {

        binding.searchBar.ivSearchButton.setOnClickListener {
            performSearch()
        }
        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.isRefreshing = false
        }
        binding.icProfile.setOnClickListener {
            if (homeViewModel.isUserLoggedIn()) {
                navigateToProfile()
            } else {
                showDialog()
            }
        }

        binding.tvSeeAllCourse.setOnClickListener {
            navigateToAllPremiumCourse()
        }
        binding.btnStartTest.setOnClickListener {
            navigateToTestPolaAsuh()
        }
        binding.tvCourseText.setOnClickListener {
            val intent = Intent(requireContext(), AssesCourseActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToTestPolaAsuh() {
        val intent = Intent(requireContext(), SplashTesPolaAsuhActivity::class.java)
        startActivity(intent)
    }


    private fun navigateToAllPremiumCourse() {
        val intent = Intent(requireContext(), AllPremiumCourseActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToProfile() {
        if (isAdded) {
            val context = requireActivity()
            val intent = Intent(context, ProfileActivity::class.java)
            startActivity(intent)
            requireActivity().overridePendingTransition(
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
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


    private fun showDialog() {
        val binding: DialogNonLoginBinding = DialogNonLoginBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(requireContext(), 0).create()

        dialog.apply {
            setView(binding.root)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }.show()

        binding.clSignUp.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }
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
                    binding.layoutStateCategories.tvError.text =
                        getString(R.string.exception_notif)
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
                    binding.layoutStatePopularCategories.tvError.text =
                        getString(R.string.exception_notif)
                    binding.rvCategoryPopularCourse.isVisible = false
                }
            )
        }
    }

    private fun observeSelectedCategory() {
        homeViewModel.selectedCategory.observe(viewLifecycleOwner) {
            popularCourseCategoryAdapter.setSelectedCategory(it)
        }
    }

    private fun observeCourseData() {
        homeViewModel.courses.observe(viewLifecycleOwner) { resultWrapper ->
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
                    binding.layoutStatePopularCourse.tvError.isVisible = true
                    binding.layoutStatePopularCourse.tvError.text =
                        getString(R.string.text_sorry_course_not_found)
                    binding.rvListCourse.isVisible = false
                }
            )
        }
    }

    private fun getData() {
        homeViewModel.getCategories()
        homeViewModel.getPopularCourseCategories()
        homeViewModel.getCourses()
    }

}