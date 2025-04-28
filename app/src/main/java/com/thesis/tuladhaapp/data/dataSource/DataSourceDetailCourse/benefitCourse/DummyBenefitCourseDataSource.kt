package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.benefitCourse

import com.thesis.tuladhaapp.model.detailcourse.BenefitData

class DummyBenefitCourseDataSource: DataSourceBenefit {

    private val benefits = mapOf(
        1 to listOf(
            BenefitData(1, 0, "Meningkatkan bonding dengan anak untuk menciptakan hubungan emosional yang lebih kuat dan penuh kepercayaan."),
            BenefitData(1, 1, "Mengelola emosi saat mengasuh agar bisa tetap tenang, sabar, dan memberikan respon yang positif kepada anak."),
            BenefitData(1, 2, "Meningkatkan pemahaman orang tua terhadap kebutuhan emosional anak dalam berbagai situasi sehari-hari.")
        ),
        2 to listOf(
            BenefitData(2, 0, "Memahami emosi anak dengan lebih baik sehingga dapat memberikan pendampingan yang sesuai dengan tahap perkembangannya."),
            BenefitData(2, 1, "Menangani tantrum anak dengan teknik yang efektif tanpa memperparah kondisi emosional mereka."),
            BenefitData(2, 2, "Membangun komunikasi terbuka dengan anak untuk membantu mereka mengekspresikan perasaannya dengan sehat.")
        ),
        3 to listOf(
            BenefitData(3, 0, "Menghindari konflik dengan anak remaja melalui pendekatan komunikasi yang lebih tenang dan penuh empati."),
            BenefitData(3, 1, "Membangun empati dua arah agar orang tua dan anak remaja saling memahami perspektif masing-masing."),
            BenefitData(3, 2, "Menguatkan hubungan dengan anak remaja melalui pengasuhan yang mendukung kemandirian mereka.")
        ),
        4 to listOf(
            BenefitData(4, 0, "Membentuk karakter positif anak sejak dini melalui pengenalan nilai-nilai moral dan kebiasaan baik dalam kehidupan sehari-hari."),
            BenefitData(4, 1, "Mendidik anak dengan konsistensi dalam aturan dan sikap agar anak merasa aman dan memahami batasan dengan jelas."),
            BenefitData(4, 2, "Menanamkan rasa tanggung jawab kepada anak melalui bimbingan yang penuh kesabaran dan keteladanan.")
        ),
        5 to listOf(
            BenefitData(5, 0, "Mengajarkan anak tentang keamanan digital untuk melindungi diri mereka dari risiko di dunia maya."),
            BenefitData(5, 1, "Membimbing anak dalam menggunakan media sosial dengan bijak, termasuk membangun etika berinternet yang sehat."),
            BenefitData(5, 2, "Membangun kesadaran anak akan pentingnya menjaga privasi dan keamanan data pribadi mereka di internet.")
        ),
        6 to listOf(
            BenefitData(6, 0, "Meningkatkan kesadaran tentang pentingnya menjaga kesehatan mental bagi ibu baru dalam masa transisi menjadi orang tua."),
            BenefitData(6, 1, "Membekali ibu dengan strategi coping untuk mengatasi stres, kecemasan, dan tantangan emosional setelah melahirkan."),
            BenefitData(6, 2, "Membangun support system yang sehat agar ibu merasa didukung dan tidak merasa sendirian dalam menjalani peran barunya.")
        ),
        7 to listOf(
            BenefitData(7, 0, "Mengasuh dengan pendekatan gentle parenting yang menekankan rasa hormat, kesabaran, dan komunikasi tanpa kekerasan."),
            BenefitData(7, 1, "Membangun hubungan yang harmonis antara orang tua dan anak dengan pengasuhan penuh kasih dan pengertian."),
            BenefitData(7, 2, "Membantu orang tua menerapkan disiplin positif tanpa perlu menggunakan hukuman atau ancaman yang keras.")
        ),
        8 to listOf(
            BenefitData(8, 0, "Mendukung proses belajar anak dengan memahami gaya belajar mereka sehingga lebih mudah memotivasi dan mendampingi mereka."),
            BenefitData(8, 1, "Membantu orang tua menciptakan lingkungan belajar yang nyaman dan sesuai dengan kebutuhan masing-masing anak."),
            BenefitData(8, 2, "Mengajarkan teknik belajar efektif untuk membantu anak mengembangkan potensi akademik dan sosialnya.")
        ),
        9 to listOf(
            BenefitData(9, 0, "Mendorong peran aktif ayah dalam pengasuhan anak untuk menciptakan keterlibatan emosional yang mendalam."),
            BenefitData(9, 1, "Meningkatkan kesadaran ayah tentang pentingnya berbagi peran dalam membesarkan dan mendidik anak."),
            BenefitData(9, 2, "Membangun kerja sama antara ayah dan ibu dalam mengasuh sehingga anak merasa mendapatkan dukungan penuh dari kedua orang tuanya.")
        ),
        10 to listOf(
            BenefitData(10, 0, "Memberikan panduan untuk mendampingi anak berkebutuhan khusus agar mereka dapat tumbuh dan berkembang secara optimal."),
            BenefitData(10, 1, "Mengajarkan orang tua strategi dalam membangun kemandirian dan kepercayaan diri pada anak berkebutuhan khusus."),
            BenefitData(10, 2, "Membekali orang tua dengan keterampilan untuk memahami kebutuhan spesifik dan potensi anak berkebutuhan khusus.")
        )
    )

    override suspend fun getBenefitsForCourse(courseId: Int?): List<BenefitData> {
        return benefits[courseId] ?: emptyList()
    }
}