package com.thesis.tuladhaapp.ui.testPolaAsuh

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivitySplashScreenBinding
import com.thesis.tuladhaapp.databinding.ActivitySplashTesPolaAsuhBinding

class SplashTesPolaAsuhActivity : AppCompatActivity() {


    private val binding: ActivitySplashTesPolaAsuhBinding by lazy {
        ActivitySplashTesPolaAsuhBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setOnClickListener()
    }

    private fun setOnClickListener(){
        binding.btnStart.setOnClickListener {
            val intent = Intent(this, QuickStartActivity::class.java)
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }


}