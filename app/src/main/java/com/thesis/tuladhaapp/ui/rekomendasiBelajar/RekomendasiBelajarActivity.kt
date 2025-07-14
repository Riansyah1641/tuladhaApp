package com.thesis.tuladhaapp.ui.rekomendasiBelajar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityQuickStartBinding
import com.thesis.tuladhaapp.databinding.ActivityRekomendasiStartBinding
import com.thesis.tuladhaapp.ui.auth.login.LoginActivity
import com.thesis.tuladhaapp.ui.testPolaAsuh.QuickStartViewModel
import com.thesis.tuladhaapp.ui.testPolaAsuh.ResultTestActivity
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class RekomendasiBelajarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRekomendasiStartBinding
    private val viewModel: RekomendasiBelajarViewModel by viewModel()
    private var hasNavigatedToResult = false
    private var fullname: String = ""
    private var uri: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRekomendasiStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkIfUserLogin()
        getProfileData()

        binding.rekomendasiBelajarViewModel = viewModel
        binding.lifecycleOwner = this

        setupObservers()
        setOnClickListener()
    }

    private fun checkIfUserLogin() {
        if (viewModel.isUserLoggedIn()) {
        } else {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun setOnClickListener() {
        binding.nextQuickQuestions.setOnClickListener {
            if (binding.nextQuickQuestions.text == "Selesai") {
                viewModel.ResultUserCalculate()
            }
        }
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.backQuickQuestion.setOnClickListener {
            viewModel.backQuestion()
        }
    }

    private fun getProfileData() {
        viewModel.getCurrentUser()?.let {
            fullname = it.fullName
            uri = it.uri
        }
    }

    private fun setupObservers() {
        viewModel.clearSelection.observe(this) { shouldClear ->
            if (shouldClear) {
                binding.radioGroupLikert.clearCheck()
                viewModel.clearSelectionHandled()
            }
        }



        viewModel.resultTypeParenting.observe(this) { typeParenting ->
            if (!hasNavigatedToResult && typeParenting != null) {
                hasNavigatedToResult = true // supaya tidak double intent
                val intent = Intent(this, RekomendasiResultActivity::class.java).apply {
                    putExtra("TYPE_ID", typeParenting.id)
                    putExtra("TYPE_NAME", typeParenting.name)
                    putExtra("TYPE_DESC", typeParenting.deskripsi)
                }
                startActivity(intent)
                finish()
            }
        }
    }
}