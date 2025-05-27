package com.thesis.tuladhaapp.ui.assesmentCourse

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.thesis.tuladhaapp.databinding.ActivityAssesCourseBinding

class AssesCourseActivity : AppCompatActivity() {
    private var idCourse = 0

    private val binding: ActivityAssesCourseBinding by lazy {
        ActivityAssesCourseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        getData()

        binding.nextButton.setOnClickListener {
            navigateToEvaluation()
        }
    }

    private fun getData() {
        idCourse = intent.getIntExtra("ID_COURSE", 0)
    }

    private fun navigateToEvaluation() {
        val progress = binding.likertSeekBar.progress
        val intent = Intent(this, FeedbackCourseActivity::class.java).apply {
            putExtra("SEEKBAR", progress+1)
        }
        startActivity(intent)
    }
}