package com.thesis.tuladhaapp.ui.userClass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.thesis.tuladhaapp.databinding.FragmentClassBinding
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.ui.detailCourse.DetailCourseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClassFragment : Fragment() {
    private lateinit var binding: FragmentClassBinding
    private val viewModel: ClassFragmentViewModel by viewModel()
    private var searchQuery: String? = null

    private var selectedType: String? = null
    private var selectedCategories: List<Category>? = null
    private var selectedLevel: List<String>? = null
    private var selectedSortBy: String? = null
    private var databaseRef: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("user_courses")


    private var selectedProgress: String? = null

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
        fetchCoursesData()
        observeSelectedProgress()
        observeAllUserCoursesList(progressStatus = viewModel.selectedProgress.value)
        refreshData()
    }


    private fun fetchData() {

    }

    private fun refreshData() {
        binding.swipeRefresh.setOnRefreshListener {
            fetchData()
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun fetchCoursesData() {
        val userId = viewModel.getCurrentUser()?.id
        if (userId != null) {
            viewModel.fetchUserCourses(userId)
        }
    }


    private fun observeSelectedProgress() {
        viewModel.selectedProgress.observe(viewLifecycleOwner) { selectedProgress ->
            observeAllUserCoursesList(progressStatus = selectedProgress)
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
                // Lakukan sesuatu jika daftar kursus tidak kosong
            } else {
                // Lakukan sesuatu jika daftar kursus kosong setelah filter
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

