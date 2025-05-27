package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.moduleData

import com.thesis.tuladhaapp.model.detailcourse.ModuleDataData
import com.thesis.tuladhaapp.model.detailcourse.UserModuleData

object DummyModuleDataDataSource : ModuleDataSource {
    private val userModules = mapOf(
        0 to listOf(
            UserModuleData(0, "terbuka", ModuleDataData(0, 1, "Pengantar: Mendukung Perkembangan Motorik Bayi"))
        ),
        1 to listOf(
            UserModuleData(1, "terbuka", ModuleDataData(1, 1, "Mengenal Perkembangan Motorik Kasar Awal (0-3 Bulan)")),
            UserModuleData(2, "terbuka", ModuleDataData(2, 2, "Stimulasi untuk Menegakkan Kepala dan Tengkurap"))
        ),
        2 to listOf(
            UserModuleData(3, "terbuka", ModuleDataData(3, 1, "Pentingnya Pola Asuh Responsif dalam Motorik")),
            UserModuleData(4, "terbuka", ModuleDataData(4, 2, "Interaksi Hangat dan Stimulasi Sesuai Usia")),
            UserModuleData(5, "terbuka", ModuleDataData(5, 3, "Bukan Menuntut, Tapi Mendampingi"))
        ),
        3 to listOf(
            UserModuleData(6, "terbuka", ModuleDataData(6, 1, "Pengantar: Membangun Kemandirian Gerak Anak")),
            UserModuleData(7, "terbuka", ModuleDataData(7, 2, "Melatih Duduk dan Berdiri: Lebih dari Sekadar Fisik"))
        ),
        4 to listOf(
            UserModuleData(8, "terbuka", ModuleDataData(8, 1, "Strategi Mendorong Kemandirian dengan Dukungan"))
        ),
        5 to listOf(
            UserModuleData(9, "terbuka", ModuleDataData(9, 1, "Pola Asuh Authoritative vs. Authoritarian vs. Permissive")),
            UserModuleData(10, "terbuka", ModuleDataData(10, 2, "Penguatan Emosional dalam Melatih Gerak"))
        ),
        6 to listOf(
            UserModuleData(11, "terbuka", ModuleDataData(11, 1, "Kemandirian Gerak sebagai Bagian dari Pengasuhan Positif")),
            UserModuleData(12, "terbuka", ModuleDataData(12, 2, "Pengantar: Menyambut Anak Belajar Berjalan")),
            UserModuleData(13, "terbuka", ModuleDataData(13, 3, "Mengenali Kesiapan Anak untuk Berjalan"))
        ),
        7 to listOf(
            UserModuleData(14, "terbuka", ModuleDataData(14, 1, "Memberikan Dukungan dengan Sabar dan Positif"))
        ),
        8 to listOf(
            UserModuleData(15, "terbuka", ModuleDataData(15, 1, "Membandingkan Pendekatan Pengasuhan dalam Melatih Berjalan")),
            UserModuleData(16, "terbuka", ModuleDataData(16, 2, "Risiko Jika Anak Dibiarkan Tanpa Stimulasi"))
        ),
        9 to listOf(
            UserModuleData(17, "terbuka", ModuleDataData(17, 1, "Langkah-Langkah Bijak Mendampingi Anak Berjalan")),
            UserModuleData(18, "terbuka", ModuleDataData(18, 2, "Pengantar: Mendorong Eksplorasi Bayi dengan Aman"))
        ),
        10 to listOf(
            UserModuleData(19, "terbuka", ModuleDataData(19, 1, "Stimulasi Eksplorasi untuk Belajar Gerak"))
        ),
        11 to listOf(
            UserModuleData(20, "terbuka", ModuleDataData(20, 1, "Pentingnya Pengawasan dalam Eksplorasi")),
            UserModuleData(21, "terbuka", ModuleDataData(21, 2, "Menerapkan Pengasuhan Suportif dan Responsif (Authoritative)"))
        ),
        12 to listOf(
            UserModuleData(22, "terbuka", ModuleDataData(22, 1, "Batasan yang Aman vs. Terlalu Membatasi (Authoritarian)"))
        ),
        13 to listOf(
            UserModuleData(23, "terbuka", ModuleDataData(23, 1, "Melepas Tanpa Arahan (Permissive) dalam Eksplorasi")),
            UserModuleData(24, "terbuka", ModuleDataData(24, 2, "Pengantar: Komunikasi Awal Anak"))
        ),
        14 to listOf(
            UserModuleData(25, "terbuka", ModuleDataData(25, 1, "Mengenalkan Nama Benda dan Merespon Ucapan"))
        ),
        15 to listOf(
            UserModuleData(26, "terbuka", ModuleDataData(26, 1, "Awal Perkembangan Bahasa Bayi (9-12 Bulan)")),
            UserModuleData(27, "terbuka", ModuleDataData(27, 2, "Dampak Komunikasi Efektif Berdasarkan Pola Asuh"))
        ),
        16 to listOf(
            UserModuleData(28, "terbuka", ModuleDataData(28, 1, "Responsif, Kaku, atau Permisif dalam Berkomunikasi"))
        ),
        17 to listOf(
            UserModuleData(29, "terbuka", ModuleDataData(29, 1, "Strategi Komunikasi Awal yang Positif")),
            UserModuleData(30, "terbuka", ModuleDataData(30, 2, "Pengantar: Melatih Motorik Kasar Lewat Bermain"))
        ),
        18 to listOf(
            UserModuleData(31, "terbuka", ModuleDataData(31, 1, "Aktivitas Fisik dan Dukungan Orang Tua"))
        ),
        19 to listOf(
            UserModuleData(32, "terbuka", ModuleDataData(32, 1, "Pola Asuh Authoritative: Membimbing dengan Percaya Diri")),
            UserModuleData(33, "terbuka", ModuleDataData(33, 2, "Otoriter Penuh Larangan vs. Permisif Minim Arahan"))
        ),
        20 to listOf(
            UserModuleData(34, "terbuka", ModuleDataData(34, 1, "Contoh Permainan Terarah untuk Motorik Kasar"))
        ),
        21 to listOf(
            UserModuleData(35, "terbuka", ModuleDataData(35, 1, "Membangun Kepercayaan Diri Lewat Gerak")),
            UserModuleData(36, "terbuka", ModuleDataData(36, 2, "Pengantar: Mengembangkan Bahasa Anak"))
        ),
        22 to listOf(
            UserModuleData(37, "terbuka", ModuleDataData(37, 1, "Penggunaan Bahasa yang Kaya di Rumah"))
        ),
        23 to listOf(
            UserModuleData(38, "terbuka", ModuleDataData(38, 1, "Melibatkan Anak Secara Verbal dengan Struktur (Authoritative)")),
            UserModuleData(39, "terbuka", ModuleDataData(39, 2, "Tidak Memaksa (Authoritarian) vs. Minim Stimulasi (Permissive)"))
        ),
        24 to listOf(
            UserModuleData(40, "terbuka", ModuleDataData(40, 1, "Deskripsi dan Percakapan Sehari-hari"))
        ),
        25 to listOf(
            UserModuleData(41, "terbuka", ModuleDataData(41, 1, "Pentingnya Interaksi Verbal yang Interaktif"))
        ),
        26 to listOf(
            UserModuleData(42, "terbuka", ModuleDataData(42, 1, "Pengantar: Imajinasi dan Regulasi Emosi Lewat Bermain Peran"))
        ),
        27 to listOf(
            UserModuleData(43, "terbuka", ModuleDataData(43, 1, "Permainan Menirukan dan Kreativitas"))
        ),28 to listOf(
            UserModuleData(44, "terbuka", ModuleDataData(44, 1, "Stimulasi Motorik dan Ekspresi Emosional"))
        ),
        29 to listOf(
            UserModuleData(45, "terbuka", ModuleDataData(45, 1, "Keseimbangan Kebebasan (Permissive) dan Batasan (Authoritative)"))
        ),
        30 to listOf(
            UserModuleData(46, "terbuka", ModuleDataData(46, 1, "Menghindari Penekanan Berlebihan (Authoritarian)"))
        ),
        31 to listOf(
            UserModuleData(47, "terbuka", ModuleDataData(47, 1, "Membangun Regulasi Emosi Melalui Bermain"))
        ),
        32 to listOf(
            UserModuleData(48, "terbuka", ModuleDataData(48, 1, "Pengantar: Konsep Matematika Dasar"))
        ),
        33 to listOf(
            UserModuleData(49, "terbuka", ModuleDataData(49, 1, "Mengajarkan Angka, Mencocokkan, dan Menghitung"))
        ),
        34 to listOf(
            UserModuleData(50, "terbuka", ModuleDataData(50, 1, "Pendekatan Sesuai Pola Asuh dalam Belajar Matematika"))
        ),
        35 to listOf(
            UserModuleData(51, "terbuka", ModuleDataData(51, 1, "Struktur dan Stimulasi (Authoritative)"))
        ),
        36 to listOf(
            UserModuleData(52, "terbuka", ModuleDataData(52, 1, "Tekanan Berlebihan (Authoritarian) vs. Terlalu Bebas (Permissive)"))
        ),
        37 to listOf(
            UserModuleData(53, "terbuka", ModuleDataData(53, 1, "Belajar Matematika dengan Menyenangkan"))
        ),
        38 to listOf(
            UserModuleData(54, "terbuka", ModuleDataData(54, 1, "Pengantar: Konsep Ukuran dan Perbandingan"))
        ),
        39 to listOf(
            UserModuleData(55, "terbuka", ModuleDataData(55, 1, "Belajar Besar-Kecil dan Berat-Ringan"))
        ),
        40 to listOf(
            UserModuleData(56, "terbuka", ModuleDataData(56, 1, "Mendorong Rasa Ingin Tahu Secara Aktif Namun Terarah (Authoritative)"))
        ),
        41 to listOf(
            UserModuleData(57, "terbuka", ModuleDataData(57, 1, "Bukan Menekan Hasil (Authoritarian)"))
        ),
        42 to listOf(
            UserModuleData(58, "terbuka", ModuleDataData(58, 1, "Tidak Membiarkan Tanpa Bimbingan (Permissive)"))
        ),
        43 to listOf(
            UserModuleData(59, "terbuka", ModuleDataData(59, 1, "Eksperimen Sederhana untuk Memahami Ukuran"))
        ),
        44 to listOf(
            UserModuleData(60, "terbuka", ModuleDataData(60, 1, "Pendahuluan: Pengertian Pengasuhan Anak Usia Dini"))
        ),
        45 to listOf(
            UserModuleData(61, "terbuka", ModuleDataData(61, 1, "Membangun Bonding dengan Anak Melalui Sentuhan Kasih Sayang"))
        ),
        46 to listOf(
            UserModuleData(62, "terbuka", ModuleDataData(62, 1, "Pentingnya Komunikasi Positif dalam Pengasuhan Anak Usia Dini"))
        ),
        47 to listOf(
            UserModuleData(63, "terbuka", ModuleDataData(63, 1, "Menerapkan Teknik Pengasuhan yang Efektif dengan Penuh Empati"))
        ),
        48 to listOf(
            UserModuleData(64, "terbuka", ModuleDataData(64, 1, "Cara Menumbuhkan Rasa Kepercayaan Diri pada Anak"))
        ),
        49 to listOf(
            UserModuleData(65, "terbuka", ModuleDataData(65, 1, "Mengelola Emosi dalam Pengasuhan: Tips dan Trik"))
        ),
        50 to listOf(
            UserModuleData(66, "terbuka", ModuleDataData(66, 1, "Pendahuluan: Memahami Tahapan Perkembangan Anak Usia 2 - 3 Tahun"))
        ),
        51 to listOf(
            UserModuleData(67, "terbuka", ModuleDataData(67, 1, "Pentingnya Pemahaman Psikologi Anak di Usia Dini"))
        ),
        52 to listOf(
            UserModuleData(68, "terbuka", ModuleDataData(68, 1, "Menghadapi Tantrum dan Perilaku Anak yang Menantang"))
        ),
        53 to listOf(
            UserModuleData(69, "terbuka", ModuleDataData(69, 1, "Menumbuhkan Keterampilan Sosial pada Anak di Usia 2 - 3 Tahun"))
        ),
        54 to listOf(
            UserModuleData(70, "terbuka", ModuleDataData(70, 1, "Peran Orang Tua dalam Pembentukan Perilaku Anak"))
        ),
        55 to listOf(
            UserModuleData(71, "terbuka", ModuleDataData(71, 1, "Cara Mengelola Konflik dengan Anak Usia 2 - 3 Tahun"))
        ),
        56 to listOf(
            UserModuleData(72, "terbuka", ModuleDataData(72, 1, "Pendahuluan: Tantangan dalam Mengasuh Anak Remaja"))
        ),
        57 to listOf(
            UserModuleData(73, "terbuka", ModuleDataData(73, 1, "Pentingnya Komunikasi yang Terbuka dengan Anak Remaja"))
        ),
        58 to listOf(
            UserModuleData(74, "terbuka", ModuleDataData(74, 1, "Menghindari Konflik dengan Anak Remaja"))
        ),
        59 to listOf(
            UserModuleData(75, "terbuka", ModuleDataData(75, 1, "Membangun Empati Dua Arah dalam Komunikasi dengan Anak Remaja"))
        )
    )

    override fun getModulesForChapter(chapterId: Int): List<UserModuleData> {
        return userModules[chapterId] ?: emptyList()
    }

}
