package com.thesis.tuladhaapp.ui.splashScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thesis.tuladhaapp.databinding.ActivitySplashScreenSlideThreeBinding
import com.thesis.tuladhaapp.ui.main.MainActivity

class SplashScreenSlideThreeActivity : AppCompatActivity() {

    private val binding: ActivitySplashScreenSlideThreeBinding by lazy {
        ActivitySplashScreenSlideThreeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.clButtonNext.setOnClickListener {
            navigateToMain()
        }
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
    }
}
