package com.thesis.tuladhaapp.ui.splashScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thesis.tuladhaapp.databinding.ActivitySplashScreenSlideTwooBinding
import com.thesis.tuladhaapp.ui.splashScreen.SplashScreenSlideThreeActivity

class SplashScreenSlideTwooActivity : AppCompatActivity() {

    private val binding: ActivitySplashScreenSlideTwooBinding by lazy {
        ActivitySplashScreenSlideTwooBinding.inflate(layoutInflater)
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
            navigateToSplashScreenThree()
        }
    }

    private fun navigateToSplashScreenThree() {
        val intent = Intent(this, SplashScreenSlideThreeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

    }

    private fun navigateToMain() {
        val intent = Intent(this, SplashScreenSlideThreeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

    }
}
