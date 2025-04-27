package com.thesis.tuladhaapp.ui.splashScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thesis.tuladhaapp.databinding.ActivitySplashScreenSlideOneBinding

class SplashScreenSlideOneActivity : AppCompatActivity() {

    private val binding: ActivitySplashScreenSlideOneBinding by lazy {
        ActivitySplashScreenSlideOneBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.tvSkip.setOnClickListener {
            navigateToMain()
        }

        binding.clButtonNext.setOnClickListener {
            navigateToSplashScreenTwo()
        }
    }

    private fun navigateToSplashScreenTwo() {
        val intent = Intent(this, SplashScreenSlideTwoActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
    }

    private fun navigateToMain() {
        val intent = Intent(this, SplashScreenSlideThreeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
    }
}
