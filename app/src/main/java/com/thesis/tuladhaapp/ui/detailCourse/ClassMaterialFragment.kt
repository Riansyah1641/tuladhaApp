package com.thesis.tuladhaapp.ui.detailCourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.FragmentClassMaterialBinding
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.ui.detailCourse.viewitems.DataItemVideoChapter
import com.thesis.tuladhaapp.ui.detailCourse.viewitems.HeaderItemVideoChapter
import com.thesis.tuladhaapp.utils.proceedWhen
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class ClassMaterialFragment : Fragment() {
    private lateinit var binding: FragmentClassMaterialBinding
    private val sharedViewModel: DetailCourseViewModel by activityViewModel()

    private val adapter: GroupieAdapter by lazy {
        GroupieAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClassMaterialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {
        sharedViewModel.detailCourseData.observe(viewLifecycleOwner) { result ->
            result.proceedWhen(
                doOnSuccess = {
                    setRv()
                    bindData(it.payload)
                },
                doOnError = { err ->
                    Toast.makeText(
                        requireActivity(),
                        getString(R.string.tv_toast_you_have_to_pay_first),
                        Toast.LENGTH_LONG
                    ).show()
                }
            )
        }
    }

    private fun setRv() {
        binding.rvUserModule.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ClassMaterialFragment.adapter
        }
    }

    private fun bindData(item: CourseData?) {
        item?.let {
            adapter.clear()
            val sections =
                item.course?.chapters?.map {
                    val section = Section()
                    section.setHeader(
                        HeaderItemVideoChapter(it.name, it.totalDuration) { _ ->
                        }
                    )
                    val dataSection =
                        it.userModules?.map { userModuleData ->
                            DataItemVideoChapter(
                                userModuleData.moduleData?.name,
                                userModuleData.status,
                                userModuleData.moduleData?.no
                            ) {

                            }
                        }
                    dataSection?.let { it1 -> section.addAll(it1) }
                    section
                }
            sections?.let { adapter.addAll(it) }
        }
    }


}