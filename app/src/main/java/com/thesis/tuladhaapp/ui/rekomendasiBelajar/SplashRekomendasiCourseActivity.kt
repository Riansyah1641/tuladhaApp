package com.thesis.tuladhaapp.ui.rekomendasiBelajar

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivitySplashRekomendasiCourseBinding
import com.thesis.tuladhaapp.databinding.ActivitySplashTesPolaAsuhBinding
import com.thesis.tuladhaapp.ui.main.MainActivity
import com.thesis.tuladhaapp.ui.testPolaAsuh.QuickStartActivity

class SplashRekomendasiCourseActivity : AppCompatActivity() {

    private val binding: ActivitySplashRekomendasiCourseBinding by lazy {
        ActivitySplashRekomendasiCourseBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setOnClickListener()
    }

    private fun setOnClickListener(){
        binding.btnStart.setOnClickListener {
            val intent = Intent(this, RekomendasiBelajarActivity::class.java)
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener {
            navigateToMain()
        }
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