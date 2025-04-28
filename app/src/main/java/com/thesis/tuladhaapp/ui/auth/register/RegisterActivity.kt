package com.thesis.tuladhaapp.ui.auth.register

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityRegisterBinding
import com.thesis.tuladhaapp.ui.auth.login.LoginActivity
import com.thesis.tuladhaapp.ui.main.MainActivity
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {
    private val binding: ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }
    private val registerViewModel: RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.btnRegister.setOnClickListener {
            doRegister()
        }
        binding.tvNavigateToLogin.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun doRegister() {
        if (isFormValid()) {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val fullName = binding.etName.text.toString().trim()
            proceedRegister(email, password, fullName)
        }
    }

    private fun proceedRegister(
        email: String,
        password: String,
        fullName: String,
    ) {
        registerViewModel.doRegister(email, fullName, password).observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.pbLoading.isVisible = false
                    binding.btnRegister.isVisible = true
                   navigateToMain()
                },
                doOnError = {
                    binding.pbLoading.isVisible = false
                    binding.btnRegister.isVisible = true
                    Toast.makeText(
                        this,
                        "Login Failed : ${it.exception?.message.orEmpty()}",
                        Toast.LENGTH_SHORT,
                    ).show()
                },
                doOnLoading = {
                    binding.pbLoading.isVisible = true
                    binding.btnRegister.isVisible = false
                },
            )
        }
    }

    private fun navigateToMain() {
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            },
        )
    }

    private fun navigateToLogin() {
        startActivity(
            Intent(this, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            },
        )
    }

    private fun isFormValid(): Boolean {
        val fullName = binding.etName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val confirmPassword = binding.etPasswordRepeat.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        return checkNameValidation(fullName) && checkEmailValidation(email) && checkPwdAndConfirmPwd(
            password,
            confirmPassword
        ) && checkPasswordValidation(password)
    }


    private fun checkNameValidation(fullName: String): Boolean {
        return if (fullName.isEmpty()) {
            binding.etlName.isErrorEnabled = true
            binding.etlName.error = getString(R.string.text_hint_name_empty)
            false
        } else {
            binding.etlName.isErrorEnabled = false
            true
        }
    }

    private fun checkEmailValidation(email: String): Boolean {
        return if (email.isEmpty()) {
            binding.etlEmail.isErrorEnabled = true
            binding.etlEmail.error = getString(R.string.text_error_email_empty)
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etlEmail.isErrorEnabled = true
            binding.etlEmail.error = getString(R.string.text_error_email_invalid)
            false
        } else {
            binding.etlEmail.isErrorEnabled = false
            true
        }
    }


    private fun checkPasswordValidation(password: String): Boolean {
        return if (password.isEmpty()) {
            binding.etlPassword.isErrorEnabled = true
            binding.etlPassword.error = getString(R.string.text_hint_password_empty)
            false
        } else if (password.length < 8) {
            binding.etlPassword.isErrorEnabled = true
            binding.etlPassword.error = getString(R.string.text_hint_password_length)
            false
        } else {
            binding.etlPassword.isErrorEnabled = false
            true
        }
    }

    private fun checkPwdAndConfirmPwd(
        password: String,
        confirmPassword: String,
    ): Boolean {
        return if (password != confirmPassword) {
            binding.etlPassword.isErrorEnabled = true
            binding.etlPassword.error =
                getString(R.string.text_pw_nomatch)
            binding.etlPasswordRepeat.isErrorEnabled = true
            binding.etlPasswordRepeat.error =
                getString(R.string.text_pw_nomatch)
            false
        } else {
            binding.etlPassword.isErrorEnabled = false
            binding.etlPasswordRepeat.isErrorEnabled = false
            true
        }
    }

}