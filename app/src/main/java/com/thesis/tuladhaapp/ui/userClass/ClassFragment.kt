package com.thesis.tuladhaapp.ui.userClass

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.DialogNonLoginBinding
import com.thesis.tuladhaapp.databinding.FragmentClassBinding
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.ui.auth.login.LoginActivity
import com.thesis.tuladhaapp.ui.detailCourse.DetailCourseActivity
import com.thesis.tuladhaapp.ui.main.MainActivity
import com.thesis.tuladhaapp.ui.profile.ProfileActivity
import com.thesis.tuladhaapp.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClassFragment : Fragment() {
    private lateinit var binding: FragmentClassBinding
    private val viewModel: ClassFragmentViewModel by viewModel()
    private val profileViewModel: ProfileViewModel by viewModel()


    private val userClassAdapter: UserClassAdapter by lazy {
        UserClassAdapter {
            itemCourseListener(it.courseId)
        }
    }

    private fun itemCourseListener(courseId: Int?) {
        DetailCourseActivity.startActivity(requireContext(), courseId)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClassBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.rvListUserCourse.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userClassAdapter // Set adapter ke RecyclerView
        }
        setProgress()
        getProfileData()
        setClickListener()
        fetchCoursesData()
        observeSelectedProgress()
        observeAllUserCoursesList(progressStatus = viewModel.selectedProgress.value)
    }

    private fun setClickListener() {
        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.isRefreshing = false
        }
        binding.icProfile.setOnClickListener {
            if (profileViewModel.isUserLoggedIn()) {
                navigateToProfile()
            } else {
                showDialog()
            }
        }
        binding.ivLogo.setOnClickListener {
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
    }

    private fun getProfileData() {
        profileViewModel.getCurrentUser()?.let {
            val firstName = it.fullName.split(" ").firstOrNull() ?: ""
            val greeting = "Hi, $firstName"
            binding.tvGreetingUser.text = greeting
        }
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

    private fun fetchCoursesData() {
        val userId = viewModel.getCurrentUser()?.id
        if (userId != null) {
            viewModel.fetchUserCourses(userId)
        }
    }

    private fun observeSelectedProgress() {
        if (profileViewModel.isUserLoggedIn()) {
            viewModel.selectedProgress.observe(viewLifecycleOwner) { selectedProgress ->

                if (viewModel.userCourses.value.isNullOrEmpty()) {
                    binding.emptyData.root.visibility = View.VISIBLE

                } else {
                    observeAllUserCoursesList(progressStatus = selectedProgress)
                }
            }
        } else {
            binding.emptyData.root.visibility = View.VISIBLE
            binding.emptyData.tvEmptyTeks.text = getString(R.string.login_first)
        }

    }

    private fun observeAllUserCoursesList(
        search: String? = null,
        type: String? = null,
        category: List<Category>? = null,
        level: List<String>? = null,
        sortBy: String? = null,
        progressStatus: String? = null // Tambahkan parameter progressStatus
    ) {
        viewModel.userCourses.observe(viewLifecycleOwner) { courses ->
            val filteredCourses = courses.filter { course ->
                val searchTextMatch = search.isNullOrBlank() ||
                        course.course?.name?.contains(search, ignoreCase = true) == true ||
                        course.course?.description?.contains(search, ignoreCase = true) == true ||
                        course.course?.courseBy?.contains(search, ignoreCase = true) == true

                val typeMatch = type.isNullOrBlank() || course.course?.type?.equals(
                    type,
                    ignoreCase = true
                ) == true

                val categoryMatch =
                    category.isNullOrEmpty() || course.course?.category?.let { cat ->
                        category.any { it.id == cat.id }
                    } == true

                val levelMatch = level.isNullOrEmpty() || course.course?.level?.let { lvl ->
                    level.any { it.equals(lvl, ignoreCase = true) }
                } == true

                val progressMatch =
                    progressStatus == "all" || progressStatus.isNullOrBlank() || course.progress?.equals(
                        progressStatus,
                        ignoreCase = true
                    ) == true

                searchTextMatch && typeMatch && categoryMatch && levelMatch && progressMatch
            }
            userClassAdapter.submitList(filteredCourses)

            if (filteredCourses.isNotEmpty()) {
                binding.emptyData.root.visibility = View.GONE
            } else {
                binding.emptyData.root.visibility = View.VISIBLE
            }
        }
    }


    private fun setProgress() {
        binding.btnAll.setOnClickListener {
            viewModel.setSelectedProgress(PROGRESS_ALL)
        }

        binding.btnInProgress.setOnClickListener {
            viewModel.setSelectedProgress(ON_PROGRESS)
        }

        binding.btnFinish.setOnClickListener {
            viewModel.setSelectedProgress(PROGRESS_FINISH)
        }
    }


    companion object {
        const val PROGRESS_ALL = "all"
        const val ON_PROGRESS = "On progress"
        const val PROGRESS_FINISH = "Selesai"
    }

}

