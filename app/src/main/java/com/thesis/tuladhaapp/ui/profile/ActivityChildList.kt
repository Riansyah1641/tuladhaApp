// com/thesis/tuladhaapp/ui/profile/ChildListActivity.kt
package com.thesis.tuladhaapp.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesis.tuladhaapp.databinding.ActivityChildListBinding
import com.thesis.tuladhaapp.ui.auth.login.LoginActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ActivityChildList : AppCompatActivity() {

    private val binding: ActivityChildListBinding by lazy {
        ActivityChildListBinding.inflate(layoutInflater)
    }

    private val profileViewModel: ProfileViewModel by viewModel()
    private lateinit var childAdapter: ChildAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.btnAddData.setOnClickListener {
            startActivity(Intent(this, KidsActivity::class.java))
            finish()
        }

        // Setup Toolbar
        setSupportActionBar(binding.toolbarChildList)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Menampilkan tombol kembali
        binding.toolbarChildList.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Aksi saat tombol kembali diklik
        }

        childAdapter = ChildAdapter(
            onEditClick = { child ->
                Toast.makeText(this, "Edit: ${child.name}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, KidsActivity::class.java).apply {
                    putExtra("child_id", child.id)
                }
                startActivity(intent)
                finish()
            },
            onDeleteClick = { child ->
                // TODO: Aksi saat tombol Delete diklik
                // Konfirmasi pengguna sebelum menghapus
                if (child.id != null) {
                    profileViewModel.deleteChildData(child.id!!)
                } else {
                    Toast.makeText(this, "ID Anak tidak ditemukan untuk dihapus.", Toast.LENGTH_SHORT).show()
                }
            }
        )

        binding.recyclerViewChildren.apply {
            layoutManager = LinearLayoutManager(this@ActivityChildList)
            adapter = childAdapter
        }

        // Amati LiveData dari ViewModel
        profileViewModel.childrenList.observe(this) { children ->
            // Ketika daftar anak diperbarui di ViewModel, kirimkan ke Adapter
            childAdapter.submitList(children)
            if (children.isEmpty()) {
                binding.emptyData.root.visibility = View.VISIBLE
                Toast.makeText(this, "Belum ada data anak.", Toast.LENGTH_SHORT).show()
            }else{
                binding.emptyData.root.visibility = View.GONE
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (profileViewModel.isUserLoggedIn()) {
            profileViewModel.readAllChildrenData()
        } else {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}