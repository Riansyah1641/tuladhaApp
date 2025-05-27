package com.thesis.tuladhaapp.ui.kuisCourse

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityQuizResultBinding
import com.thesis.tuladhaapp.ui.assesmentCourse.AssesmentCourseActivity
import com.thesis.tuladhaapp.ui.detailCourse.DetailCourseActivity
import com.thesis.tuladhaapp.ui.testPolaAsuh.ResultTestActivity
import com.thesis.tuladhaapp.utils.Utils

class QuizResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuizResultBinding

    private var correctAnswers = 0
    private var incorrectAnswers = 0
    private var totalQuestions = 0
    private var idCourse = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityQuizResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        correctAnswers = intent.getIntExtra("correctAnswers", 0)
        incorrectAnswers = intent.getIntExtra("incorrectAnswers", 0)
        idCourse = intent.getIntExtra("ID_COURSE", 0)
        totalQuestions = correctAnswers + incorrectAnswers

        binding.correctAnswers.text = "Correct Answers: $correctAnswers"
        binding.incorrectAnswers.text = "Incorrect Answers: $incorrectAnswers"

        val percentage = (correctAnswers.toFloat() / totalQuestions) * 100

        if (percentage > Utils.getHighScore(this@QuizResultActivity)) {
            Utils.saveHighScore(this@QuizResultActivity, percentage)
        }

        when {
            percentage > 80 -> {
                binding.encouragingWords.text = getString(R.string.great_result_quiz)
                binding.emojiImage.setImageResource(R.drawable.happy)
                binding.correctAnswers.setTextColor(Color.parseColor("#4CAF50"))
                binding.incorrectAnswers.setTextColor(Color.parseColor("#F44336"))
                binding.closeButton.setOnClickListener {
                    nextQuestion()
                }
                binding.courseButton.isVisible = false
            }

            percentage in 70.0..80.0 -> {
                binding.encouragingWords.text = getString(R.string.good_result_quiz)
                binding.emojiImage.setImageResource(R.drawable.neutral)
                binding.correctAnswers.setTextColor(Color.parseColor("#FFC107"))
                binding.incorrectAnswers.setTextColor(Color.parseColor("#F44336"))
                binding.courseButton.isVisible = true
                binding.tvDeskNextSection.isVisible = true
                binding.courseButton.setOnClickListener {
                    backToCourse()
                }
                binding.closeButton.setOnClickListener {
                    nextQuestion()
                }
            }

            else -> {
                binding.encouragingWords.text = getString(R.string.repeat_quiz)
                binding.tvDeskNextSection.isVisible = false
                binding.emojiImage.setImageResource(R.drawable.sad)
                binding.courseButton.isVisible = false
                binding.correctAnswers.setTextColor(Color.parseColor("#F44336"))
                binding.incorrectAnswers.setTextColor(Color.parseColor("#4CAF50"))
                binding.closeButton.text = getString(R.string.back_to_course)
                binding.closeButton.setOnClickListener {
                    backToCourse()
                }
            }
        }
    }

    private fun backToCourse(){
        val intent = Intent(this, DetailCourseActivity::class.java)
        intent.putExtra("EXTRA_COURSE", idCourse)
        startActivity(intent)
        finish()
    }

    private fun nextQuestion() {
        val intent = Intent(this, AssesmentCourseActivity::class.java).apply {
            putExtra("ID_COURSE", idCourse)
        }
        startActivity(intent)
        finish()
    }
}