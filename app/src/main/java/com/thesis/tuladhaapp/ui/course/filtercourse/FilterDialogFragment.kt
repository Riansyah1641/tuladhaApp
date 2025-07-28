package com.thesis.tuladhaapp.ui.course.filtercourse

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.andrefrsousa.superbottomsheet.SuperBottomSheetFragment
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.FragmentFilterDialogBinding
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.ui.course.CourseViewModel
import com.thesis.tuladhaapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.getViewModel

class FilterDialogFragment : SuperBottomSheetFragment() {

    private lateinit var binding: FragmentFilterDialogBinding

    private val viewModel: CourseViewModel by lazy { requireParentFragment().getViewModel() }
    private var isSettingCheckboxesProgrammatically = false
    private val categoryAdapter: CategoryFilterAdapter by lazy {
        CategoryFilterAdapter(object : CategoryItemListener {
            override fun onCategoryChecked(category: Category) {
                viewModel.addSelectedCategory(category)
            }
            override fun onCategoryUnchecked(category: Category) {
                viewModel.removeSelectedCategory(category)
            }
            override fun getSelectedCategories(): List<Category>? {
                return viewModel.selectedCategories.value
            }
        })
    }

    private var filterListener: OnFilterListener? = null

    interface OnFilterListener {
        fun onFilterApplied(
            search: String?,
            type: String?,
            category: List<Category>?,
            level: List<String>?,
            sortBy: String?
        )
    }

    fun setFilterListener(listener: OnFilterListener) {
        filterListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentFilterDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getExpandedHeight(): Int {
        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenHeight = displayMetrics.heightPixels
        println(screenHeight)
        return (screenHeight * 0.9).toInt()
    }

    override fun isSheetAlwaysExpanded(): Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        observeCategoryList()
        setClickListener()
    }

    private fun setClickListener() {
        binding.ivClose.setOnClickListener {
            dialog?.dismiss()
        }
        binding.btnFilter.setOnClickListener {
            applyFilter()
        }
        binding.tvResetFilter.setOnClickListener {
            resetFilter()
            dismiss()
        }

        // Listener untuk kelompok checkbox "0-12 Bulan"
        val monthCheckboxes = listOf(
            binding.cb03Bulan,
            binding.cb36Bulan,
            binding.cb69Bulan,
            binding.cb912Bulan
        )

        monthCheckboxes.forEach { checkBox ->
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (!isSettingCheckboxesProgrammatically) {
                    // Jika ada satu yang dicentang, centang semua dalam kelompok
                    if (isChecked) {
                        setMonthCheckboxes(true)
                    } else {
                        // Jika satu tidak dicentang, biarkan yang lain jika masih ada yang tercentang
                        // Atau jika semua dicentang dan salah satu di-uncheck, uncheck semua.
                        // Logic ini memastikan jika salah satu di-uncheck, hanya yang di-uncheck yang berubah,
                        // kecuali jika semua awalnya tercentang dan salah satu di-uncheck.
                        val allMonthCheckboxes = listOf(
                            binding.cb03Bulan,
                            binding.cb36Bulan,
                            binding.cb69Bulan,
                            binding.cb912Bulan
                        )
                        val allChecked = allMonthCheckboxes.all { it.isChecked }
                        if (allChecked && !isChecked) { // Jika semua awalnya checked dan yang ini di-uncheck
                            setMonthCheckboxes(false) // Maka uncheck semua
                        }
                    }
                }else{
                    binding.rvFilterCategory.isVisible = true
                }
            }
        }
    }

    private fun setMonthCheckboxes(isChecked: Boolean) {
        isSettingCheckboxesProgrammatically = true
        if (isChecked == true){
            binding.rvFilterCategory.isVisible = false
        }else{
            binding.rvFilterCategory.isVisible = true
        }

        isSettingCheckboxesProgrammatically = false
    }

    private fun resetFilter() {
        val searchQuery = null
        val selectedType = null
        val selectedCategories = emptyList<Category>()
        viewModel.clearSelectedCategories()

        val selectedLevels = mutableListOf<String>().apply {

            binding.cb03Bulan.isChecked = false
            binding.cb12Tahun.isChecked = false
            binding.cb23Tahun.isChecked = false
            binding.cb34Tahun.isChecked = false
            binding.cb36Bulan.isChecked = false
            binding.cb45Tahun.isChecked = false
            binding.cb69Bulan.isChecked = false
            binding.cb912Bulan.isChecked = false
        }
        val selectedSortBy = null
        binding.topPicks.clearCheck()

        filterListener?.onFilterApplied(searchQuery, selectedType, selectedCategories, selectedLevels, selectedSortBy)
    }

    private fun applyFilter() {
        val searchQuery = viewModel.searchQuery.value
        val selectedType = viewModel.selectedType.value
        val selectedCategories = viewModel.selectedCategories.value
        val selectedLevels = mutableListOf<String>().apply {
            if (binding.cb03Bulan.isChecked) add(BULAN_1_3_LEVEL)
            if (binding.cb36Bulan.isChecked) add(BULAN_3_6_LEVEL)
            if (binding.cb69Bulan.isChecked) add(BULAN_6_9_LEVEL)
            if (binding.cb912Bulan.isChecked) add(BULAN_9_12_LEVEL)
            if (binding.cb12Tahun.isChecked) add(TAHUN_1_2_LEVEL)
            if (binding.cb23Tahun.isChecked) add(TAHUN_2_3_LEVEL)
            if (binding.cb34Tahun.isChecked) add(TAHUN_3_4_LEVEL)
            if (binding.cb45Tahun.isChecked) add(TAHUN_4_5_LEVEL)
        }
        val selectedSortBy = when (binding.topPicks.checkedRadioButtonId) {
            R.id.rb_new -> NEW_SORT
            R.id.rb_popular -> POPULAR_SORT
            R.id.rb_promo -> PROMO_SORT
            else -> null
        }
        filterListener?.onFilterApplied(searchQuery, selectedType, selectedCategories, selectedLevels, selectedSortBy)
        dismiss()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    private fun getData() {
        viewModel.getCategories()
    }

    private fun observeCategoryList() {
        viewModel.categories.observe(viewLifecycleOwner) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.rvFilterCategory.apply {
                        adapter = categoryAdapter
                    }
                    it.payload?.let { data -> categoryAdapter.submitData(data) }
                }
            )
        }
    }

    companion object {
        const val BULAN_1_3_LEVEL = "0-3 Bulan"
        const val BULAN_3_6_LEVEL = "3-6 Bulan"
        const val BULAN_6_9_LEVEL = "6-9 Bulan"
        const val BULAN_9_12_LEVEL = "9-12 Bulan"
        const val TAHUN_1_2_LEVEL = "1-2 Tahun"
        const val TAHUN_2_3_LEVEL = "2-3 Tahun"
        const val TAHUN_3_4_LEVEL = "3-4 Tahun"
        const val TAHUN_4_5_LEVEL = "4-5 Tahun"
        const val NEW_SORT = "terbaru"
        const val POPULAR_SORT = "terpopuler"
        const val PROMO_SORT = "rating"

    }
}
