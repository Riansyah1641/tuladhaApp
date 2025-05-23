package com.thesis.tuladhaapp.ui.kuisCourse

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.card.MaterialCardView
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityQuizBinding
import com.thesis.tuladhaapp.model.kuis.Quiz
import com.thesis.tuladhaapp.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var quizList: List<Quiz>
    private var index = 0
    private val quizViewModel: QuizViewModel by viewModel()
    private var correctAnswers = 0
    private var incorrectAnswers = 0
    private var isAnswerSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val idCourse = intent.getIntExtra("ID_COURSE", 1)

        quizViewModel.getQuizById(idCourse).observe(this) {
            quizList = it
            setQuizData(index)
            binding.circularProgressBar.progressMax = quizList.size.toFloat()
        }


        binding.exitButton.setOnClickListener {
            finish()
        }

        binding.option1Card.setOnClickListener { handleAnswerSelection(binding.option1Card, 0) }
        binding.option2Card.setOnClickListener { handleAnswerSelection(binding.option2Card, 1) }
        binding.option3Card.setOnClickListener { handleAnswerSelection(binding.option3Card, 2) }
        binding.option4Card.setOnClickListener { handleAnswerSelection(binding.option4Card, 3) }

        binding.nextButton.setOnClickListener {
            if (isAnswerSelected) {
                if ((index + 1) < quizList.size) {
                    index++
                    setQuizData(index)
                    isAnswerSelected = false
                } else {
                    val intent = Intent(this@QuizActivity, QuizResultActivity::class.java)
                    intent.putExtra("correctAnswers", correctAnswers)
                    intent.putExtra("incorrectAnswers", incorrectAnswers)
                    startActivity(intent)
                    finish()
                }
            }
        }

    }

    private fun setQuizData(index: Int) {
        if (index < quizList.size) {
            binding.questionText.text = quizList[index].question
            binding.option1.text = quizList[index].option1
            binding.option2.text = quizList[index].option2
            binding.option3.text = quizList[index].option3
            binding.option4.text = quizList[index].option4

            binding.quiestionIndex.text = "${index + 1}/${quizList.size}"
            binding.circularProgressBar.progress = (index+1).toFloat()


            resetAnswerOptions()
        }
    }

    private fun handleAnswerSelection(selectedOption: MaterialCardView, selectedIndex: Int) {
        if (isAnswerSelected) return

        val correctAnswer = quizList[index].answer
        val selectedAnswer = when (selectedIndex) {
            0 -> quizList[index].option1
            1 -> quizList[index].option2
            2 -> quizList[index].option3
            3 -> quizList[index].option4
            else -> ""
        }

        if (selectedAnswer == correctAnswer) {
            selectedOption.setCardBackgroundColor(Color.parseColor("#C7FDC9"))
            selectedOption.strokeColor = Color.parseColor("#4CAF50")
            correctAnswers++
        } else {
            selectedOption.setCardBackgroundColor(Color.parseColor("#FAB9B4"))
            selectedOption.strokeColor = Color.parseColor("#F44336")
            incorrectAnswers++
        }

        highlightCorrectAnswer(correctAnswer)

        binding.option1Card.isClickable = false
        binding.option2Card.isClickable = false
        binding.option3Card.isClickable = false
        binding.option4Card.isClickable = false

        isAnswerSelected = true
    }

    private fun highlightCorrectAnswer(correctAnswer: String) {
        val correctCard: MaterialCardView? = when (correctAnswer) {
            quizList[index].option1 -> binding.option1Card
            quizList[index].option2 -> binding.option2Card
            quizList[index].option3 -> binding.option3Card
            quizList[index].option4 -> binding.option4Card
            else -> null
        }

        correctCard?.setCardBackgroundColor(Color.parseColor("#C7FDC9"))
        correctCard?.strokeColor = Color.parseColor("#4CAF50")
    }

    private fun resetAnswerOptions() {
        binding.option1Card.setCardBackgroundColor(Color.TRANSPARENT)
        binding.option2Card.setCardBackgroundColor(Color.TRANSPARENT)
        binding.option3Card.setCardBackgroundColor(Color.TRANSPARENT)
        binding.option4Card.setCardBackgroundColor(Color.TRANSPARENT)

        binding.option1Card.strokeColor = Color.parseColor("#FFFFFF")
        binding.option2Card.strokeColor = Color.parseColor("#FFFFFF")
        binding.option3Card.strokeColor = Color.parseColor("#FFFFFF")
        binding.option4Card.strokeColor = Color.parseColor("#FFFFFF")

        binding.option1Card.isClickable = true
        binding.option2Card.isClickable = true
        binding.option3Card.isClickable = true
        binding.option4Card.isClickable = true
    }
}