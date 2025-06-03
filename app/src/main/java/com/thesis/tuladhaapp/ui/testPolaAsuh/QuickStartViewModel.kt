package com.thesis.tuladhaapp.ui.testPolaAsuh

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.thesis.tuladhaapp.data.dataSource.typePareting.DataTypeParentingImpl
import com.thesis.tuladhaapp.model.testpolaasuh.TypeParenting
import com.thesis.tuladhaapp.repository.typeParenting.TypeParentingRepository
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
        Dispatchers.IO)

    init {
        setQuestions()
        _liveIndex.value = currentIndex + 1
        _currentQuestion.value = questions[currentIndex].text
    }

    private val typeParenting = listOf(
        TypeParenting(
            1, "Authoritative",
            "Pola asuh yang menekankan komunikasi terbuka, aturan yang jelas, dan dukungan emosional. Orang tua memberikan bimbingan sambil tetap menghargai pendapat dan kebutuhan anak."
        ),
        TypeParenting(
            2, "Authoritarian",
            "Pola asuh yang berfokus pada kepatuhan dan kontrol tinggi. Orang tua menuntut disiplin ketat, namun kurang melibatkan anak dalam pengambilan keputusan dan menunjukkan kehangatan emosional."
        ),
        TypeParenting(
            3, "Permissive",
            "Pola asuh yang memberikan kebebasan hampir tanpa batas. Orang tua cenderung menghindari aturan tegas dan jarang memberikan konsekuensi atas perilaku anak."
        )
    )




    fun answerAndNext(score: Int) {
        selectAnswer(score)
        if (_isLastQuestion.value != true) {
            viewModelScope.launch {
                delay(300L) // 1 detik delay
                nextQuestion()
            }
        }

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

        val resultId = when (maxScore) {
            authoritative -> 1
            authoritarian -> 2
            permissive -> 3
            else -> 1
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

    private fun updateIsLastQuestion() {
        _isLastQuestion.value = currentIndex == questions.size - 1
    }

    fun clearSelectionHandled() {
        _clearSelection.value = false
    }

    fun calculateScore() {
        val authoritative = questions
            .filter { it.type == QuestionType.AUTHORITATIVE }
            .mapIndexed { index, _ -> answers.getOrNull(index) ?: 0 }
            .sum() / 27.0

        val authoritarian = questions
            .filter { it.type == QuestionType.AUTHORITARIAN }
            .mapIndexed { index, _ -> answers.getOrNull(index) ?: 0 }
            .sum() / 20.0

        val permissive = questions
            .filter { it.type == QuestionType.PERMISSIVE }
            .mapIndexed { index, _ -> answers.getOrNull(index) ?: 0 }
            .sum() / 15.0

        _authoritativeScore.value = authoritative
        _authoritarianScore.value = authoritarian
        _permissiveScore.value = permissive

        ResultUserCalculate()
    }

    private fun setQuestions() {
        questions = listOf(
            QuestionItem(
                "Saya mendorong anak saya untuk berbicara tentang masalahnya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya membimbing anak saya lebih dengan hukuman daripada alasan.",
                QuestionType.AUTHORITARIAN
            ),
            QuestionItem("Saya tahu nama-nama teman anak saya.", QuestionType.AUTHORITATIVE),
            QuestionItem(
                "Saya merasa sulit untuk mendisiplinkan anak saya.",
                QuestionType.PERMISSIVE,
                isReversed = true
            ),
            QuestionItem(
                "Saya memberikan pujian ketika anak saya berperilaku baik.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya memukul pantat anak saya ketika ia tidak patuh.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem("Saya bercanda dan bermain dengan anak saya.", QuestionType.AUTHORITATIVE),
            QuestionItem(
                "Saya menahan diri untuk tidak memarahi/mengkritik meskipun anak saya bertindak berlawanan dengan keinginan saya.",
                QuestionType.PERMISSIVE
            ),
            QuestionItem(
                "Saya menunjukkan simpati ketika anak saya terluka atau frustasi.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya menghukum dengan mengambil hak istimewa anak saya tanpa penjelasan.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem("Saya memanjakan anak saya.", QuestionType.PERMISSIVE, isReversed = true),
            QuestionItem(
                "Saya memberikan kenyamanan dan pengertian ketika anak saya kesal.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya berteriak atau membentak ketika anak saya berperilaku buruk.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem(
                "Saya bersikap santai dan rileks dengan anak saya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya membiarkan anak saya mengganggu orang lain.",
                QuestionType.PERMISSIVE,
                isReversed = true
            ),
            QuestionItem(
                "Saya menjelaskan harapan saya mengenai perilaku sebelum anak saya melakukan suatu aktivitas.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya memarahi dan mengkritik untuk membuat anak saya menjadi lebih baik.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem(
                "Saya menunjukkan kesabaran terhadap anak saya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya mengguncang anak saya ketika ia tidak patuh.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem(
                "Saya menyebutkan hukuman kepada anak saya tetapi tidak benar-benar melakukannya.",
                QuestionType.PERMISSIVE,
                isReversed = true
            ),
            QuestionItem(
                "Saya responsif terhadap perasaan atau kebutuhan anak saya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya mengizinkan anak saya memberikan masukan dalam aturan keluarga.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem("Saya berdebat dengan anak saya.", QuestionType.AUTHORITARIAN),
            QuestionItem(
                "Saya tampak percaya diri dalam kemampuan sebagai orang tua.",
                QuestionType.PERMISSIVE
            ),
            QuestionItem(
                "Saya memberikan alasan mengapa aturan harus dipatuhi.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya tampak lebih peduli dengan perasaan saya sendiri daripada perasaan anak saya.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem(
                "Saya memberi tahu anak saya bahwa saya menghargai apa yang ia coba atau capai.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya menghukum dengan mengasingkan anak saya sendirian tanpa penjelasan.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem(
                "Saya membantu anak saya memahami dampak perilakunya dengan mendorongnya berbicara tentang konsekuensi dari tindakannya sendiri.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya takut bahwa mendisiplinkan anak saya untuk perilaku buruk akan membuatnya tidak menyukai saya sebagai orang tua.",
                QuestionType.PERMISSIVE,
                isReversed = true
            ),
            QuestionItem(
                "Saya mempertimbangkan keinginan anak saya sebelum memintanya melakukan sesuatu.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya meledak dalam kemarahan terhadap anak saya.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem(
                "Saya menyadari masalah atau kekhawatiran tentang anak saya di sekolah.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya mengancam anak saya dengan hukuman lebih sering daripada benar-benar memberikannya.",
                QuestionType.PERMISSIVE,
                isReversed = true
            ),
            QuestionItem(
                "Saya menunjukkan kasih sayang dengan memeluk, mencium, dan memegang anak saya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya mengabaikan perilaku buruk anak saya.",
                QuestionType.PERMISSIVE,
                isReversed = true
            ),
            QuestionItem(
                "Saya menggunakan hukuman fisik sebagai cara mendisiplinkan anak saya.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem(
                "Saya memberikan disiplin setelah anak saya berperilaku buruk.",
                QuestionType.PERMISSIVE
            ),
            QuestionItem(
                "Saya meminta maaf kepada anak saya ketika melakukan kesalahan dalam pengasuhan.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya memberi tahu anak saya apa yang harus dilakukan.",
                QuestionType.AUTHORITARIAN
            ),
            QuestionItem(
                "Saya menyerah pada anak saya ketika ia membuat keributan tentang sesuatu.",
                QuestionType.PERMISSIVE,
                isReversed = true
            ),
            QuestionItem(
                "Saya berbicara dan memberikan alasan kepada anak saya ketika ia berperilaku buruk.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya menampar anak saya ketika ia berperilaku buruk.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem("Saya tidak setuju dengan anak saya.", QuestionType.AUTHORITARIAN),
            QuestionItem(
                "Saya membiarkan anak saya menyela orang lain.",
                QuestionType.PERMISSIVE,
                isReversed = true
            ),
            QuestionItem(
                "Saya memiliki waktu yang hangat dan intim bersama anak saya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Ketika dua anak bertengkar, saya mendisiplinkan mereka terlebih dahulu dan bertanya kemudian.",
                QuestionType.AUTHORITARIAN
            ),
            QuestionItem(
                "Saya mendorong anak saya untuk mengekspresikan dirinya secara bebas bahkan ketika tidak setuju dengan orang tua.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya menyuap anak saya dengan hadiah untuk mendapatkan kepatuhan.",
                QuestionType.PERMISSIVE,
                isReversed = true
            ),
            QuestionItem(
                "Saya memarahi atau mengkritik ketika perilaku anak saya tidak memenuhi harapan saya.",
                QuestionType.AUTHORITARIAN
            ),
            QuestionItem(
                "Saya menunjukkan penghargaan terhadap pendapat anak saya dengan mendorongnya untuk mengekspresikannya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya menetapkan aturan yang ketat dan mapan untuk anak saya.",
                QuestionType.PERMISSIVE,
                isReversed = true
            ),
            QuestionItem(
                "Saya menjelaskan kepada anak saya bagaimana perasaan saya tentang perilaku baik dan buruknya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya menggunakan ancaman sebagai hukuman dengan sedikit atau tanpa pembenaran.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem(
                "Saya mempertimbangkan preferensi anak saya dalam membuat rencana untuk keluarga.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Ketika anak saya bertanya mengapa ia harus menuruti, saya menjawab: \"Karena saya bilang begitu,\" atau \"Saya orang tuamu dan aku ingin kamu melakukannya.\"",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem(
                "Saya tampak tidak yakin bagaimana menyelesaikan perilaku buruk anak saya.",
                QuestionType.PERMISSIVE,
                isReversed = true
            ),
            QuestionItem(
                "Saya menjelaskan konsekuensi dari perilaku anak saya.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya menuntut anak saya untuk melakukan sesuatu.",
                QuestionType.AUTHORITARIAN
            ),
            QuestionItem(
                "Saya mengarahkan perilaku buruk anak saya ke aktivitas yang lebih dapat diterima.",
                QuestionType.AUTHORITATIVE
            ),
            QuestionItem(
                "Saya mendorong anak saya ketika ia tidak patuh.",
                QuestionType.AUTHORITARIAN,
                isReversed = true
            ),
            QuestionItem("Saya menekankan alasan untuk aturan.", QuestionType.AUTHORITATIVE)
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