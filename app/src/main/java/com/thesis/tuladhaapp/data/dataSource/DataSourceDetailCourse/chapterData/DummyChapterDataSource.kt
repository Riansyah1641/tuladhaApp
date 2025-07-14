package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.chapterData

import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.moduleData.DummyModuleDataDataSource
import com.thesis.tuladhaapp.model.detailcourse.ChapterData

class DummyChapterDataSource: DataSourseChapterData {
    private val chapters: Map<Int, List<ChapterData>> = mapOf(
        1 to listOf(
            ChapterData(1, 0, "Pengantar: Mendukung Perkembangan Motorik Bayi", 25, DummyModuleDataDataSource.getModulesForChapter(0)),
            ChapterData(1, 1, "Mengenal Perkembangan Motorik Kasar Awal (0-3 Bulan)", 18, DummyModuleDataDataSource.getModulesForChapter(1)),
            ChapterData(1, 2, "Stimulasi untuk Menegakkan Kepala dan Tengkurap", 22, DummyModuleDataDataSource.getModulesForChapter(2)),
            ChapterData(1, 3, "Pentingnya Pola Asuh Responsif dalam Motorik", 15, DummyModuleDataDataSource.getModulesForChapter(3)),
            ChapterData(1, 4, "Interaksi Hangat dan Stimulasi Sesuai Usia", 28, DummyModuleDataDataSource.getModulesForChapter(4)),
            ChapterData(1, 5, "Bukan Menuntut, Tapi Mendampingi", 12, DummyModuleDataDataSource.getModulesForChapter(5))
        ),
        2 to listOf(
            ChapterData(2, 0, "Pengantar: Membangun Kemandirian Gerak Anak", 17, DummyModuleDataDataSource.getModulesForChapter(6)),
            ChapterData(2, 1, "Melatih Duduk dan Berdiri: Lebih dari Sekadar Fisik", 21, DummyModuleDataDataSource.getModulesForChapter(7)),
            ChapterData(2, 2, "Strategi Mendorong Kemandirian dengan Dukungan", 14, DummyModuleDataDataSource.getModulesForChapter(8)),
            ChapterData(2, 3, "Pola Asuh Authoritative vs. Authoritarian vs. Permissive", 19, DummyModuleDataDataSource.getModulesForChapter(9)),
            ChapterData(2, 4, "Penguatan Emosional dalam Melatih Gerak", 23, DummyModuleDataDataSource.getModulesForChapter(10)),
            ChapterData(2, 5, "Kemandirian Gerak sebagai Bagian dari Pengasuhan Positif", 16, DummyModuleDataDataSource.getModulesForChapter(11))
        ),
        3 to listOf(
            ChapterData(3, 0, "Pengantar: Menyambut Anak Belajar Berjalan", 19, DummyModuleDataDataSource.getModulesForChapter(12)),
            ChapterData(3, 1, "Mengenali Kesiapan Anak untuk Berjalan", 15, DummyModuleDataDataSource.getModulesForChapter(13)),
            ChapterData(3, 2, "Memberikan Dukungan dengan Sabar dan Positif", 21, DummyModuleDataDataSource.getModulesForChapter(14)),
            ChapterData(3, 3, "Membandingkan Pendekatan Pengasuhan dalam Melatih Berjalan", 17, DummyModuleDataDataSource.getModulesForChapter(15)),
            ChapterData(3, 4, "Risiko Jika Anak Dibiarkan Tanpa Stimulasi", 23, DummyModuleDataDataSource.getModulesForChapter(16)),
            ChapterData(3, 5, "Langkah-Langkah Bijak Mendampingi Anak Berjalan", 16, DummyModuleDataDataSource.getModulesForChapter(17))
        ),
        4 to listOf(
            ChapterData(4, 0, "Pengantar: Mendorong Eksplorasi Bayi dengan Aman", 14, DummyModuleDataDataSource.getModulesForChapter(18)),
            ChapterData(4, 1, "Stimulasi Eksplorasi untuk Belajar Gerak", 18, DummyModuleDataDataSource.getModulesForChapter(19)),
            ChapterData(4, 2, "Pentingnya Pengawasan dalam Eksplorasi", 22, DummyModuleDataDataSource.getModulesForChapter(20)),
            ChapterData(4, 3, "Menerapkan Pengasuhan Suportif dan Responsif (Authoritative)", 16, DummyModuleDataDataSource.getModulesForChapter(21)),
            ChapterData(4, 4, "Batasan yang Aman vs. Terlalu Membatasi (Authoritarian)", 19, DummyModuleDataDataSource.getModulesForChapter(22)),
            ChapterData(4, 5, "Melepas Tanpa Arahan (Permissive) dalam Eksplorasi", 13, DummyModuleDataDataSource.getModulesForChapter(23))
        ),
        5 to listOf(
            ChapterData(5, 0, "Pengantar: Komunikasi Awal Anak", 16, DummyModuleDataDataSource.getModulesForChapter(24)),
            ChapterData(5, 1, "Mengenalkan Nama Benda dan Merespon Ucapan", 20, DummyModuleDataDataSource.getModulesForChapter(25)),
            ChapterData(5, 2, "Awal Perkembangan Bahasa Bayi (9-12 Bulan)", 14, DummyModuleDataDataSource.getModulesForChapter(26)),
            ChapterData(5, 3, "Dampak Komunikasi Efektif Berdasarkan Pola Asuh", 22, DummyModuleDataDataSource.getModulesForChapter(27)),
            ChapterData(5, 4, "Responsif, Kaku, atau Permisif dalam Berkomunikasi", 18, DummyModuleDataDataSource.getModulesForChapter(28)),
            ChapterData(5, 5, "Strategi Komunikasi Awal yang Positif", 20, DummyModuleDataDataSource.getModulesForChapter(29))
        ),
        6 to listOf(
            ChapterData(6, 0, "Pengantar: Melatih Motorik Kasar Lewat Bermain", 19, DummyModuleDataDataSource.getModulesForChapter(30)),
            ChapterData(6, 1, "Aktivitas Fisik dan Dukungan Orang Tua", 15, DummyModuleDataDataSource.getModulesForChapter(31)),
            ChapterData(6, 2, "Pola Asuh Authoritative: Membimbing dengan Percaya Diri", 21, DummyModuleDataDataSource.getModulesForChapter(32)),
            ChapterData(6, 3, "Otoriter Penuh Larangan vs. Permisif Minim Arahan", 17, DummyModuleDataDataSource.getModulesForChapter(33)),
            ChapterData(6, 4, "Contoh Permainan Terarah untuk Motorik Kasar", 23, DummyModuleDataDataSource.getModulesForChapter(34)),
            ChapterData(6, 5, "Membangun Kepercayaan Diri Lewat Gerak", 16, DummyModuleDataDataSource.getModulesForChapter(35))
        ),
        7 to listOf(
            ChapterData(7, 0, "Pengantar: Mengembangkan Bahasa Anak", 17, DummyModuleDataDataSource.getModulesForChapter(36)),
            ChapterData(7, 1, "Penggunaan Bahasa yang Kaya di Rumah", 22, DummyModuleDataDataSource.getModulesForChapter(37)),
            ChapterData(7, 2, "Melibatkan Anak Secara Verbal dengan Struktur (Authoritative)", 19, DummyModuleDataDataSource.getModulesForChapter(38)),
            ChapterData(7, 3, "Tidak Memaksa (Authoritarian) vs. Minim Stimulasi (Permissive)", 24, DummyModuleDataDataSource.getModulesForChapter(39)),
            ChapterData(7, 4, "Deskripsi dan Percakapan Sehari-hari", 15, DummyModuleDataDataSource.getModulesForChapter(40)),
            ChapterData(7, 5, "Pentingnya Interaksi Verbal yang Interaktif", 23, DummyModuleDataDataSource.getModulesForChapter(41))
        ),
        8 to listOf(
            ChapterData(8, 0, "Pengantar: Imajinasi dan Regulasi Emosi Lewat Bermain Peran", 20, DummyModuleDataDataSource.getModulesForChapter(42)),
            ChapterData(8, 1, "Permainan Menirukan dan Kreativitas", 18, DummyModuleDataDataSource.getModulesForChapter(43)),
            ChapterData(8, 2, "Stimulasi Motorik dan Ekspresi Emosional", 25, DummyModuleDataDataSource.getModulesForChapter(44)),
            ChapterData(8, 3, "Keseimbangan Kebebasan (Permissive) dan Batasan (Authoritative)", 16, DummyModuleDataDataSource.getModulesForChapter(45)),
            ChapterData(8, 4, "Menghindari Penekanan Berlebihan (Authoritarian)", 22, DummyModuleDataDataSource.getModulesForChapter(46)),
            ChapterData(8, 5, "Membangun Regulasi Emosi Melalui Bermain", 19, DummyModuleDataDataSource.getModulesForChapter(47))
        ),
        9 to listOf(
            ChapterData(9, 0, "Pengantar: Konsep Matematika Dasar", 23, DummyModuleDataDataSource.getModulesForChapter(48)),
            ChapterData(9, 1, "Mengajarkan Angka, Mencocokkan, dan Menghitung", 17, DummyModuleDataDataSource.getModulesForChapter(49)),
            ChapterData(9, 2, "Pendekatan Sesuai Pola Asuh dalam Belajar Matematika", 21, DummyModuleDataDataSource.getModulesForChapter(50)),
            ChapterData(9, 3, "Struktur dan Stimulasi (Authoritative)", 15, DummyModuleDataDataSource.getModulesForChapter(51)),
            ChapterData(9, 4, "Tekanan Berlebihan (Authoritarian) vs. Terlalu Bebas (Permissive)", 24, DummyModuleDataDataSource.getModulesForChapter(52)),
            ChapterData(9, 5, "Belajar Matematika dengan Menyenangkan", 18, DummyModuleDataDataSource.getModulesForChapter(53))
        ),
        10 to listOf(
            ChapterData(10, 0, "Pengantar: Konsep Ukuran dan Perbandingan", 19, DummyModuleDataDataSource.getModulesForChapter(54)),
            ChapterData(10, 1, "Belajar Besar-Kecil dan Berat-Ringan", 22, DummyModuleDataDataSource.getModulesForChapter(55)),
            ChapterData(10, 2, "Mendorong Rasa Ingin Tahu Secara Aktif Namun Terarah (Authoritative)", 16, DummyModuleDataDataSource.getModulesForChapter(56)),
            ChapterData(10, 3, "Bukan Menekan Hasil (Authoritarian)", 25, DummyModuleDataDataSource.getModulesForChapter(57)),
            ChapterData(10, 4, "Tidak Membiarkan Tanpa Bimbingan (Permissive)", 18, DummyModuleDataDataSource.getModulesForChapter(58)),
            ChapterData(10, 5, "Eksperimen Sederhana untuk Memahami Ukuran", 20, DummyModuleDataDataSource.getModulesForChapter(59))
        ), 11 to listOf(
            ChapterData(11, 0, "Pengantar: Kunci Sukses Toilet Training", 18, DummyModuleDataDataSource.getModulesForChapter(60)),
            ChapterData(11, 1, "Mengenali Kesiapan Anak untuk Toilet Training", 15, DummyModuleDataDataSource.getModulesForChapter(61)),
            ChapterData(11, 2, "Pendekatan Positif dalam Toilet Training", 20, DummyModuleDataDataSource.getModulesForChapter(62)),
            ChapterData(11, 3, "Menghadapi Tantangan dengan Empati", 17, DummyModuleDataDataSource.getModulesForChapter(63)),
            ChapterData(11, 4, "Latihan Praktis dan Jadwal Konsisten", 25, DummyModuleDataDataSource.getModulesForChapter(64)),
            ChapterData(11, 5, "Menguatkan Kepercayaan Diri Anak", 15, DummyModuleDataDataSource.getModulesForChapter(65)),
            ChapterData(11, 6, "Studi Kasus dan Pertanyaan Umum", 20, DummyModuleDataDataSource.getModulesForChapter(66))
        ),
        12 to listOf(
            ChapterData(12, 0, "Pengantar: Kreativitas Anak Melalui Seni", 15, DummyModuleDataDataSource.getModulesForChapter(67)),
            ChapterData(12, 1, "Seni sebagai Media Ekspresi Dini", 18, DummyModuleDataDataSource.getModulesForChapter(68)),
            ChapterData(12, 2, "Memfasilitasi Tanpa Batasan Kaku", 20, DummyModuleDataDataSource.getModulesForChapter(69)),
            ChapterData(12, 3, "Pola Asuh Authoritative dalam Seni", 17, DummyModuleDataDataSource.getModulesForChapter(70)),
            ChapterData(12, 4, "Mengembangkan Imajinasi dan Regulasi Emosi", 20, DummyModuleDataDataSource.getModulesForChapter(71))
        ),
        13 to listOf(
            ChapterData(13, 0, "Pengantar: Mengatasi Tantrum pada Balita", 20, DummyModuleDataDataSource.getModulesForChapter(72)),
            ChapterData(13, 1, "Tantrum: Bagian Normal dari Perkembangan", 18, DummyModuleDataDataSource.getModulesForChapter(73)),
            ChapterData(13, 2, "Teknik Merespon Tantrum yang Konstruktif", 22, DummyModuleDataDataSource.getModulesForChapter(74)),
            ChapterData(13, 3, "Menetapkan Batasan yang Jelas dan Konsisten", 19, DummyModuleDataDataSource.getModulesForChapter(75)),
            ChapterData(13, 4, "Mengelola Perilaku Sulit dengan Tenang", 25, DummyModuleDataDataSource.getModulesForChapter(76)),
            ChapterData(13, 5, "Membangun Keterampilan Regulasi Emosi Anak", 20, DummyModuleDataDataSource.getModulesForChapter(77)),
            ChapterData(13, 6, "Pencegahan Tantrum dan Lingkungan yang Mendukung", 18, DummyModuleDataDataSource.getModulesForChapter(78)),
            ChapterData(13, 7, "Studi Kasus dan Solusi Praktis", 8, DummyModuleDataDataSource.getModulesForChapter(79))
        ),
        14 to listOf(
            ChapterData(14, 0, "Pengantar: Kemampuan Sosial Pra-Sekolah", 16, DummyModuleDataDataSource.getModulesForChapter(80)),
            ChapterData(14, 1, "Mendorong Empati dan Berbagi", 18, DummyModuleDataDataSource.getModulesForChapter(81)),
            ChapterData(14, 2, "Meningkatkan Kerjasama Lewat Bermain", 20, DummyModuleDataDataSource.getModulesForChapter(82)),
            ChapterData(14, 3, "Komunikasi Sehat untuk Interaksi Sosial", 15, DummyModuleDataDataSource.getModulesForChapter(83)),
            ChapterData(14, 4, "Pendekatan Authoritative dalam Keterampilan Sosial", 17, DummyModuleDataDataSource.getModulesForChapter(84)),
            ChapterData(14, 5, "Membantu Anak Beradaptasi dengan Lingkungan Baru", 14, DummyModuleDataDataSource.getModulesForChapter(85))
        ),
        15 to listOf(
            ChapterData(15, 0, "Pengantar: Fondasi Literasi Awal", 20, DummyModuleDataDataSource.getModulesForChapter(86)),
            ChapterData(15, 1, "Mengenalkan Huruf dan Angka Melalui Permainan", 22, DummyModuleDataDataSource.getModulesForChapter(87)),
            ChapterData(15, 2, "Membaca Bersama dan Mendongeng", 18, DummyModuleDataDataSource.getModulesForChapter(88)),
            ChapterData(15, 3, "Pola Asuh Authoritative dalam Belajar Literasi", 25, DummyModuleDataDataSource.getModulesForChapter(89)),
            ChapterData(15, 4, "Aktivitas Menulis Sederhana untuk Balita", 20, DummyModuleDataDataSource.getModulesForChapter(90)),
            ChapterData(15, 5, "Membangun Minat Baca Sejak Dini", 22, DummyModuleDataDataSource.getModulesForChapter(91)),
            ChapterData(15, 6, "Menghindari Tekanan Berlebihan dalam Belajar", 15, DummyModuleDataDataSource.getModulesForChapter(92)),
            ChapterData(15, 7, "Membuat Lingkungan yang Kaya Literasi", 10, DummyModuleDataDataSource.getModulesForChapter(93)),
            ChapterData(15, 8, "Studi Kasus dan Tips Praktis", 18, DummyModuleDataDataSource.getModulesForChapter(94))
        ),
        16 to listOf(
            ChapterData(16, 0, "Pengantar: Membangun Resiliensi Anak Pra-Sekolah", 18, DummyModuleDataDataSource.getModulesForChapter(95)),
            ChapterData(16, 1, "Memahami Konsep Resiliensi pada Anak", 15, DummyModuleDataDataSource.getModulesForChapter(96)),
            ChapterData(16, 2, "Pola Asuh Authoritative dan Resiliensi", 20, DummyModuleDataDataSource.getModulesForChapter(97)),
            ChapterData(16, 3, "Mendukung Anak Menghadapi Tantangan", 17, DummyModuleDataDataSource.getModulesForChapter(98)),
            ChapterData(16, 4, "Membangun Rasa Percaya Diri dan Kemampuan Beradaptasi", 22, DummyModuleDataDataSource.getModulesForChapter(99)),
            ChapterData(16, 5, "Mengajarkan Problem Solving Sejak Dini", 18, DummyModuleDataDataSource.getModulesForChapter(100)),
            ChapterData(16, 6, "Studi Kasus: Anak Resilien dalam Praktik", 20, DummyModuleDataDataSource.getModulesForChapter(101))
        ),
        17 to listOf(
            ChapterData(17, 0, "Pengantar: Batasan dan Disiplin Positif", 15, DummyModuleDataDataSource.getModulesForChapter(102)),
            ChapterData(17, 1, "Mengapa Disiplin Positif Penting?", 18, DummyModuleDataDataSource.getModulesForChapter(103)),
            ChapterData(17, 2, "Perbedaan Disiplin Positif vs. Hukuman", 20, DummyModuleDataDataSource.getModulesForChapter(104)),
            ChapterData(17, 3, "Teknik Komunikasi Efektif dalam Menetapkan Batasan", 17, DummyModuleDataDataSource.getModulesForChapter(105)),
            ChapterData(17, 4, "Konsekuensi Logis dan Alami", 22, DummyModuleDataDataSource.getModulesForChapter(106)),
            ChapterData(17, 5, "Membangun Pemahaman, Bukan Hanya Ketakutan", 18, DummyModuleDataDataSource.getModulesForChapter(107))
        ),
        18 to listOf(
            ChapterData(18, 0, "Pengantar: Memilih Mainan Edukatif", 14, DummyModuleDataDataSource.getModulesForChapter(108)),
            ChapterData(18, 1, "Mainan Sesuai Usia dan Tahap Perkembangan", 16, DummyModuleDataDataSource.getModulesForChapter(109)),
            ChapterData(18, 2, "Manfaat Mainan Edukatif untuk Kognitif dan Motorik", 20, DummyModuleDataDataSource.getModulesForChapter(110)),
            ChapterData(18, 3, "Bimbingan Orang Tua dalam Bermain", 15, DummyModuleDataDataSource.getModulesForChapter(111)),
            ChapterData(18, 4, "Menghindari Pembelian Mainan yang Tidak Efektif", 15, DummyModuleDataDataSource.getModulesForChapter(112))
        ),
        19 to listOf(
            ChapterData(19, 0, "Pengantar: Manajemen Waktu Layar Sehat", 15, DummyModuleDataDataSource.getModulesForChapter(113)),
            ChapterData(19, 1, "Dampak Waktu Layar pada Anak dan Remaja", 18, DummyModuleDataDataSource.getModulesForChapter(114)),
            ChapterData(19, 2, "Menetapkan Batasan yang Jelas dan Realistis", 20, DummyModuleDataDataSource.getModulesForChapter(115)),
            ChapterData(19, 3, "Komunikasi Terbuka tentang Aturan Gadget", 17, DummyModuleDataDataSource.getModulesForChapter(116)),
            ChapterData(19, 4, "Mendorong Alternatif Aktivitas Offline", 20, DummyModuleDataDataSource.getModulesForChapter(117))
        ),
        20 to listOf(
            ChapterData(20, 0, "Pengantar: Kebiasaan Tidur Sehat Anak Sekolah", 20, DummyModuleDataDataSource.getModulesForChapter(118)),
            ChapterData(20, 1, "Pentingnya Tidur Cukup untuk Perkembangan Anak", 15, DummyModuleDataDataSource.getModulesForChapter(119)),
            ChapterData(20, 2, "Membentuk Rutinitas Tidur yang Konsisten", 22, DummyModuleDataDataSource.getModulesForChapter(120)),
            ChapterData(20, 3, "Pola Asuh Authoritative dalam Pengelolaan Tidur", 18, DummyModuleDataDataSource.getModulesForChapter(121)),
            ChapterData(20, 4, "Mengatasi Masalah Tidur Umum pada Anak", 25, DummyModuleDataDataSource.getModulesForChapter(122)),
            ChapterData(20, 5, "Menciptakan Lingkungan Tidur yang Optimal", 20, DummyModuleDataDataSource.getModulesForChapter(123)),
            ChapterData(20, 6, "Tips Praktis untuk Kualitas Tidur yang Lebih Baik", 20, DummyModuleDataDataSource.getModulesForChapter(124)),
            ChapterData(20, 7, "Kisah Sukses dari Orang Tua Lain", 10, DummyModuleDataDataSource.getModulesForChapter(125))
        )
    )


    override fun getChaptersForCourse(courseId: Int?): List<ChapterData> {
        return chapters[courseId] ?: emptyList()
    }
}
