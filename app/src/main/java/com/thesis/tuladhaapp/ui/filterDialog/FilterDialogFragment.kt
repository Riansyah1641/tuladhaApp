package com.thesis.tuladhaapp.ui.filterDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andrefrsousa.superbottomsheet.SuperBottomSheetFragment
import com.thesis.tuladhaapp.databinding.FragmentFilterDialogBinding


class FilterDialogFragment : SuperBottomSheetFragment() {

    private lateinit var binding: FragmentFilterDialogBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentFilterDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

}