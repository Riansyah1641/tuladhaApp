package com.thesis.tuladhaapp.ui.assesmentCourse

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityFeedbackCourseBinding
import com.thesis.tuladhaapp.ui.main.MainActivity

class FeedbackCourseActivity : AppCompatActivity() {

    private var idSeekBar = 0

    private val binding: ActivityFeedbackCourseBinding by lazy {
        ActivityFeedbackCourseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        getData()
        setOnClickListener()
    }

    @SuppressLint("StringFormatMatches")
    private fun getData() {
        idSeekBar = intent.getIntExtra("SEEKBAR", 0)
        binding.tvFeedbackPrompt.text = getString(R.string.text_feedback_answer, idSeekBar)
    }

    private fun setOnClickListener() {
        binding.btnSubmit.setOnClickListener {
            checkDoneFeedback()
        }
        binding.toolbar.setOnClickListener {
            finish()
        }
    }


    private fun checkDoneFeedback() {
        val feedbackText = binding.etFeedback.text.toString().trim()

        if (feedbackText.isNotEmpty()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // Buat toast dengan warna khusus (color_warning)
            val toast = Toast.makeText(
                this,
                getString(R.string.feedback_not_emptyy), Toast.LENGTH_SHORT
            )

            val view = toast.view
            view?.let {
                // Ganti background toast dengan warna custom
                it.setBackgroundColor(ContextCompat.getColor(this, R.color.color_warning))

                // Ganti warna teks jika perlu
                val text = binding.etFeedback
                text?.setTextColor(Color.WHITE)
            }

            toast.show()
        }
    }

}