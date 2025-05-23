package com.thesis.tuladhaapp.ui.kuisCourse

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityQuizResultBinding
import com.thesis.tuladhaapp.utils.Utils

class QuizResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuizResultBinding

    private var correctAnswers = 0
    private var incorrectAnswers = 0
    private var totalQuestions = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityQuizResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        correctAnswers = intent.getIntExtra("correctAnswers", 0)
        incorrectAnswers = intent.getIntExtra("incorrectAnswers", 0)
        totalQuestions = correctAnswers + incorrectAnswers

        binding.correctAnswers.text = "Correct Answers: $correctAnswers"
        binding.incorrectAnswers.text = "Incorrect Answers: $incorrectAnswers"

        val percentage = (correctAnswers.toFloat() / totalQuestions) * 100

        if (percentage > Utils.getHighScore(this@QuizResultActivity)){
            Utils.saveHighScore(this@QuizResultActivity, percentage)
        }

        when {
            percentage > 80 -> {
                binding.encouragingWords.text = "Great!"
                binding.emojiImage.setImageResource(R.drawable.happy)
                binding.correctAnswers.setTextColor(Color.parseColor("#4CAF50"))
                binding.incorrectAnswers.setTextColor(Color.parseColor("#F44336"))
            }
            percentage in 60.0..80.0 -> {
                binding.encouragingWords.text = "Good Try!"
                binding.emojiImage.setImageResource(R.drawable.neutral)
                binding.correctAnswers.setTextColor(Color.parseColor("#FFC107"))
                binding.incorrectAnswers.setTextColor(Color.parseColor("#F44336"))
            }
            else -> {
                binding.encouragingWords.text = "Try Again"
                binding.emojiImage.setImageResource(R.drawable.sad)
                binding.correctAnswers.setTextColor(Color.parseColor("#F44336"))
                binding.incorrectAnswers.setTextColor(Color.parseColor("#4CAF50"))
            }
        }

        binding.closeButton.setOnClickListener {
            finish()
        }
    }
}