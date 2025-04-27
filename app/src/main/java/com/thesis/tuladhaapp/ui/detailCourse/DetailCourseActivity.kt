package com.thesis.tuladhaapp.ui.detailCourse

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.isVisible
import com.google.android.material.tabs.TabLayoutMediator
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityDetailCourseBinding
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.ui.detailCourse.adapter.DetailViewPagerAdapter
import com.thesis.tuladhaapp.ui.detailCourse.player.ExoPlayerManager
import com.thesis.tuladhaapp.ui.detailCourse.player.PlayerManager
import com.thesis.tuladhaapp.utils.formatSecondsToMinutes
import com.thesis.tuladhaapp.utils.proceedWhen
import com.thesis.tuladhaapp.utils.toCurrencyFormat
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

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
    private lateinit var playerManager: PlayerManager

    private var isFullScreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        observeData()
        setTabLayout()
        setOnClickListener()
    }
    override fun onResume() {
        super.onResume()
        getData()
    }


    private fun setOnClickListener() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.swipeRefresh.setOnRefreshListener {
            getData()
            playerManager.release()
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun getData() {
        val courseId = intent.getIntExtra(EXTRA_COURSE, 0)
        viewModel.getDetailCourse(courseId)
    }

    private fun observeData() {
        viewModel.detailCourseData.observe(this) { resultWrapper ->
            resultWrapper.proceedWhen(
                doOnSuccess = {
                    binding.container.isVisible = true
                    binding.btnBuyClass.isVisible = true
                    binding.layoutStateDetailCourse.root.isVisible = false
                    binding.layoutStateDetailCourse.loadingAnimation.isVisible = false
                    binding.layoutStateDetailCourse.tvError.isVisible = false
                    binding.clBtnBuy.isVisible = true
                    bindDetailCourse(it.payload)
                },
                doOnLoading = {
                    binding.layoutStateDetailCourse.root.isVisible = true
                    binding.layoutStateDetailCourse.loadingAnimation.isVisible = true
                    binding.layoutStateDetailCourse.tvError.isVisible = false
                    binding.container.isVisible = false
                    binding.btnBuyClass.isVisible = false
                    binding.clBtnBuy.isVisible = false
                },
                doOnError = {
                    binding.container.isVisible = false
                    binding.btnBuyClass.isVisible = false
                    binding.layoutStateDetailCourse.root.isVisible = true
                    binding.layoutStateDetailCourse.loadingAnimation.isVisible = false
                    binding.layoutStateDetailCourse.tvError.isVisible = true
                    binding.clBtnBuy.isVisible = false
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

            playerManager = ExoPlayerManager(binding.videoView)
            this.lifecycle.addObserver(playerManager)
            item.course?.videoPreviewUrl?.let {
                playerManager.play(it) {
                    checkFullScreen()
                }
            }

            when (item.course?.type) {
                TYPE_GRATIS -> {
                    if (item.isFollowing == true) {
                        binding.clBtnBuy.isVisible = false
                    } else {
                        binding.clBtnBuy.isVisible = true
                        binding.tvTotalPrice.isVisible = false
                        binding.tvCoursePrice.text = getString(R.string.text_free)
                        binding.tvBtnBuy.text = getString(R.string.text_follow_class)
                        binding.btnBuyClass.setOnClickListener {
                            // openStartLearningDialog()
                        }
                    }
                }

                TYPE_PREMIUM -> {
                    if (item.isFollowing == true && item.isAccessible == true) {
                        binding.clBtnBuy.isVisible = false
                    } else {
                        binding.clBtnBuy.isVisible = true
                        binding.tvBtnBuy.text =
                            getString(R.string.text_buy_class)
                        binding.tvTotalPrice.isVisible = true
                        binding.tvCoursePrice.text = item.course.price?.toDouble()?.toCurrencyFormat()
                        binding.btnBuyClass.setOnClickListener {
                           //  openBuyPremiumClass()
                        }
                    }
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







    override fun onDestroy() {
        super.onDestroy()
        this.lifecycle.removeObserver(playerManager)
    }
    companion object {
        const val TYPE_GRATIS = "gratis"
        const val TYPE_PREMIUM = "premium"
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