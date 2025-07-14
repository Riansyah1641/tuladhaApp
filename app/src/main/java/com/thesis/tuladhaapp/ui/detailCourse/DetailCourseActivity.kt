package com.thesis.tuladhaapp.ui.detailCourse

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.isVisible
import com.google.android.material.tabs.TabLayoutMediator
import com.shashank.sony.fancytoastlib.FancyToast
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityDetailCourseBinding
import com.thesis.tuladhaapp.databinding.DialogNonLoginBinding
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.ui.auth.login.LoginActivity
import com.thesis.tuladhaapp.ui.detailCourse.adapter.DetailViewPagerAdapter
import com.thesis.tuladhaapp.ui.detailCourse.player.ExoPlayerManager
import com.thesis.tuladhaapp.ui.detailCourse.player.PlayerManager
import com.thesis.tuladhaapp.ui.kuisCourse.QuizActivity
import com.thesis.tuladhaapp.ui.profile.ProfileViewModel
import com.thesis.tuladhaapp.utils.formatSecondsToMinutes
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.net.URLEncoder

class DetailCourseActivity : AppCompatActivity() {
    private val binding: ActivityDetailCourseBinding by lazy {
        ActivityDetailCourseBinding.inflate(layoutInflater)
    }
    private val viewModel: DetailCourseViewModel by viewModel {
        parametersOf(intent.extras ?: bundleOf())
    }
    private val windowInsetsController: WindowInsetsControllerCompat by lazy {
        WindowCompat.getInsetsController(window, window.decorView)
    }
    private var playerManager: PlayerManager? = null

    private var isFullScreen = false
    private val profileViewModel: ProfileViewModel by viewModel()

    var courseId: Int? = 2
    private var idUser = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        WindowCompat.setDecorFitsSystemWindows(window, true)

        observeData()
        getData()
        sendDataCourseToDatabase()
        setTabLayout()
        setOnClickListener()
    }

    override fun onStart() {
        super.onStart()
        // Inisialisasi player di onStart()
        if (playerManager == null) {
            playerManager = ExoPlayerManager(binding.videoView)
            this.lifecycle.addObserver(playerManager!!) // Pastikan playerManager tidak null
        }
        // Pastikan video diputar ulang jika ada URL
        // Anda mungkin perlu menyimpan URL video atau memuatnya kembali dari viewModel
        viewModel.detailCourseData.value?.proceedWhen(
            doOnSuccess = {
                it.payload?.course?.videoPreviewUrl?.let { videoUrl ->
                    playerManager?.play(videoUrl) { isFullScreen ->
                        checkFullScreen()
                    }
                }
            }
        )
    }

    override fun onStop() {
        super.onStop()
        playerManager?.release()
        playerManager = null
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            enterFullScreen()
        } else {
            exitFullScreen()
            WindowCompat.setDecorFitsSystemWindows(window, true)
        }
    }

    private fun exitFullScreen() {
        isFullScreen = false
        windowInsetsController.show(WindowInsetsCompat.Type.systemBars())
        binding.llToolbar.isVisible = true
        binding.clVideoPlayerContainer.isVisible = true
        binding.videoView.isVisible = true
        binding.clBtnBuy.isVisible = true
        binding.container.isVisible = true
        binding.container.fitsSystemWindows = true
        val params =
            binding.clVideoPlayerContainer.layoutParams as ConstraintLayout.LayoutParams
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = 0
        params.dimensionRatio = "16:9"
        binding.clVideoPlayerContainer.layoutParams = params

    }

    private fun enterFullScreen() {
        isFullScreen = true
        binding.container.fitsSystemWindows = false
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
        binding.llToolbar.isVisible = false
        binding.clBtnBuy.isVisible = false
        binding.clVideoPlayerContainer.isVisible = true
        binding.videoView.isVisible = true
        binding.container.isVisible = false
        val params =
            binding.clVideoPlayerContainer.layoutParams as ConstraintLayout.LayoutParams
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.MATCH_PARENT
        binding.clVideoPlayerContainer.layoutParams = params
    }


    private fun setOnClickListener() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.swipeRefresh.setOnRefreshListener {
            getData()
            binding.swipeRefresh.isRefreshing = false
        }
        binding.btnKonsultasi.setOnClickListener {
            val temaKelas = binding.tvDetailTitle.text.toString()
            val createVideo = binding.tvBy.text.toString()
            val phoneNumber = "6282144445148"
            val message =
                "Hii admin tuladha, Saya ingin berkonsultasi lebih lanjut terkait $temaKelas yang dijelaskan oleh $createVideo"

            // 3. Buat dan luncurkan Intent WhatsApp
            try {
                val encodedMessage = URLEncoder.encode(message, "UTF-8")
                val uri =
                    Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber&text=$encodedMessage")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } catch (e: Exception) {
                FancyToast.makeText(
                    it.context,
                    "WhatsApp tidak terinstal atau terjadi kesalahan.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnNextQuiz.setOnClickListener {
            if (profileViewModel.isUserLoggedIn()) {
                nextToQuiz()
            } else {
                loginDialog()
            }
        }
    }

    private fun loginDialog() {
        val binding: DialogNonLoginBinding = DialogNonLoginBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this, 0).create()

        dialog.apply {
            setView(binding.root)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }.show()

        binding.clSignUp.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            dialog.dismiss()
        }
    }

    private fun nextToQuiz() {
        val intent = Intent(this, QuizActivity::class.java).apply {
            putExtra("ID_COURSE", courseId)
        }
        startActivity(intent)
        finish()
    }

    private fun getData() {
        courseId = intent.getIntExtra(EXTRA_COURSE, 0)
        viewModel.getDetailCourse(courseId!!)
        idUser = profileViewModel.getCurrentUser()?.id ?: ""
    }

    private fun observeData() {
        viewModel.detailCourseData.observe(this) { resultWrapper ->
            resultWrapper.proceedWhen(
                doOnSuccess = {
                    binding.container.isVisible = true
                    bindDetailCourse(it.payload)
                },
                doOnLoading = {
                    binding.container.isVisible = false


                },
                doOnError = {
                    binding.container.isVisible = false
                }
            )
        }
    }


    private fun bindDetailCourse(courseData: CourseData?) {
        courseData?.let { item ->
            binding.tvTitle.text = item.course?.category?.name
            binding.tvDetailTitle.text = item.course?.name
            binding.tvBy.text =
                getString(
                    R.string.format_course_by,
                    item.course?.courseBy
                )
            binding.tvLevel.text =
                item.course?.level?.replaceFirstChar {
                    it.uppercase()
                }
            binding.tvModul.text =
                getString(
                    R.string.format_course_module,
                    item.course?.totalModule
                )
            binding.tvTime.text =
                getString(
                    R.string.format_course_duration,
                    item.course?.totalDuration?.let { formatSecondsToMinutes(it) }
                )
            binding.tvRating.text = item.course?.rating.toString()

            val bundle =
                Bundle().apply {
                    putParcelable(COURSE_DATA, courseData)
                }
            val aboutClassFragment = AboutClassFragment()
            aboutClassFragment.arguments = bundle
            val materialClassFragment = ClassMaterialFragment()
            materialClassFragment.arguments = bundle

            item.course?.videoPreviewUrl?.let { videoUrl ->
                playerManager?.play(videoUrl) { isFullScreen ->
                    checkFullScreen()
                }
            }
        }
    }

    private fun checkFullScreen(): Boolean {
        if (checkLandscapeOrientation()) {
            changeOrientationToLandscape(false)
        } else {
            changeOrientationToLandscape(true)
        }
        return isFullScreen
    }

    fun checkLandscapeOrientation(): Boolean {
        val orientation = resources.configuration.orientation
        return orientation == Configuration.ORIENTATION_LANDSCAPE
    }

    fun changeOrientationToLandscape(shouldLandscape: Boolean) {
        requestedOrientation =
            if (shouldLandscape) {
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            } else {
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
    }

    private fun setTabLayout() {
        val tabArray =
            arrayOf(
                getString(R.string.tv_tab_detail_about),
                getString(R.string.tv_tab_detail_material_class)
            )
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = DetailViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabArray[position]
        }.attach()
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
                            progress = "On Progress",
                            progressPercentage = 35,
                            createdAt = selectedCourse.createdAt,
                            updatedAt = selectedCourse.updatedAt,
                            course = selectedCourse.course
                        )

                        viewModel.sendCourseData(courseDataToSend, idUser) { isSuccess, message ->

                        }
                    }
                },
                doOnLoading = {
                    Log.d("SendData", "Harap Tunggu...")
                },
                doOnError = { error ->
                    FancyToast.makeText(
                        this, "Gagal Menyimpan Riwayat Course: ${error?.message}",
                        FancyToast.LENGTH_SHORT, FancyToast.ERROR, true
                    ).show()
                }
            )
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        playerManager?.let { this.lifecycle.removeObserver(it) }
    }

    companion object {
        const val EXTRA_COURSE = "EXTRA_COURSE"
        const val COURSE_DATA = "COURSE_DATA"

        fun startActivity(
            context: Context,
            courseId: Int?
        ) {
            val intent = Intent(context, DetailCourseActivity::class.java)
            intent.putExtra(EXTRA_COURSE, courseId)
            context.startActivity(intent)
        }
    }
}