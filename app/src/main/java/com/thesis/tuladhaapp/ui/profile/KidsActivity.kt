package com.thesis.tuladhaapp.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.shashank.sony.fancytoastlib.FancyToast
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityKidsBinding
import com.thesis.tuladhaapp.model.firebase.ChildData
import com.thesis.tuladhaapp.ui.auth.login.LoginActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class KidsActivity : AppCompatActivity() {
    private val binding: ActivityKidsBinding by lazy {
        ActivityKidsBinding.inflate(layoutInflater)
    }
    var count = 0
    private val profileViewModel: ProfileViewModel by viewModel()
    private var currentChildId: String? = null
    private var isClearingCheck = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setClickListener()
        setupRadioGroupListeners()

        profileViewModel.childrenList.observe(this) { children ->
            if (children.isNotEmpty()) {
                val childToDisplay: ChildData?
                val childIdFromIntent = intent.getStringExtra("child_id")
                if (childIdFromIntent != null) {
                    // Jika ada ID dari Intent, cari anak yang sesuai di daftar
                    childToDisplay = children.find { it.id == childIdFromIntent }

                    if (childToDisplay == null) {
                        FancyToast.makeText(this, "Data anak tidak ditemukan!", Toast.LENGTH_SHORT).show()
                        clearInputFields() // Bersihkan form jika ID tidak ditemukan
                        currentChildId = null
                    }else{
                        displayChildData(childToDisplay)
                        currentChildId = childToDisplay.id
                    }
                }

            } else {
                // Jika tidak ada data anak sama sekali, bersihkan form dan reset ID
                clearInputFields()
                currentChildId = null
                FancyToast.makeText(this, "Tidak ada data anak ditemukan.", Toast.LENGTH_SHORT).show()
            }
        }
        profileViewModel.readAllChildrenData()
    }

    private fun displayChildData(child: ChildData) {
        // Mengisi EditText untuk nama anak
        binding.etChildName.setText(child.name)

        child.gender?.let { genderText ->
            setRadioButtonSelection(binding.rgChildGender, genderText)
        }


        child.ageRange?.let { ageRangeText ->
            // Coba set di kolom 1
            if (setRadioButtonSelection(binding.rgChildAgeCol1, ageRangeText)) {
                binding.rgChildAgeCol2.clearCheck()
            }else{
                setRadioButtonSelection(binding.rgChildAgeCol2, ageRangeText)
                binding.rgChildAgeCol1.clearCheck()
            }
        }
    }

    private fun setRadioButtonSelection(radioGroup: RadioGroup, textToSelect: String): Boolean {
        for (i in 0 until radioGroup.childCount) {
            val radioButton = radioGroup.getChildAt(i) as? RadioButton
            if (radioButton != null && radioButton.text.toString() == textToSelect) {
                radioGroup.check(radioButton.id) // Pilih RadioButton dengan ID yang cocok
                return true
            }
        }
        return false // RadioButton dengan teks yang cocok tidak ditemukan
    }
    private fun setupRadioGroupListeners() {
        binding.rgChildAgeCol1.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId != -1 && !isClearingCheck) { // Jika ada pilihan baru dan bukan dari clear
                isClearingCheck = true // Set flag
                binding.rgChildAgeCol2.clearCheck() // Hapus pilihan di RadioGroup lain
                isClearingCheck = false // Reset flag
            }
        }

        binding.rgChildAgeCol2.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId != -1 && !isClearingCheck) { // Jika ada pilihan baru dan bukan dari clear
                isClearingCheck = true // Set flag
                binding.rgChildAgeCol1.clearCheck() // Hapus pilihan di RadioGroup lain
                isClearingCheck = false // Reset flag
            }
        }
    }


    private fun setClickListener() {
        binding.btnEditProfile.setOnClickListener {
            if (profileViewModel.isUserLoggedIn()) {
                count += 1
                if (count % 2 == 0) {

                    uploadToDatabase()
                } else {
                    binding.btnEditProfile.setText(getString(R.string.text_save))
                }
            } else {
                navigateToLogin()
            }
        }

        binding.btnEditProfile.setOnClickListener {
            if (profileViewModel.isUserLoggedIn()) {
                binding.tvChildNameLabel.text = "Nama Anak Pertama"
                val nameInput = binding.etChildName.text.toString().trim()
                if (nameInput.isNotEmpty()) {
                    binding.btnEditProfile.setText(getString(R.string.ubah_data))
                    uploadToDatabase()
                } else {
                    binding.btnEditProfile.setText(getString(R.string.simpan))
                    updateFirstChildDataIfAvailable()
                }

            } else {
                navigateToLogin()
            }
        }


        binding.toolbar.setOnClickListener {
            finish()
        }

        binding.btnSeeAll.setOnClickListener {
            startActivity(Intent(this, ActivityChildList::class.java))
        }

    }

    private fun uploadToDatabase() {
        val name = binding.etChildName.text.toString().trim()
        val gender = getSelectedRadioButtonText(binding.rgChildGender)

        val ageRange =
            getSelectedRadioButtonText(binding.rgChildAgeCol1, binding.rgChildAgeCol2)

        // Validasi input di Activity sebelum mengirim ke ViewModel
        if (name.isEmpty()) {
            binding.etChildName.error = "Nama anak tidak boleh kosong."
            FancyToast.makeText(this, "Nama anak tidak boleh kosong.", Toast.LENGTH_SHORT).show()
            return
        }
        if (gender == null) {
            FancyToast.makeText(this, "Mohon pilih jenis kelamin anak.", Toast.LENGTH_SHORT).show()
            return
        }
        if (ageRange == null) {
            FancyToast.makeText(this, "Mohon pilih rentang usia anak.", Toast.LENGTH_SHORT).show()
            return
        }


        val child = ChildData(
            id = currentChildId ,
            name = name,
            ageRange = ageRange,
            gender = gender
        )


        if (currentChildId != null) {
            FancyToast.makeText(this, "Data anak berhasil diupdate.", Toast.LENGTH_SHORT).show()
            profileViewModel.updateChildData(child)
            startActivity(Intent(this, ActivityChildList::class.java))
            finish()
        } else {
            FancyToast.makeText(this, "Data anak berhasil ditambahkan.", Toast.LENGTH_SHORT).show()
            profileViewModel.addChildData(child)
            startActivity(Intent(this, ActivityChildList::class.java))
            finish()
        }

        clearInputFields()
    }

    private fun updateFirstChildDataIfAvailable() {
        // Mendapatkan data anak pertama dari LiveData ViewModel
        val children = profileViewModel.childrenList.value
        if (children != null && children.isNotEmpty()) {
            val childToUpdate = children[0]
            val updatedChild = ChildData(
                id = childToUpdate.id,
                name = childToUpdate.name,
                ageRange = childToUpdate.ageRange,
                gender = childToUpdate.gender
            )


            profileViewModel.updateChildData(updatedChild)
            startActivity(Intent(this, ActivityChildList::class.java))
            finish()
        } else {
            FancyToast.makeText(this, "Tidak ada data anak untuk diupdate.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getSelectedRadioButtonText(vararg radioGroups: RadioGroup): String? {
        for (radioGroup in radioGroups) {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId != -1) {
                // Here, findViewById is correctly called on the Activity's context.
                // It will look for the RadioButton with the given ID within this Activity's layout.
                val selectedRadioButton: RadioButton? = findViewById(selectedId)
                return selectedRadioButton?.text?.toString()
            }
        }
        return null // No selection found in any of the provided RadioGroups
    }

    private fun clearInputFields() {
        binding.etChildName.text?.clear()
        binding.rgChildGender.clearCheck()
        binding.rgChildAgeCol1.clearCheck()
        binding.rgChildAgeCol2.clearCheck()
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}