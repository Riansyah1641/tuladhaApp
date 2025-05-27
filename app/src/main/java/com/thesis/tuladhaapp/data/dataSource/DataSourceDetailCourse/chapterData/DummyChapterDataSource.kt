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
        )
    )


    override fun getChaptersForCourse(courseId: Int?): List<ChapterData> {
        return chapters[courseId] ?: emptyList()
    }
}
