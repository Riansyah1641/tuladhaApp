package com.thesis.tuladhaapp.ui.assesmentCourse

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.shashank.sony.fancytoastlib.FancyToast
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityFeedbackCourseBinding
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.model.detailcourse.CourseDetailData
import com.thesis.tuladhaapp.ui.main.MainActivity
import com.thesis.tuladhaapp.ui.profile.ProfileViewModel
import android.util.Log
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedbackCourseActivity() : AppCompatActivity() {

    private var idSeekBar = 0
    private var idCourse = 0
    private var idUser = ""

    private val viewModel: AssesmentCourseViewModel by viewModel()
    private val profileViewModel: ProfileViewModel by viewModel()

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
        idCourse = intent.getIntExtra("ID_COURSE", 0)
        viewModel.getDetailCourse(idCourse)
        idUser = profileViewModel.getCurrentUser()?.id ?: ""
    }

    private fun setOnClickListener() {
        binding.btnSubmit.setOnClickListener {
            sendDataCourseToDatabase()
            checkDoneFeedback()
            navigateToHome()
        }
        binding.toolbar.setOnClickListener {
            finish()
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity((intent))
        finish()
    }


    private fun sendDataCourseToDatabase() {

        viewModel.detailCourseData.observe(this) { resultWrapper ->
            resultWrapper.proceedWhen(
                doOnSuccess = { detailCourse ->
                    detailCourse.payload?.let { selectedCourse ->
                        val courseDataToSend = CourseData(
                            id = selectedCourse.id,
                            userId = idUser,
                            courseId = selectedCourse.courseId,
                            isAccessible = selectedCourse.isAccessible,
                            isFollowing = selectedCourse.isFollowing,
                            lastSeen = selectedCourse.lastSeen,
                            progress = "Selesai",
                            progressPercentage = 35,
                            createdAt = selectedCourse.createdAt,
                            updatedAt = selectedCourse.updatedAt,
                            course = selectedCourse.course
                        )

                        viewModel.sendCourseData(courseDataToSend, idUser) { isSuccess, message ->
                            if (isSuccess) {
                                FancyToast.makeText(this@FeedbackCourseActivity, "Selamat, Anda Menyelesaikan Course Ini", FancyToast.LENGTH_SHORT,FancyToast.SUCCESS, false).show()
                            } else {
                                FancyToast.makeText(this@FeedbackCourseActivity, "Maaf, terjadi kesalahan, harap coba lagi: $message",FancyToast.LENGTH_SHORT, FancyToast.ERROR, true).show()
                            }

                        }
                    }
                },
                doOnLoading = {
                    Log.d("SendData", "Harap Tunggu...")
                },
                doOnError = { error ->
                    FancyToast.makeText(this@FeedbackCourseActivity, "Gagal Menyimpan Riwayat Course: ${error?.message}",FancyToast.LENGTH_SHORT, FancyToast.ERROR, true).show()
                }
            )
        }
    }


    private fun checkDoneFeedback() {
        val feedbackText = binding.etFeedback.text.toString().trim()

        if (feedbackText.isNotEmpty()) {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
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