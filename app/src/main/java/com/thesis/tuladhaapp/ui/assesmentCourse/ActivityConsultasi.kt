package com.thesis.tuladhaapp.ui.assesmentCourse

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityAssesCourseBinding
import com.thesis.tuladhaapp.databinding.ActivityConsultasiBinding

class ActivityConsultasi : AppCompatActivity() {
    private val binding: ActivityConsultasiBinding by lazy {
        ActivityConsultasiBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.toolbarConsultation.setOnClickListener {
            finish()
        }
        binding.btnConsultNow.setOnClickListener {
            val phoneNumber =
                "6282144445148"
            val message = "halo kak saya ingin konsultasi dengan tuladha"
            val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=${Uri.encode(message)}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}