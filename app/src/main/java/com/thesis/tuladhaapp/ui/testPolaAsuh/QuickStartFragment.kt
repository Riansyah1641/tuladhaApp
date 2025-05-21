package com.thesis.tuladhaapp.ui.testPolaAsuh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.FrangmentTestpolaasuhBinding

/**
 * A simple [Fragment] subclass.
 * Use the [QuickStartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuickStartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding: FrangmentTestpolaasuhBinding =
            DataBindingUtil.inflate(inflater, R.layout.frangment_testpolaasuh, container, false)
        val viewModel = ViewModelProvider(this)[QuickStartViewModel::class.java]
        binding.quickStartViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }


}