package com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.benefitCourse

import com.thesis.tuladhaapp.model.detailcourse.BenefitData

class DummyBenefitCourseDataSource: DataSourceBenefit {

    private val benefits = mapOf(
        1 to listOf(
            BenefitData(1, 1, "Menstimulasi motorik bayi dengan aktivitas harian yang menyenangkan dan memperkuat otot tubuhnya."),
            BenefitData(1, 2, "Meningkatkan keterlibatan orang tua dalam fase awal perkembangan fisik anak."),
            BenefitData(1, 3, "Membantu orang tua memahami tahapan perkembangan motorik bayi usia 0–3 bulan.")
        ),
        2 to listOf(
            BenefitData(2, 1, "Meningkatkan kemampuan anak dalam mengenali dan mengekspresikan emosinya."),
            BenefitData(2, 2, "Membantu orang tua merespons emosi anak secara tepat dan membangun regulasi emosi."),
            BenefitData(2, 3, "Mengurangi risiko tantrum dan perilaku impulsif melalui latihan mengenali emosi.")
        ),
        3 to listOf(
            BenefitData(3, 1, "Memberikan orang tua pemahaman tentang pentingnya keterlibatan aktif dalam perkembangan anak."),
            BenefitData(3, 2, "Meningkatkan kualitas waktu bersama untuk membentuk kedekatan emosional yang kuat."),
            BenefitData(3, 3, "Menanamkan nilai pengasuhan penuh perhatian untuk mendukung tumbuh kembang anak.")
        ),
        4 to listOf(
            BenefitData(4, 1, "Mengajarkan orang tua mengenali gejala keterlambatan bicara pada balita."),
            BenefitData(4, 2, "Membekali dengan strategi komunikasi sederhana untuk merangsang perkembangan bahasa."),
            BenefitData(4, 3, "Meningkatkan kepercayaan diri orang tua dalam mendampingi anak dengan masalah keterlambatan bicara.")
        ),
        5 to listOf(
            BenefitData(5, 1, "Membekali orang tua pengetahuan dasar seputar pengasuhan anak di era digital."),
            BenefitData(5, 2, "Memberikan pemahaman tentang tantangan dan risiko screen time bagi balita."),
            BenefitData(5, 3, "Membantu orang tua menetapkan aturan sehat dalam penggunaan teknologi sejak dini.")
        ),
        6 to listOf(
            BenefitData(6, 1, "Menumbuhkan sikap sabar dan penuh pengertian dalam mendampingi perkembangan emosi anak."),
            BenefitData(6, 2, "Melatih orang tua mengelola emosi saat menghadapi perilaku sulit anak."),
            BenefitData(6, 3, "Meningkatkan kualitas interaksi yang empatik antara orang tua dan anak.")
        ),
        7 to listOf(
            BenefitData(7, 1, "Meningkatkan kesadaran pentingnya menjaga mental health ibu selama masa kehamilan."),
            BenefitData(7, 2, "Membekali ibu hamil dengan teknik relaksasi dan dukungan emosional."),
            BenefitData(7, 3, "Mencegah stres berlebihan yang dapat memengaruhi tumbuh kembang janin.")
        ),
        8 to listOf(
            BenefitData(8, 1, "Membantu orang tua mengenal prinsip pengasuhan positif dalam praktik sehari-hari."),
            BenefitData(8, 2, "Mendorong komunikasi yang hangat, terbuka, dan bebas dari kekerasan."),
            BenefitData(8, 3, "Menurunkan konflik keluarga melalui pendekatan pengasuhan yang demokratis.")
        ),
        9 to listOf(
            BenefitData(9, 1, "Mengajarkan langkah-langkah dalam menciptakan rutinitas tidur yang sehat untuk bayi."),
            BenefitData(9, 2, "Membantu bayi memiliki pola tidur yang konsisten untuk pertumbuhan optimal."),
            BenefitData(9, 3, "Mengurangi stres orang tua akibat gangguan tidur bayi yang tidak teratur.")
        ),
        10 to listOf(
            BenefitData(10, 1, "Menumbuhkan kemampuan problem solving pada anak sejak dini melalui stimulasi yang tepat."),
            BenefitData(10, 2, "Meningkatkan kreativitas dan daya pikir anak lewat aktivitas bermain yang terarah."),
            BenefitData(10, 3, "Membantu orang tua memahami pentingnya peran permainan dalam perkembangan kognitif.")
        )
    )


    override suspend fun getBenefitsForCourse(courseId: Int?): List<BenefitData> {
        return benefits[courseId] ?: emptyList()
    }
}