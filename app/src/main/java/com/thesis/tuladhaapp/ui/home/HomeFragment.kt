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
import com.shashank.sony.fancytoastlib.FancyToast
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.DialogNonLoginBinding
import com.thesis.tuladhaapp.databinding.DialogNonTestpolaasuhBinding
import com.thesis.tuladhaapp.databinding.FragmentHomeBinding
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.ui.allPremiumCourse.AllPremiumCourseActivity
import com.thesis.tuladhaapp.ui.auth.login.LoginActivity
import com.thesis.tuladhaapp.ui.detailCourse.DetailCourseActivity
import com.thesis.tuladhaapp.ui.home.adapter.CategoryAdapter
import com.thesis.tuladhaapp.ui.home.adapter.CourseAdapter
import com.thesis.tuladhaapp.ui.home.adapter.PopularCourseCategoryAdapter
import com.thesis.tuladhaapp.ui.profile.ProfileActivity
import com.thesis.tuladhaapp.ui.profile.ProfileViewModel
import com.thesis.tuladhaapp.ui.testPolaAsuh.SplashTesPolaAsuhActivity
import com.thesis.tuladhaapp.utils.SkeletonConfigWrapper
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment() : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()
    private val profileViewModel: ProfileViewModel by viewModel()
    private var checkTesPolaAsuh = false
    private var levels: List<String>? = null
    var typeAsuh = "";

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
            if (it.type == "umum") {
                itemCourseListener(it.id)
            } else {
                if (homeViewModel.isUserLoggedIn()) {
                    getProfileData()
                    if (checkTesPolaAsuh == true) {
                        itemCourseListener(it.id)
                    } else {
                        showDialogTest()
                    }
                } else {
                    showDialog()
                }
            }
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
        checkIfUserLogin()


        observePopularCourseCategoryData()
        observeSelectedCategory()
        observeCourseData()
    }

    override fun onResume() {
        homeViewModel.getAllChildAgeRanges()
        homeViewModel.childAgeRanges.observe(viewLifecycleOwner) { ageRangesList ->
            levels = ageRangesList
            getData()
        }
        super.onResume()
    }


    private fun checkIfUserLogin() {
        if (homeViewModel.isUserLoggedIn()) {
            getProfileData()
        }
    }

    private fun getProfileData() {
        homeViewModel.getCurrentUser()?.let {
            val firstName = it.fullName.split(" ").firstOrNull() ?: ""
            val greeting = "Hi, $firstName"
            binding.tvGreetingUser.text = greeting
            typeAsuh = it.uri
            if (it.uri != "Tidak Diketahui" && it.uri != null) {
                checkTesPolaAsuh = true
            } else {
                checkTesPolaAsuh = false
            }
        }
    }

    private fun navigateToDetailCourse(courseId: Int?) {
        DetailCourseActivity.startActivity(requireContext(), courseId)
    }

    private fun setClickListener() {

        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.isRefreshing = false
        }
        binding.icProfile.setOnClickListener {
            if (homeViewModel.isUserLoggedIn()) {
                navigateToProfile()
            } else {
                navigateToLogin()
            }
        }

        binding.tvSeeAllCourse.setOnClickListener {
            navigateToAllPremiumCourse()
        }
        binding.btnStartTest.setOnClickListener {
            navigateToTestPolaAsuh()
        }
    }

    private fun navigateToLogin() {
        startActivity(Intent(requireContext(), LoginActivity::class.java))
    }

    private fun navigateToTestPolaAsuh() {

        if (homeViewModel.isUserLoggedIn()) {
            val intent = Intent(requireContext(), SplashTesPolaAsuhActivity::class.java)
            startActivity(intent)
        } else {
            FancyToast.makeText(
                requireContext(),
                "Silahkan Login Terlebih Dahulu",
                FancyToast.LENGTH_SHORT,
                FancyToast.ERROR,
                false
            ).show()
            navigateToLogin()
        }

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
            dialog.dismiss()
        }
    }

    private fun showDialogTest() {
        val binding: DialogNonTestpolaasuhBinding =
            DialogNonTestpolaasuhBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(requireContext(), 0).create()

        dialog.apply {
            setView(binding.root)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }.show()

        binding.clSignUp.setOnClickListener {
            val intent = Intent(requireContext(), SplashTesPolaAsuhActivity::class.java)
            startActivity(intent)
            dialog.dismiss()
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

                    it.payload?.let { data -> popularCourseCategoryAdapter.submitData(data) }
                },
                doOnLoading = {
                    binding.layoutStatePopularCategories.root.isVisible = false
                    binding.layoutStatePopularCategories.loadingAnimation.isVisible = false
                    binding.layoutStatePopularCategories.tvError.isVisible = false

                },
                doOnError = {
                    binding.layoutStatePopularCategories.root.isVisible = true
                    binding.layoutStatePopularCategories.loadingAnimation.isVisible = false
                    binding.layoutStatePopularCategories.tvError.isVisible = true
                    binding.layoutStatePopularCategories.tvError.text =
                        getString(R.string.exception_notif)

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
        var typeasuhnumber: Int? = null;
        var typeCourse: String? = null;
        if (typeAsuh == "Otoriter") {
            typeasuhnumber = 2;
        } else if (typeAsuh == "Otoritatif") {
            typeasuhnumber = 1;
        } else if (typeAsuh == "Permisif") {
            typeasuhnumber = 3;
        } else {
            typeCourse = "umum"
        }
        homeViewModel.getCategories()
        homeViewModel.getPopularCourseCategories()
        homeViewModel.getCourses(typeCourse, typeasuhnumber, null, levels, typeCourse)
        homeViewModel.courses.observe(viewLifecycleOwner) { resultWrapper ->
            resultWrapper.proceedWhen(
                doOnSuccess = {
                    binding.emptyData.root.visibility = View.GONE
                }, doOnEmpty = {
                    binding.emptyData.root.visibility = View.VISIBLE
                    if (typeasuhnumber == null){
                        binding.emptyData.tvEmptyTeks.text = "Anda belum melakukan tes pola asuh"
                    }else{
                        binding.emptyData.tvEmptyTeks.text = "Maaf tidak ada kursus yang tersedia berdasarkan usia anak Anda"
                    }
                }
            )
        }
    }


}