package com.thesis.tuladhaapp.ui.testPolaAsuh

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.thesis.tuladhaapp.databinding.FrangmentTestpolaasuhBinding

class QuickStartActivity : AppCompatActivity() {

    private lateinit var binding: FrangmentTestpolaasuhBinding
    private val viewModel: QuickStartViewModel by viewModels()
    private var hasNavigatedToResult = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FrangmentTestpolaasuhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.quickStartViewModel = viewModel
        binding.lifecycleOwner = this

        setupObservers()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.nextQuickQuestion.setOnClickListener {
            if (binding.nextQuickQuestion.text == "Selesai") {
                viewModel.ResultUserCalculate()
            }
        }
        binding.ivBack.setOnClickListener{
            onBackPressed()
        }
    }

    private fun setupObservers() {
        viewModel.clearSelection.observe(this) { shouldClear ->
            if (shouldClear) {
                binding.radioGroupLikert.clearCheck()
                viewModel.clearSelectionHandled()
            }
        }

        viewModel.resultTypeParenting.observe(this) { typeParenting ->
            if (!hasNavigatedToResult && typeParenting != null) {
                hasNavigatedToResult = true // supaya tidak double intent
                val intent = Intent(this, ResultTestActivity::class.java).apply {
                    putExtra("TYPE_ID", typeParenting.id)
                    putExtra("TYPE_NAME", typeParenting.name)
                    putExtra("TYPE_DESC", typeParenting.deskripsi)
                }
                startActivity(intent)
                finish()
            }
        }
    }
}
