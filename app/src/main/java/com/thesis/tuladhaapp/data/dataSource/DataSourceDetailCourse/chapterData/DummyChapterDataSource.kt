package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.chapterData

import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.moduleData.DummyModuleDataDataSource
import com.thesis.tuladhaapp.model.detailcourse.ChapterData

class DummyChapterDataSource: DataSourseChapterData {

    private val chapters = mapOf(
        1 to listOf(
            ChapterData(1, 0, "Pendahuluan: Pengertian Pengasuhan Anak Usia Dini", 10, DummyModuleDataDataSource.getModulesForChapter(0)),
            ChapterData(1, 1, "Membangun Bonding dengan Anak Melalui Sentuhan Kasih Sayang", 12, DummyModuleDataDataSource.getModulesForChapter(1)),
            ChapterData(1, 2, "Pentingnya Komunikasi Positif dalam Pengasuhan Anak Usia Dini", 9, DummyModuleDataDataSource.getModulesForChapter(2)),
            ChapterData(1, 3, "Menerapkan Teknik Pengasuhan yang Efektif dengan Penuh Empati", 13, DummyModuleDataDataSource.getModulesForChapter(3)),
            ChapterData(1, 4, "Cara Menumbuhkan Rasa Kepercayaan Diri pada Anak", 10, DummyModuleDataDataSource.getModulesForChapter(4)),
            ChapterData(1, 5, "Mengelola Emosi dalam Pengasuhan: Tips dan Trik", 12, DummyModuleDataDataSource.getModulesForChapter(5))
        ),
        2 to listOf(
            ChapterData(2, 0, "Pendahuluan: Memahami Tahapan Perkembangan Anak Usia 2 - 3 Tahun", 11, DummyModuleDataDataSource.getModulesForChapter(6)),
            ChapterData(2, 1, "Pentingnya Pemahaman Psikologi Anak di Usia Dini", 12, DummyModuleDataDataSource.getModulesForChapter(7)),
            ChapterData(2, 2, "Menghadapi Tantrum dan Perilaku Anak yang Menantang", 10, DummyModuleDataDataSource.getModulesForChapter(8)),
            ChapterData(2, 3, "Menumbuhkan Keterampilan Sosial pada Anak di Usia 2 - 3 Tahun", 11, DummyModuleDataDataSource.getModulesForChapter(9)),
            ChapterData(2, 4, "Peran Orang Tua dalam Pembentukan Perilaku Anak", 10, DummyModuleDataDataSource.getModulesForChapter(10)),
            ChapterData(2, 5, "Cara Mengelola Konflik dengan Anak Usia 2 - 3 Tahun", 12, DummyModuleDataDataSource.getModulesForChapter(11))
        ),
        3 to listOf(
            ChapterData(3, 0, "Pendahuluan: Tantangan dalam Mengasuh Anak Remaja", 13, DummyModuleDataDataSource.getModulesForChapter(12)),
            ChapterData(3, 1, "Pentingnya Komunikasi yang Terbuka dengan Anak Remaja", 12, DummyModuleDataDataSource.getModulesForChapter(13)),
            ChapterData(3, 2, "Menghindari Konflik dengan Anak Remaja", 11, DummyModuleDataDataSource.getModulesForChapter(14)),
            ChapterData(3, 3, "Membangun Empati Dua Arah dalam Komunikasi dengan Anak Remaja", 13, DummyModuleDataDataSource.getModulesForChapter(15)),
            ChapterData(3, 4, "Mendukung Kemandirian dan Kepercayaan Diri Anak Remaja", 12, DummyModuleDataDataSource.getModulesForChapter(16)),
            ChapterData(3, 5, "Teknik-Teknik untuk Menjalin Hubungan yang Sehat dengan Anak Remaja", 10, DummyModuleDataDataSource.getModulesForChapter(17))
        ),
        4 to listOf(
            ChapterData(4, 0, "Pendahuluan: Mengajarkan Nilai Moral kepada Anak Usia Dini", 10, DummyModuleDataDataSource.getModulesForChapter(18)),
            ChapterData(4, 1, "Peran Orang Tua dalam Pembentukan Karakter Positif Anak", 11, DummyModuleDataDataSource.getModulesForChapter(19)),
            ChapterData(4, 2, "Mendidik dengan Konsistensi dalam Pembelajaran dan Peraturan", 12, DummyModuleDataDataSource.getModulesForChapter(20)),
            ChapterData(4, 3, "Membangun Rasa Tanggung Jawab Anak Sejak Dini", 13, DummyModuleDataDataSource.getModulesForChapter(21)),
            ChapterData(4, 4, "Menumbuhkan Nilai Empati dan Kasih Sayang pada Anak", 12, DummyModuleDataDataSource.getModulesForChapter(22)),
            ChapterData(4, 5, "Cara Menjadi Teladan yang Baik untuk Anak Usia Dini", 10, DummyModuleDataDataSource.getModulesForChapter(23))
        ),
        5 to listOf(
            ChapterData(5, 0, "Pendahuluan: Keamanan Digital dan Perlindungan Anak", 12, DummyModuleDataDataSource.getModulesForChapter(24)),
            ChapterData(5, 1, "Mengenalkan Konsep Keamanan Digital pada Anak", 13, DummyModuleDataDataSource.getModulesForChapter(25)),
            ChapterData(5, 2, "Mengajarkan Etika Berinternet yang Sehat", 12, DummyModuleDataDataSource.getModulesForChapter(26)),
            ChapterData(5, 3, "Membangun Kesadaran Privasi dan Keamanan Data Anak", 14, DummyModuleDataDataSource.getModulesForChapter(27)),
            ChapterData(5, 4, "Memahami Tantangan Media Sosial bagi Anak", 13, DummyModuleDataDataSource.getModulesForChapter(28)),
            ChapterData(5, 5, "Menjaga Anak dari Risiko Dunia Maya dan Teknologi", 11, DummyModuleDataDataSource.getModulesForChapter(29))
        ),
        6 to listOf(
            ChapterData(6, 0, "Pendahuluan: Perubahan Psikologis pada Ibu Baru", 12, DummyModuleDataDataSource.getModulesForChapter(30)),
            ChapterData(6, 1, "Mengatasi Stres dan Kecemasan Setelah Melahirkan", 13, DummyModuleDataDataSource.getModulesForChapter(31)),
            ChapterData(6, 2, "Pentingnya Dukungan Sosial untuk Ibu Baru", 10, DummyModuleDataDataSource.getModulesForChapter(32)),
            ChapterData(6, 3, "Membangun Strategi Coping untuk Menghadapi Tantangan Emosional", 12, DummyModuleDataDataSource.getModulesForChapter(33)),
            ChapterData(6, 4, "Pentingnya Kesehatan Mental bagi Ibu Baru", 13, DummyModuleDataDataSource.getModulesForChapter(34)),
            ChapterData(6, 5, "Menyiapkan Mental Ibu Baru untuk Tugas Pengasuhan", 12, DummyModuleDataDataSource.getModulesForChapter(35))
        ),
        7 to listOf(
            ChapterData(7, 0, "Pendahuluan: Apa Itu Gentle Parenting?", 10, DummyModuleDataDataSource.getModulesForChapter(36)),
            ChapterData(7, 1, "Menumbuhkan Rasa Hormat dan Kasih Sayang pada Anak", 11, DummyModuleDataDataSource.getModulesForChapter(37)),
            ChapterData(7, 2, "Membangun Komunikasi Tanpa Kekerasan dalam Pengasuhan", 12, DummyModuleDataDataSource.getModulesForChapter(38)),
            ChapterData(7, 3, "Mengajarkan Disiplin Positif Tanpa Hukuman", 13, DummyModuleDataDataSource.getModulesForChapter(39)),
            ChapterData(7, 4, "Menerapkan Pendekatan Pengasuhan yang Harmonis dan Saling Menghargai", 11, DummyModuleDataDataSource.getModulesForChapter(40)),
            ChapterData(7, 5, "Menghadapi Tantangan dalam Menerapkan Gentle Parenting", 12, DummyModuleDataDataSource.getModulesForChapter(41))
        ),
        8 to listOf(
            ChapterData(8, 0, "Pendahuluan: Menyadari Berbagai Gaya Belajar Anak", 10, DummyModuleDataDataSource.getModulesForChapter(42)),
            ChapterData(8, 1, "Mengoptimalkan Potensi Belajar Anak Melalui Gaya Belajarnya", 12, DummyModuleDataDataSource.getModulesForChapter(43)),
            ChapterData(8, 2, "Membantu Anak Belajar dengan Teknik yang Sesuai", 11, DummyModuleDataDataSource.getModulesForChapter(44)),
            ChapterData(8, 3, "Menciptakan Lingkungan Belajar yang Ideal bagi Anak", 13, DummyModuleDataDataSource.getModulesForChapter(45)),
            ChapterData(8, 4, "Menstimulasi Potensi Akademik dan Sosial Anak", 12, DummyModuleDataDataSource.getModulesForChapter(46)),
            ChapterData(8, 5, "Cara Memotivasi Anak Agar Semangat Belajar", 10, DummyModuleDataDataSource.getModulesForChapter(47))
        ),
        9 to listOf(
            ChapterData(9, 0, "Pendahuluan: Peran Ayah dalam Pengasuhan Anak", 12, DummyModuleDataDataSource.getModulesForChapter(48)),
            ChapterData(9, 1, "Mengasuh Anak Bersama: Membangun Keterlibatan Ayah", 11, DummyModuleDataDataSource.getModulesForChapter(49)),
            ChapterData(9, 2, "Pentingnya Keterlibatan Ayah dalam Perkembangan Anak", 13, DummyModuleDataDataSource.getModulesForChapter(50)),
            ChapterData(9, 3, "Meningkatkan Keterampilan Ayah dalam Pengasuhan Anak", 12, DummyModuleDataDataSource.getModulesForChapter(51)),
            ChapterData(9, 4, "Ayah dan Peranannya dalam Pendidikan Anak", 11, DummyModuleDataDataSource.getModulesForChapter(52)),
            ChapterData(9, 5, "Menghadapi Tantangan Keluarga: Peran Ayah dan Ibu", 12, DummyModuleDataDataSource.getModulesForChapter(53))
        ),
        10 to listOf(
            ChapterData(10, 0, "Pendahuluan: Memahami Peran Pendidikan Seksual dalam Pengasuhan", 12, DummyModuleDataDataSource.getModulesForChapter(54)),
            ChapterData(10, 1, "Menumbuhkan Sikap Positif terhadap Pendidikan Seksual Anak", 13, DummyModuleDataDataSource.getModulesForChapter(55)),
            ChapterData(10, 2, "Cara Mengajarkan Konsep Privasi dan Batasan kepada Anak", 12, DummyModuleDataDataSource.getModulesForChapter(56)),
            ChapterData(10, 3, "Mengedukasi Anak tentang Hubungan Sehat dan Hormat", 14, DummyModuleDataDataSource.getModulesForChapter(57)),
            ChapterData(10, 4, "Mendukung Perkembangan Seksual yang Sehat pada Anak", 13, DummyModuleDataDataSource.getModulesForChapter(58)),
            ChapterData(10, 5, "Menghadapi Tantangan dalam Pendidikan Seksual Anak", 12, DummyModuleDataDataSource.getModulesForChapter(59))
        )
    )

    override fun getChaptersForCourse(courseId: Int?): List<ChapterData> {
        return chapters[courseId] ?: emptyList()
    }
}
