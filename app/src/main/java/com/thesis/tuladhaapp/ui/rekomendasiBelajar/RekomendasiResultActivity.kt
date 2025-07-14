package com.thesis.tuladhaapp.ui.rekomendasiBelajar

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityRekomendasiResultBinding
import com.thesis.tuladhaapp.databinding.ActivityResultTestBinding
import com.thesis.tuladhaapp.databinding.FragmentCourseBinding
import com.thesis.tuladhaapp.ui.main.MainActivity

class RekomendasiResultActivity : AppCompatActivity() {

    private val binding: ActivityRekomendasiResultBinding by lazy {
        ActivityRekomendasiResultBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setOnClickListener()

        val typeName = intent.getStringExtra("TYPE_NAME")
        val typeDesc = intent.getStringExtra("TYPE_DESC")

        binding.tvPersonalTypePolaAsuh.text = typeName
        binding.tvDeskripsiPolaAsuh.text = typeDesc
    }

    private fun setOnClickListener(){
        binding.toHomeAgine.setOnClickListener{
            goToHome()
        }
    }
    private fun goToHome(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}