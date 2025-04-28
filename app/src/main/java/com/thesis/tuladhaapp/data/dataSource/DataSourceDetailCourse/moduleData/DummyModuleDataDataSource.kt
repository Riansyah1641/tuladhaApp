package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.moduleData

import com.thesis.tuladhaapp.model.detailcourse.ModuleDataData
import com.thesis.tuladhaapp.model.detailcourse.UserModuleData

object DummyModuleDataDataSource : ModuleDataSource {

    private val userModules = mapOf(
        0 to listOf(
            UserModuleData(0, "terbuka", ModuleDataData(0, 1, "Pengenalan Pengasuhan Anak"))
        ),
        1 to listOf(
            UserModuleData(1, "terbuka", ModuleDataData(1, 2, "Membangun Ikatan dengan Anak")),
            UserModuleData(2, "terbuka", ModuleDataData(2, 3, "Teknik Pengasuhan yang Efektif"))
        ),
        2 to listOf(
            UserModuleData(3, "terbuka", ModuleDataData(3, 1, "Memahami Psikologi Anak")),
            UserModuleData(4, "terbuka", ModuleDataData(4, 2, "Menghadapi Tantrum Anak")),
            UserModuleData(5, "terbuka", ModuleDataData(5, 3, "Keterampilan Sosial untuk Balita"))
        ),
        3 to listOf(
            UserModuleData(6, "terbuka", ModuleDataData(6, 1, "Peran Orang Tua dalam Pendidikan Anak")),
            UserModuleData(7, "terbuka", ModuleDataData(7, 2, "Mendidik dengan Pendekatan Positif"))
        ),
        4 to listOf(
            UserModuleData(8, "terbuka", ModuleDataData(8, 1, "Keamanan Digital untuk Anak"))
        ),
        5 to listOf(
            UserModuleData(9, "terbuka", ModuleDataData(9, 1, "Dukungan untuk Ibu Baru")),
            UserModuleData(10, "terbuka", ModuleDataData(10, 2, "Menghadapi Stres Pasca Melahirkan"))
        ),
        6 to listOf(
            UserModuleData(11, "terbuka", ModuleDataData(11, 1, "Mengelola Stres pada Anak")),
            UserModuleData(12, "terbuka", ModuleDataData(12, 2, "Menumbuhkan Rasa Percaya Diri pada Anak")),
            UserModuleData(13, "terbuka", ModuleDataData(13, 3, "Komunikasi Efektif dalam Pengasuhan"))
        ),
        7 to listOf(
            UserModuleData(14, "terbuka", ModuleDataData(14, 1, "Menghargai Perasaan Anak"))
        ),
        8 to listOf(
            UserModuleData(15, "terbuka", ModuleDataData(15, 1, "Mengatasi Tantangan Media Sosial")),
            UserModuleData(16, "terbuka", ModuleDataData(16, 2, "Mengelola Penggunaan Teknologi"))
        ),
        9 to listOf(
            UserModuleData(17, "terbuka", ModuleDataData(17, 1, "Pendidikan Karakter pada Anak")),
            UserModuleData(18, "terbuka", ModuleDataData(18, 2, "Membangun Hubungan yang Sehat dalam Keluarga"))
        ),
        10 to listOf(
            UserModuleData(19, "terbuka", ModuleDataData(19, 1, "Mengatasi Masalah Emosi Anak"))
        ),
        11 to listOf(
            UserModuleData(20, "terbuka", ModuleDataData(20, 1, "Membangun Disiplin pada Anak")),
            UserModuleData(21, "terbuka", ModuleDataData(21, 2, "Pentingnya Komunikasi dalam Keluarga"))
        ),
        12 to listOf(
            UserModuleData(22, "terbuka", ModuleDataData(22, 1, "Perkembangan Kognitif Anak"))
        ),
        13 to listOf(
            UserModuleData(23, "terbuka", ModuleDataData(23, 1, "Mengajarkan Anak tentang Tanggung Jawab")),
            UserModuleData(24, "terbuka", ModuleDataData(24, 2, "Membangun Karakter Anak Sejak Dini"))
        ),
        14 to listOf(
            UserModuleData(25, "terbuka", ModuleDataData(25, 1, "Pengasuhan pada Usia 0-3 Tahun"))
        ),
        15 to listOf(
            UserModuleData(26, "terbuka", ModuleDataData(26, 1, "Keterampilan Sosial pada Anak Usia Dini")),
            UserModuleData(27, "terbuka", ModuleDataData(27, 2, "Mengajarkan Anak Tentang Empati"))
        ),
        16 to listOf(
            UserModuleData(28, "terbuka", ModuleDataData(28, 1, "Mengatur Waktu Anak dan Kegiatan"))
        ),
        17 to listOf(
            UserModuleData(29, "terbuka", ModuleDataData(29, 1, "Meningkatkan Keterampilan Motorik Anak")),
            UserModuleData(30, "terbuka", ModuleDataData(30, 2, "Keseimbangan Antara Main dan Belajar"))
        ),
        18 to listOf(
            UserModuleData(31, "terbuka", ModuleDataData(31, 1, "Strategi Pengasuhan pada Anak Remaja"))
        ),
        19 to listOf(
            UserModuleData(32, "terbuka", ModuleDataData(32, 1, "Menghadapi Perubahan pada Remaja")),
            UserModuleData(33, "terbuka", ModuleDataData(33, 2, "Mengajarkan Remaja Tentang Tanggung Jawab"))
        ),
        20 to listOf(
            UserModuleData(34, "terbuka", ModuleDataData(34, 1, "Mendukung Prestasi Anak di Sekolah"))
        ),
        21 to listOf(
            UserModuleData(35, "terbuka", ModuleDataData(35, 1, "Mengajarkan Remaja Tentang Tujuan Hidup")),
            UserModuleData(36, "terbuka", ModuleDataData(36, 2, "Pentingnya Kedekatan dengan Orang Tua"))
        ),
        22 to listOf(
            UserModuleData(37, "terbuka", ModuleDataData(37, 1, "Menghadapi Tantangan Anak dengan Autisme"))
        ),
        23 to listOf(
            UserModuleData(38, "terbuka", ModuleDataData(38, 1, "Menumbuhkan Kreativitas pada Anak")),
            UserModuleData(39, "terbuka", ModuleDataData(39, 2, "Mengenalkan Anak pada Budaya dan Seni"))
        ),
        24 to listOf(
            UserModuleData(40, "terbuka", ModuleDataData(40, 1, "Keterampilan Menyelesaikan Konflik pada Anak"))
        ),
        25 to listOf(
            UserModuleData(41, "terbuka", ModuleDataData(41, 1, "Pentingnya Peran Ayah dalam Pengasuhan Anak"))
        ),
        26 to listOf(
            UserModuleData(42, "terbuka", ModuleDataData(42, 1, "Mengajarkan Anak tentang Persahabatan")),
            UserModuleData(43, "terbuka", ModuleDataData(43, 2, "Mengelola Perbedaan Antara Anak"))
        ),
        27 to listOf(
            UserModuleData(44, "terbuka", ModuleDataData(44, 1, "Strategi Menghadapi Anak yang Malas Sekolah"))
        ),
        28 to listOf(
            UserModuleData(45, "terbuka", ModuleDataData(45, 1, "Mengajarkan Anak Tentang Kejujuran")),
            UserModuleData(46, "terbuka", ModuleDataData(46, 2, "Pentingnya Pendidikan Agama pada Anak"))
        ),
        29 to listOf(
            UserModuleData(47, "terbuka", ModuleDataData(47, 1, "Menumbuhkan Rasa Cinta Tanah Air pada Anak"))
        ),
        30 to listOf(
            UserModuleData(48, "terbuka", ModuleDataData(48, 1, "Mengajarkan Anak Tentang Pengelolaan Uang")),
            UserModuleData(49, "terbuka", ModuleDataData(49, 2, "Mengajarkan Anak Tentang Kepedulian Sosial"))
        ),
        31 to listOf(
            UserModuleData(50, "terbuka", ModuleDataData(50, 1, "Menghadapi Anak yang Sering Marah"))
        ),
        32 to listOf(
            UserModuleData(51, "terbuka", ModuleDataData(51, 1, "Menumbuhkan Rasa Percaya Diri Anak"))
        ),
        33 to listOf(
            UserModuleData(52, "terbuka", ModuleDataData(52, 1, "Mengatur Penggunaan Gadget pada Anak")),
            UserModuleData(53, "terbuka", ModuleDataData(53, 2, "Menumbuhkan Rasa Tanggung Jawab pada Anak"))
        ),
        34 to listOf(
            UserModuleData(54, "terbuka", ModuleDataData(54, 1, "Menumbuhkan Kemandirian pada Anak"))
        ),
        35 to listOf(
            UserModuleData(55, "terbuka", ModuleDataData(55, 1, "Menumbuhkan Kepemimpinan pada Anak"))
        ),
        36 to listOf(
            UserModuleData(56, "terbuka", ModuleDataData(56, 1, "Mengatasi Masalah dalam Pendidikan Anak"))
        ),
        37 to listOf(
            UserModuleData(57, "terbuka", ModuleDataData(57, 1, "Pentingnya Dukungan Emosional pada Anak"))
        ),
        38 to listOf(
            UserModuleData(58, "terbuka", ModuleDataData(58, 1, "Menumbuhkan Empati pada Anak"))
        ),
        39 to listOf(
            UserModuleData(59, "terbuka", ModuleDataData(59, 1, "Membangun Mentalitas Kuat pada Anak"))
        ),
        40 to listOf(
            UserModuleData(60, "terbuka", ModuleDataData(60, 1, "Mendukung Perkembangan Emosional Anak"))
        ),
        41 to listOf(
            UserModuleData(61, "terbuka", ModuleDataData(61, 1, "Mengajarkan Tanggung Jawab pada Anak")),
            UserModuleData(62, "terbuka", ModuleDataData(62, 2, "Mengelola Konflik di Keluarga"))
        ),
        42 to listOf(
            UserModuleData(63, "terbuka", ModuleDataData(63, 1, "Meningkatkan Keterampilan Komunikasi pada Anak")),
            UserModuleData(64, "terbuka", ModuleDataData(64, 2, "Pentingnya Pendidikan Seks untuk Anak"))
        ),
        43 to listOf(
            UserModuleData(65, "terbuka", ModuleDataData(65, 1, "Membangun Kepercayaan Diri pada Remaja"))
        ),
        44 to listOf(
            UserModuleData(66, "terbuka", ModuleDataData(66, 1, "Menjaga Kesehatan Mental Anak")),
            UserModuleData(67, "terbuka", ModuleDataData(67, 2, "Peran Orang Tua dalam Pendidikan Karakter"))
        ),
        45 to listOf(
            UserModuleData(68, "terbuka", ModuleDataData(68, 1, "Menumbuhkan Rasa Tanggung Jawab pada Remaja"))
        ),
        46 to listOf(
            UserModuleData(69, "terbuka", ModuleDataData(69, 1, "Mendukung Perkembangan Kognitif Anak")),
            UserModuleData(70, "terbuka", ModuleDataData(70, 2, "Mengajarkan Anak untuk Memecahkan Masalah"))
        ),
        47 to listOf(
            UserModuleData(71, "terbuka", ModuleDataData(71, 1, "Mengelola Perilaku Anak dengan Disiplin Positif"))
        ),
        48 to listOf(
            UserModuleData(72, "terbuka", ModuleDataData(72, 1, "Mengajarkan Anak untuk Menghargai Waktu"))
        ),
        49 to listOf(
            UserModuleData(73, "terbuka", ModuleDataData(73, 1, "Mengatasi Tantangan Sosial di Sekolah"))
        ),
        50 to listOf(
            UserModuleData(74, "terbuka", ModuleDataData(74, 1, "Menjaga Keseimbangan Antara Belajar dan Bermain"))
        ),
        51 to listOf(
            UserModuleData(75, "terbuka", ModuleDataData(75, 1, "Membangun Kepemimpinan pada Anak"))
        ),
        52 to listOf(
            UserModuleData(76, "terbuka", ModuleDataData(76, 1, "Pentingnya Penghargaan dalam Pengasuhan"))
        ),
        53 to listOf(
            UserModuleData(77, "terbuka", ModuleDataData(77, 1, "Mengajarkan Kepedulian Sosial pada Anak"))
        ),
        54 to listOf(
            UserModuleData(78, "terbuka", ModuleDataData(78, 1, "Meningkatkan Keterampilan Sosial Anak"))
        ),
        55 to listOf(
            UserModuleData(79, "terbuka", ModuleDataData(79, 1, "Pendidikan Emosional untuk Anak"))
        ),
        56 to listOf(
            UserModuleData(80, "terbuka", ModuleDataData(80, 1, "Menumbuhkan Kepedulian terhadap Lingkungan pada Anak"))
        ),
        57 to listOf(
            UserModuleData(81, "terbuka", ModuleDataData(81, 1, "Pentingnya Interaksi Positif dalam Keluarga"))
        ),
        58 to listOf(
            UserModuleData(82, "terbuka", ModuleDataData(82, 1, "Meningkatkan Kemampuan Berpikir Kritis pada Anak"))
        ),
        59 to listOf(
            UserModuleData(83, "terbuka", ModuleDataData(83, 1, "Mengajarkan Anak untuk Berpikir Positif"))
        )
    )

    override fun getModulesForChapter(chapterId: Int): List<UserModuleData> {
        return userModules[chapterId] ?: emptyList()
    }
}
