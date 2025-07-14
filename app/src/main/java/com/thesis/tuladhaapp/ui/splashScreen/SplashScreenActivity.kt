package com.thesis.tuladhaapp.ui.splashScreen

import android.content.Context // Import Context untuk SharedPreferences
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.thesis.tuladhaapp.databinding.ActivitySplashScreenBinding
import com.thesis.tuladhaapp.ui.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    // SharedPreferences Constants
    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_FIRST_LAUNCH = "first_launch"
    private val SPLASH_DELAY_MS = 1500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Dapatkan SharedPreferences
        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val isFirstLaunch = prefs.getBoolean(KEY_FIRST_LAUNCH, true) // Default true (peluncuran pertama)

        lifecycleScope.launch {
            delay(SPLASH_DELAY_MS)

            if (isFirstLaunch) {
                prefs.edit().putBoolean(KEY_FIRST_LAUNCH, false).apply()
                navigateToSplashScreen1()
            } else {
                navigateToMain()
            }
        }
    }

    private fun navigateToSplashScreen1() {
        val intent = Intent(this, SplashScreenSlideOneActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}