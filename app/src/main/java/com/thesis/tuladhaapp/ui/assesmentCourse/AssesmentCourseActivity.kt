package com.thesis.tuladhaapp.ui.assesmentCourse

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.thesis.tuladhaapp.databinding.ActivityAssesmentCourseBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AssesmentCourseActivity : AppCompatActivity() {
    private val binding: ActivityAssesmentCourseBinding by lazy {
        ActivityAssesmentCourseBinding.inflate(layoutInflater)
    }
    private val viewModel: AssesmentCourseViewModel by viewModel()
    private var idCourse = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        getData()
        putData()
        setOnClickListener()
    }

    private fun getData() {
        idCourse = intent.getIntExtra("ID_COURSE", 0)
        viewModel.GetAssesmentById(idCourse)
    }

    private fun putData() {
        viewModel.assesment.observe(this) { assesment ->
            if (assesment != null) {
                // Update UI
                binding.tvJudul.text = assesment.title
                binding.tvDeskripsi.text = assesment.deskripsi
            } else {
                Toast.makeText(
                    this,
                    "Maaf terjadi kesalahan, dalam memuat data",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }

    private fun setOnClickListener() {
        binding.toolbar.setOnClickListener {
            onBackPressed()
        }
        binding.btnNext.setOnClickListener {
            navigateToEvaluation()
        }

    }

    private fun navigateToEvaluation() {
        val intent = Intent(this, AssesCourseActivity::class.java).apply {
            putExtra("ID_COURSE", idCourse)
        }
        startActivity(intent)
        finish()
    }
}