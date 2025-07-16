package com.thesis.tuladhaapp.ui.rekomendasiBelajar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.thesis.tuladhaapp.model.testpolaasuh.TypeParenting
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RekomendasiBelajarViewModel(private val repo: UserRepository) : ViewModel() {

    private lateinit var questions: List<QuestionItem>
    private val _currentQuestion = MutableLiveData<String>()
    val currentQuestion: LiveData<String> get() = _currentQuestion

    private val _liveIndex = MutableLiveData<Int>()
    val liveIndex: LiveData<Int> get() = _liveIndex

    private val _navigateToResult = MutableLiveData<Boolean>()
    val navigateToResult: LiveData<Boolean> get() = _navigateToResult

    private val _clearSelection = MutableLiveData<Boolean>()
    val clearSelection: LiveData<Boolean> get() = _clearSelection

    val _isLastQuestion = MutableLiveData(false)
    val isLastQuestion: LiveData<Boolean> get() = _isLastQuestion

    val _isFirstQuestion = MutableLiveData(false)
    val isFirstQuestion: LiveData<Boolean> get() = _isFirstQuestion

    private val _effort = MutableLiveData<Double>()
    val effort: LiveData<Double> get() = _effort

    private val _insight = MutableLiveData<Double>()
    val insight: LiveData<Double> get() = _insight


    private val _resultTypeParenting = MutableLiveData<TypeParenting>()
    val resultTypeParenting: LiveData<TypeParenting> get() = _resultTypeParenting

    private val answers = mutableListOf<Double>()
    private var currentIndex = 0
    private val _isAnswerSelected = MutableLiveData(false)
    val isAnswerSelected: LiveData<Boolean> get() = _isAnswerSelected

    fun getCurrentUser() = repo.getCurrentUser()
    fun isUserLoggedIn() = repo.isLoggedIn()
    fun changeProfile(fullName: String, uri: String) = repo.updateProfile(fullName, uri).asLiveData(
        Dispatchers.IO
    )

    init {
        setQuestions()
        _liveIndex.value = currentIndex + 1
        _currentQuestion.value = questions[currentIndex].text
    }

    private val typeParenting = listOf(
        TypeParenting(
            1, "Pengembangan Orang Tua dalam pembelajaran singkat",
            "Materi parenting ringkas untuk penerapan cepat. \n\nLangkah menuju belajar:\nPilih tab 'Course' di tengah navigasi bawah, lalu temukan kategori 'Pembelajaran Singkat'."
        ),
        TypeParenting(
            2, "Pengembangan Orang Tua dalam pembelajaran Umum",
            "Pemahaman fundamental parenting dari berbagai aspek. \n\nLangkah menuju belajar:\nPilih tab 'Course' di tengah navigasi bawah, lalu temukan kategori 'Pembelajaran Umum'."
        ),
        TypeParenting(
            3, "Pengembangan Orang Tua dalam pembelajaran Khusus",
            "Studi mendalam topik parenting untuk penanganan kasus spesifik atau kondisi khusus. \n\nLangkah menuju belajar:\nPilih tab 'Course' di tengah navigasi bawah, lalu temukan kategori 'Pembelajaran Khusus'."
        ),
        TypeParenting(
            4, "Pengembangan Si kecil dalam pembelajaran Ringkas",
            "Panduan ringkas mendukung tumbuh kembang anak secara optimal. \n\nLangkah menuju belajar:\nPilih tab 'Course' di tengah navigasi bawah, lalu temukan kategori 'Pembelajaran Ringkas'."
        ),
        TypeParenting(
            5, "Pengembangan Si kecil dalam pembelajaran Umum",
            "Pemahaman komprehensif fase perkembangan anak. \n\nLangkah menuju belajar:\n Pilih tab 'Course' di tengah navigasi bawah, lalu temukan kategori 'Pembelajaran Umum'."
        ),
        TypeParenting(
            6, "Pengembangan Si kecil dalam pembelajaran Khusus",
            "Fokus pada stimulasi dan penanganan anak dengan indikasi keterlambatan perkembangan atau kebutuhan khusus. Informasi mendalam dan terarah. \n\nLangkah menuju belajar:\nPilih tab 'Course' di tengah navigasi bawah, lalu temukan kategori 'Pembelajaran Khusus'."
        ),
    )


    fun answerAndNext(score: Double) {
        selectAnswer(score)

    }

    fun selectAnswer(score: Double) {
        if (currentIndex < questions.size) {
            val question = questions[currentIndex]
            val finalScore: Double = if (question.isReversed) 6.0 - score else score

            // Tambahkan atau update jawaban
            if (answers.size > currentIndex) {
                answers[currentIndex] = finalScore
            } else {
                answers.add(finalScore)
            }

            _isAnswerSelected.value = true
        }
    }

    fun ResultUserCalculate() {
        val efforts = _effort.value ?: 0.0
        val insights = _insight.value ?: 0.0

        val maxScore = maxOf(efforts, insights)

        // Collect all scores that match the maxScore
        val maxScoresCount = mutableListOf<Double>()
        if (efforts == maxScore) maxScoresCount.add(efforts)
        if (insights == maxScore) maxScoresCount.add(insights)

        val resultId = when {
            efforts < 8 && insights < 8 -> 1
            efforts < 8 && insights > 8 && insights < 12 -> 1
            efforts < 8 && insights > 12 && insights < 15 -> 4
            efforts > 8 && efforts < 12 && insights < 8 -> 2
            efforts > 8 && efforts < 12 && insights > 8 && insights < 12 -> 5
            efforts > 8 && efforts < 12 && insights > 12 && insights < 16 -> 6
            efforts > 12 && efforts < 16 && insights < 8 -> 3
            efforts > 12 && efforts < 16 && insights > 8 && insights < 12 -> 5
            efforts > 12 && efforts < 16 && insights > 12 && insights < 16 -> 6
            else -> 1 // Fallback, though ideally this case shouldn't be reached
        }

        viewModelScope.launch {
            val resultType = typeParenting.firstOrNull { it.id == resultId }
            resultType?.let {
                _resultTypeParenting.value = it
            }
        }


    }

    fun nextQuestion() {
        _isAnswerSelected.value = false
        _isFirstQuestion.value = true
        if (currentIndex < questions.size - 1) {
            currentIndex++
            _liveIndex.value = currentIndex + 1
            _currentQuestion.value = questions[currentIndex].text
            _clearSelection.value = true
            updateIsLastQuestion()
        } else {
            calculateScore()
            _navigateToResult.value = true
        }
    }

    fun backQuestion() {
        _isAnswerSelected.value = false
        if (currentIndex > 0) {
            answers.removeAt(answers.lastIndex)
            currentIndex--
            _liveIndex.value = currentIndex + 1
            _currentQuestion.value = questions[currentIndex].text
            _clearSelection.value = true
            updateIsLastQuestion()
        } else {
            _isFirstQuestion.value = false
        }
    }

    private fun updateIsLastQuestion() {
        _isLastQuestion.value = currentIndex == questions.size - 1
    }

    fun clearSelectionHandled() {
        _clearSelection.value = false
    }

    fun calculateScore() {
        val effort =
            (answers[0] + answers[1] + answers[2])
        val insight =
            (answers[3] + answers[4] + answers[5])

        _effort.value = effort
        _insight.value = insight

        ResultUserCalculate()
    }

    private fun setQuestions() {
        questions = listOf(
            QuestionItem(
                "Saya secara aktif mencari informasi atau sumber belajar tentang parenting dari berbagai media (buku, internet, teman, dll.).",
                QuestionType.EFFORT
            ),
            QuestionItem(
                "Ketika menghadapi tantangan dalam parenting, saya berusaha mencari solusi atau cara baru untuk mengatasinya.",
                QuestionType.EFFORT
            ),
            QuestionItem(
                "Saya meluangkan waktu khusus untuk belajar dan memperdalam ilmu parenting, terlepas dari tantangan yang ada.",
                QuestionType.EFFORT
            ),
            QuestionItem(
                "Saya merasa memiliki pemahaman yang kuat tentang konsep dasar dan prinsip-prinsip parenting yang efektif.",
                QuestionType.INSIGHT,
            ),
            QuestionItem(
                "Saya merasa yakin dan mampu dalam menerapkan berbagai strategi atau teknik parenting dalam keseharian saya.",
                QuestionType.INSIGHT
            ),
            QuestionItem(
                "Saya merasa berpengetahuan luas tentang perkembangan anak dan cara terbaik untuk mendukungnya di setiap tahap usia.",
                QuestionType.INSIGHT,
            ),

        )
    }

}

data class QuestionItem(
    val text: String,
    val type: QuestionType,
    val isReversed: Boolean = false
)

enum class QuestionType {
    EFFORT,
    INSIGHT,
}