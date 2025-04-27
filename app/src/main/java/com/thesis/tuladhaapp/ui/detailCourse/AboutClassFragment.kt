package com.thesis.tuladhaapp.ui.detailCourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.thesis.tuladhaapp.databinding.FragmentAboutClassBinding
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.ui.detailCourse.adapter.BenefitListAdapter
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class AboutClassFragment : Fragment() {

    private lateinit var binding: FragmentAboutClassBinding
    private val sharedViewModel: DetailCourseViewModel by activityViewModel()
    private val benefitAdapter: BenefitListAdapter by lazy {
        BenefitListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutClassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        setUpRv()
    }

    private fun setUpRv() {
        binding.rvBenefitList.apply {
            adapter = benefitAdapter
        }
    }

    private fun bindData(courseData: CourseData?) {
        courseData.let { item ->
            binding.tvContentAboutClass.text = item?.course?.description
            binding.rvBenefitList.apply {
                adapter = benefitAdapter
            }
            item?.course?.benefits?.let {
                benefitAdapter.submitData(it)
            }
        }
    }

    private fun observeData() {
        sharedViewModel.detailCourseData.observe(requireActivity()) { result ->
            result.proceedWhen(
                doOnSuccess = { resultWrapper ->
                    bindData(resultWrapper.payload)
                },
                doOnError = {
                        Toast.makeText(
                            requireContext(),
                           "maaf terdapat error, harap coba lagi",
                            Toast.LENGTH_SHORT
                        ).show()
                }
            )
        }
    }
}