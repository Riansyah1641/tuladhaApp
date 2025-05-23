package com.thesis.tuladhaapp.ui.testPolaAsuh

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityQuickStartBinding
import com.thesis.tuladhaapp.ui.auth.login.LoginActivity
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuickStartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuickStartBinding
    private val viewModel: QuickStartViewModel by viewModel()
    private var hasNavigatedToResult = false
    private var fullname: String = ""
    private var uri: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuickStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkIfUserLogin()
        getProfileData()

        binding.quickStartViewModel = viewModel
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
        binding.nextQuickQuestion.setOnClickListener {
            if (binding.nextQuickQuestion.text == "Selesai") {
                viewModel.ResultUserCalculate()
            }
        }
        binding.ivBack.setOnClickListener {
            onBackPressed()
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
                typeParenting.name?.let { changeProfileName(fullname, it) }
                val intent = Intent(this, ResultTestActivity::class.java).apply {
                    putExtra("TYPE_ID", typeParenting.id)
                    putExtra("TYPE_NAME", typeParenting.name)
                    putExtra("TYPE_DESC", typeParenting.deskripsi)
                }
                startActivity(intent)
                finish()
            }
        }
    }

    private fun changeProfileName(fullName: String, uri: String) {
        viewModel.changeProfile(fullName, uri).observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    Toast.makeText(
                        this,
                        getString(R.string.text_link_edit_profile_success),
                        Toast.LENGTH_SHORT
                    ).show()
                },
                doOnError = {
                    Toast.makeText(
                        this,
                        getString(R.string.text_link_edit_profile_failed),
                        Toast.LENGTH_SHORT
                    ).show()
                },
            )
        }
    }
}
