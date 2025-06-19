package com.thesis.tuladhaapp.ui.testPolaAsuh

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.thesis.tuladhaapp.model.testpolaasuh.TypeParenting
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuickStartViewModel(private val repo: UserRepository) : ViewModel() {

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

    private val _authoritativeScore = MutableLiveData<Double>()
    val authoritativeScore: LiveData<Double> get() = _authoritativeScore

    private val _authoritarianScore = MutableLiveData<Double>()
    val authoritarianScore: LiveData<Double> get() = _authoritarianScore

    private val _permissiveScore = MutableLiveData<Double>()
    val permissiveScore: LiveData<Double> get() = _permissiveScore

    private val _resultTypeParenting = MutableLiveData<TypeParenting>()
    val resultTypeParenting: LiveData<TypeParenting> get() = _resultTypeParenting

    private val answers = mutableListOf<Int>()
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
            1, "Otoritatif",
            "Pola asuh yang menekankan komunikasi terbuka, aturan yang jelas, dan dukungan emosional. Orang tua memberikan bimbingan sambil tetap menghargai pendapat dan kebutuhan anak."
        ),
        TypeParenting(
            2, "Otoriter",
            "Pola asuh yang berfokus pada kepatuhan dan kontrol tinggi. Orang tua menuntut disiplin ketat, namun kurang melibatkan anak dalam pengambilan keputusan dan menunjukkan kehangatan emosional."
        ),
        TypeParenting(
            3, "Permisif",
            "Pola asuh yang memberikan kebebasan hampir tanpa batas. Orang tua cenderung menghindari aturan tegas dan jarang memberikan konsekuensi atas perilaku anak."
        ),
        TypeParenting(
            4, "Tidak Diketahui",
            "Maaf, terdapat tipe pola asuh yang memiliki nilai uji yang sama, silahkan untuk melakukan tes pola asuh ulang, untuk memastikan tipe pola asuh yang cocok dengan diri anda"
        )
    )


    fun answerAndNext(score: Int) {
        selectAnswer(score)
//        if (_isLastQuestion.value != true) {
//            viewModelScope.launch {
//                delay(1000L) // 1 detik delay
//                nextQuestion()
//            }
//        }

    }

    fun selectAnswer(score: Int) {
        if (currentIndex < questions.size) {
            val question = questions[currentIndex]
            val finalScore = if (question.isReversed) 6 - score else score

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
        val authoritative = _authoritativeScore.value ?: 0.0
        val authoritarian = _authoritarianScore.value ?: 0.0
        val permissive = _permissiveScore.value ?: 0.0
        val maxScore = maxOf(authoritative, authoritarian, permissive)

        // Collect all scores that match the maxScore
        val maxScoresCount = mutableListOf<Double>()
        if (authoritative == maxScore) maxScoresCount.add(authoritative)
        if (authoritarian == maxScore) maxScoresCount.add(authoritarian)
        if (permissive == maxScore) maxScoresCount.add(permissive)

        val resultId = when {
            // If there's more than one score that equals the maxScore, set resultId to 4
            maxScoresCount.size > 1 -> 4
            // Otherwise, determine the resultId based on the single max score
            authoritative == maxScore -> 1
            authoritarian == maxScore -> 2
            permissive == maxScore -> 3
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
        val authoritative =
            (answers[0] + answers[2] + answers[4] + answers[6] + answers[8] + answers[10] + answers[11] + answers[13] + answers[17] + answers[20] + answers[21] + answers[24] + answers[26] + answers[28] + answers[30]) / 15.0

        val authoritarian =
            (answers[1] + answers[3] + answers[5] + answers[9] + answers[12] + answers[15] + answers[18] + answers[22] + answers[25] + answers[27] + answers[29] + answers[31]) / 12.0

        val permissive = (answers[7] + answers[14] + answers[16] + answers[19] + answers[23]) / 5.0

        _authoritativeScore.value = authoritative
        _authoritarianScore.value = authoritarian
        _permissiveScore.value = permissive

        ResultUserCalculate()
    }

    private fun setQuestions() {
        questions = listOf(
            QuestionItem(
                "Saya peka terhadap perasaan dan kebutuhan anak saya sendiri.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya menggunakan hukuman fisik sebagai cara mendisiplinkan anak.",
                QuestionType.AUTHORITARIAN
            ),
            QuestionItem(
                "Saya terlebih dulu mempertimbangkan keinginan anak sebelum memintanya melakukan sesuatu.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Bila anak menanyakan mengapa dia harus melakukan sesuatu, Saya menjawab karena Saya yang menyuruh, atau Saya adalah orang tuanya dan hal itu yang Saya inginkan",
                QuestionType.AUTHORITARIAN,
            ),
            QuestionItem(
                "Saya menjelaskan pada anak bagaimana perasaan saya tentang perilakunya yang baik dan buruknya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya memukul anak ketika anak tidak mematuhi aturan.",
                QuestionType.AUTHORITARIAN,
            ),
            QuestionItem(
                "Saya mendorong anak untuk berbicara mengenai perasaan dan masalah-masalahnya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya merasa kesusahan dalam mendisiplikan anak.",
                QuestionType.PERMISSIVE
            ),
            QuestionItem(
                "Saya mendorong anak untuk menyatakan perasaannya dengan bebas, meskipun dia tidak setuju dengan Saya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                " Saya menghukum anak dengan menghilangkan hak kebebasannya, tetapi Saya memberikan sedikit penjelasan (misal menonton tv, bermain dengan teman atau bermain game).",
                QuestionType.AUTHORITARIAN,
            ),
            QuestionItem(
                "Saya memberikan alasan mengapa aturan harus ditaati pada anak.",
                QuestionType.AUTHORITATIVE,
            ),
            QuestionItem(
                "Saya menghibur dan memberikan pemahaman kepada anak ketika anak sedang marah.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya berteriak atau memarahi ketika anak berlaku tidak pantas atau nakal",
                QuestionType.AUTHORITARIAN,
            ),
            QuestionItem(
                "Saya memberikan pujian pada anak ketika melakukan hal yang baik.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya membiarkan anak melakukan sesuatu yang dapat mencelakai dirinya.",
                QuestionType.PERMISSIVE,
            ),
            QuestionItem(
                "Saya melampiaskan kemarahan kepada anak.",
                QuestionType.AUTHORITARIAN
            ),
            QuestionItem(
                "Saya lebih sering menggunakan ancaman sebagai bentuk hukuman.",
                QuestionType.PERMISSIVE,
            ),
            QuestionItem(
                "Saya mempertimbangkan pilihan anak dalam merencanakan sesuatu untuk keluarga (misal liburan bersama).",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya menghukum anak dengan tidak emosi, tetapi memberikan kasih sayang seperti memeluk atau mencium.",
                QuestionType.AUTHORITARIAN,
            ),
            QuestionItem(
                "Saya menggunakan ancaman untuk menghukum anak dan tidak benar-benar melakukannya.",
                QuestionType.PERMISSIVE,
            ),
            QuestionItem(
                "Saya menghargai pendapat anak dengan mendorongnya untuk mengemukakannya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya mengijinkan anak untuk memberikan masukan dalam membuat peraturan keluarga.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya memarahi dan mengkritik anak supaya dia memperbaiki kelakuannya.",
                QuestionType.AUTHORITARIAN
            ),
            QuestionItem(
                "Saya memberikan alasan/penjelasan terlebih dahulu pada anak mengapa peraturan harus ditaati.",
                QuestionType.PERMISSIVE
            ),
            QuestionItem(
                "Saya memberikan alasan kepada anak mengapa aturan yang telah ditetapkan harus ditaat.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya menggunakan ancaman sebagai bentuk hukuman dengan sedikit atau tanpa pembenaran dari anak.",
                QuestionType.AUTHORITARIAN,
            ),
            QuestionItem(
                "Saya meluangkan waktu dengan suasana hangat dan akrab dengan anak.",
                QuestionType.AUTHORITATIVE,
            ),
            QuestionItem(
                "Saya menghukum anak dengan mengurung anak sendirian dengan tidak memberikan penjelasan/sedikit penjelasan.",
                QuestionType.AUTHORITARIAN
            ),
            QuestionItem(
                "Saya membantu anak untuk memahami dampak dan konsekuensi dari perilakunya dengan memberikan kesempatan anak untuk menjelaskan akibat-akibat dari tindakannya sendiri",
                QuestionType.AUTHORITATIVE,
            ),
            QuestionItem(
                "Saya memarahi atau mengkritik anak saat perilakunya tidak sesuai dengan yang Saya harapkan.",
                QuestionType.AUTHORITARIAN
            ),
            QuestionItem(
                "Saya menjelaskan konsekuensi dari perilaku yang dilakukan anak.",
                QuestionType.AUTHORITATIVE,
            ),
            QuestionItem(
                "Saya memukul anak ketika anak berperilaku buruk",
                QuestionType.AUTHORITARIAN
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
    AUTHORITATIVE,
    AUTHORITARIAN,
    PERMISSIVE
}