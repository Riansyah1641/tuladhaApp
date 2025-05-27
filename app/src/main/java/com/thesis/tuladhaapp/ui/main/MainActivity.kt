package com.thesis.tuladhaapp.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.shashank.sony.fancytoastlib.FancyToast
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment_activity_main)
    }

    // Variabel untuk mengelola konektivitas jaringan, diubah menjadi nullable
    private var connectivityManager: ConnectivityManager? = null

    // Callback untuk mendengarkan perubahan status jaringan, diubah menjadi nullable
    private var networkCallback: ConnectivityManager.NetworkCallback? = null
    // Dialog yang akan ditampilkan saat tidak ada internet
    private var noInternetDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)
        installSplashScreen()
        setupBottomNav()
        // Mendapatkan instance ConnectivityManager
        connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        // Menyiapkan callback untuk memantau status jaringan
        setupNetworkCallback()
    }

    private fun setupBottomNav() {
        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.bottom_nav_menu)
        val menu = popupMenu.menu
        binding.bottomBar.setupWithNavController(menu, navController)
    }


    // Fungsi untuk menyiapkan NetworkCallback guna memantau status jaringan
    private fun setupNetworkCallback() {
        // Hanya inisialisasi networkCallback jika connectivityManager tidak null
        connectivityManager?.let { cm ->
            networkCallback = object : ConnectivityManager.NetworkCallback() {
                // Dipanggil ketika koneksi jaringan tersedia
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    // Pastikan pembaruan UI dilakukan di UI thread
                    runOnUiThread {
                        // Jika dialog "Tidak Ada Internet" sedang ditampilkan, sembunyikan
                        noInternetDialog?.dismiss()
                        noInternetDialog = null // Reset referensi dialog
                        // Tampilkan FancyToast sukses
                    }
                }

                // Dipanggil ketika koneksi jaringan terputus
                override fun onLost(network: Network) {
                    super.onLost(network)
                    // Pastikan pembaruan UI dilakukan di UI thread
                    runOnUiThread {
                        // Tampilkan dialog "Tidak Ada Internet"
                        showNoInternetDialog()
                        // Tampilkan FancyToast error
                        FancyToast.makeText(
                            this@MainActivity,
                            "Koneksi internet terputus!",
                            FancyToast.LENGTH_LONG,
                            FancyToast.ERROR,
                            false // false jika tidak ingin ada ikon
                        ).show()
                    }
                }

                // Dipanggil ketika kemampuan jaringan berubah (opsional, bisa digunakan untuk deteksi jenis koneksi)
                override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
                    super.onCapabilitiesChanged(network, networkCapabilities)
                    // Anda bisa menambahkan logika di sini jika perlu bereaksi terhadap perubahan jenis koneksi (misal: dari Wi-Fi ke data seluler)
                }
            }

            // Membangun NetworkRequest untuk mendeteksi jaringan yang memiliki kapabilitas internet
            val networkRequest = NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build()

            // Mendaftarkan NetworkCallback untuk mulai memantau jaringan
            networkCallback?.let { callback ->
                cm.registerNetworkCallback(networkRequest, callback)
            }
        }


        // Lakukan pengecekan koneksi awal saat Activity dibuat
        if (!isNetworkConnected()) {
            showNoInternetDialog()
            FancyToast.makeText(
                this@MainActivity,
                "Tidak ada koneksi internet!",
                FancyToast.LENGTH_LONG,
                FancyToast.ERROR,
                false
            ).show()
        }
    }

    // Fungsi untuk memeriksa apakah ada koneksi internet aktif
    private fun isNetworkConnected(): Boolean {
        // Menggunakan safe call operator (?) untuk menghindari NullPointerException
        val activeNetwork = connectivityManager?.activeNetwork ?: return false // Mendapatkan jaringan aktif
        val capabilities = connectivityManager?.getNetworkCapabilities(activeNetwork) ?: return false // Mendapatkan kapabilitas jaringan
        // Memeriksa apakah jaringan memiliki kapabilitas internet
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    // Fungsi untuk menampilkan dialog "Tidak Ada Koneksi Internet"
    @SuppressLint("MissingInflatedId")
    private fun showNoInternetDialog() {
        // Hanya tampilkan dialog jika belum ada atau tidak sedang ditampilkan
        if (noInternetDialog == null || !noInternetDialog!!.isShowing) {
            // Menggunakan LayoutInflater untuk meng-inflate layout kustom untuk dialog
            val dialogView = LayoutInflater.from(this).inflate(R.layout.layout_dialog_network, null)
            val lottieAnimationView = dialogView.findViewById<LottieAnimationView>(R.id.iv_img_network_bad)

            // Mengatur animasi Lottie dari raw resource
            // Pastikan Anda memiliki file Lottie JSON di res/raw/no_internet_animation.json
            lottieAnimationView.setAnimation(R.raw.bad_network)
            lottieAnimationView.loop(true) // Mengatur animasi untuk loop
            lottieAnimationView.playAnimation() // Memulai animasi

            noInternetDialog = AlertDialog.Builder(this)
                .setView(dialogView) // Mengatur tampilan dialog menggunakan layout kustom
                .setCancelable(false) // Sangat penting: dialog tidak dapat ditutup oleh pengguna
                .create() // Membuat dialog
            noInternetDialog?.show() // Menampilkan dialog
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Penting: Batalkan pendaftaran network callback untuk mencegah memory leak
        // Menggunakan safe call operator (?) untuk menghindari NullPointerException
        networkCallback?.let { connectivityManager?.unregisterNetworkCallback(it) }
        // Pastikan dialog ditutup saat Activity dihancurkan
        noInternetDialog?.dismiss()
    }
}