package com.thesis.tuladhaapp.ui.profile

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityMainBinding
import com.thesis.tuladhaapp.databinding.ActivityProfileBinding
import com.thesis.tuladhaapp.ui.auth.login.LoginActivity
import com.thesis.tuladhaapp.ui.main.MainActivity
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileActivity : AppCompatActivity() {
    private val binding: ActivityProfileBinding by lazy {
        ActivityProfileBinding.inflate(layoutInflater)
    }
    private val profileViewModel: ProfileViewModel by viewModel()
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        checkIfUserLogin()
        setClickListener()
        getProfileData()
        changeEditMode()
    }
    private fun getProfileData() {
        profileViewModel.getCurrentUser()?.let {
            binding.etNameTextProfile.setText(it.fullName)
            binding.etEmailTextProfile.setText(it.email)
            binding.etNomorTextProfile.setText(it.uri)
        }
    }
 
    private fun checkIfUserLogin() {
        if (profileViewModel.isUserLoggedIn()) {
        } else {
            navigateToLogin()
        }
    }


    private fun setClickListener() {
        binding.btnEditProfile.setOnClickListener {
            if (profileViewModel.isUserLoggedIn()) {
                count += 1
                profileViewModel.changeEditMode()
                if (count % 2 == 0) {
                    val name = binding.etNameTextProfile.text.toString().trim()
                    val uri = binding.etNomorTextProfile.text.toString().trim()
                    binding.btnEditProfile.setText(getString(R.string.text_edit_profile))
                    changeProfileName(name, uri)
                } else {
                    binding.btnEditProfile.setText(getString(R.string.text_save))
                }
            } else {
                navigateToLogin()
            }
        }

        binding.logoutProfile.setOnClickListener {
            if (profileViewModel.isUserLoggedIn()) {
                logoutUser()
            } else {
                navigateToLogin()
            }
        }
        binding.toolbar.setOnClickListener {
            finish()
        }

        binding.btnChangePw.setOnClickListener {
            if (profileViewModel.isUserLoggedIn()) {
                changePasswordUser()
            } else {
                navigateToLogin()
            }
        }
    }

    private fun changeEditMode() {
        profileViewModel.isEditMode.observe(this) {
            binding.etNameTextProfile.isEnabled = it
        }
    }

    private fun changePasswordUser() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.layout_dialog_change_password)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        profileViewModel.changePassword()
        val backBtn: Button = dialog.findViewById(R.id.btn_back)
        backBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun changeProfileName(fullName: String, uri: String) {
        profileViewModel.changeProfile(fullName, uri).observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    Toast.makeText(this, getString(R.string.text_link_edit_profile_success), Toast.LENGTH_SHORT).show()
                    profileViewModel.changeEditMode()
                },
                doOnError = {
                    Toast.makeText(this, getString(R.string.text_link_edit_profile_failed), Toast.LENGTH_SHORT).show()
                },
            )
        }
    }

    private fun logoutUser() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.layout_dialog_logout)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnCancel = dialog.findViewById<Button>(R.id.btn_cancel_dialog)
        val btnLogout = dialog.findViewById<Button>(R.id.btn_logout_dialog)
        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        btnLogout.setOnClickListener {
            dialog.dismiss()
            profileViewModel.doLogout()
            navigateToHome()
        }
        dialog.show()
    }

    private fun navigateToLogin() {
        startActivity(Intent(this   , LoginActivity::class.java))
        finish()
    }

    private fun navigateToHome() {
        startActivity(Intent(this   , MainActivity::class.java))
        finish()
    }


}