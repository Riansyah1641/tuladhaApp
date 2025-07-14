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
        ),
        11 to listOf(
            BenefitData(11, 1, "Membekali orang tua dengan panduan praktis toilet training yang efektif."),
            BenefitData(11, 2, "Mengajarkan cara mengenali kesiapan anak dan memberikan dukungan positif selama proses."),
            BenefitData(11, 3, "Mengurangi tekanan dan frustrasi bagi orang tua maupun anak saat toilet training.")
        ),
        12 to listOf(
            BenefitData(12, 1, "Menstimulasi imajinasi dan daya cipta anak melalui berbagai kegiatan seni."),
            BenefitData(12, 2, "Mendorong ekspresi diri anak secara bebas dan positif."),
            BenefitData(12, 3, "Membantu anak mengembangkan motorik halus dan koordinasi mata-tangan lewat aktivitas seni.")
        ),
        13 to listOf(
            BenefitData(13, 1, "Memberikan strategi efektif untuk mengelola tantrum balita dengan tenang dan empati."),
            BenefitData(13, 2, "Membantu orang tua memahami akar penyebab tantrum dan cara merespon yang konstruktif."),
            BenefitData(13, 3, "Membangun kemampuan regulasi emosi pada anak sejak dini.")
        ),
        14 to listOf(
            BenefitData(14, 1, "Meningkatkan kemampuan anak dalam berinteraksi sosial dengan teman sebaya."),
            BenefitData(14, 2, "Mendorong empati, berbagi, dan kerjasama dalam berbagai situasi."),
            BenefitData(14, 3, "Membantu anak beradaptasi lebih baik di lingkungan baru seperti pra-sekolah.")
        ),
        15 to listOf(
            BenefitData(15, 1, "Mengenalkan dasar-dasar literasi (membaca dan menulis) dengan cara yang menyenangkan."),
            BenefitData(15, 2, "Menumbuhkan minat anak terhadap buku dan proses belajar sejak usia dini."),
            BenefitData(15, 3, "Membekali orang tua dengan aktivitas sederhana untuk stimulasi literasi di rumah.")
        ),
        16 to listOf(
            BenefitData(16, 1, "Membangun ketahanan mental (resiliensi) pada anak untuk menghadapi tantangan hidup."),
            BenefitData(16, 2, "Mengajarkan anak cara mengatasi kegagalan dan bangkit kembali dengan semangat positif."),
            BenefitData(16, 3, "Mendorong anak untuk menjadi pribadi yang adaptif dan percaya diri.")
        ),
        17 to listOf(
            BenefitData(17, 1, "Memberikan panduan tentang penerapan disiplin positif tanpa kekerasan fisik atau verbal."),
            BenefitData(17, 2, "Membantu anak memahami alasan di balik aturan dan konsekuensi perilaku."),
            BenefitData(17, 3, "Membangun hubungan orang tua-anak yang lebih kuat berdasarkan rasa hormat dan saling pengertian.")
        ),
        18 to listOf(
            BenefitData(18, 1, "Mengedukasi orang tua tentang pemilihan mainan edukatif yang sesuai usia dan tahap perkembangan anak."),
            BenefitData(18, 2, "Mengoptimalkan manfaat bermain untuk stimulasi kognitif, motorik, dan sosial anak."),
            BenefitData(18, 3, "Membantu mengurangi pembelian mainan yang tidak efektif dan memaksimalkan potensi mainan yang ada.")
        ),
        19 to listOf(
            BenefitData(19, 1, "Mengajarkan cara menetapkan batasan waktu layar yang sehat dan realistis untuk anak."),
            BenefitData(19, 2, "Mendorong aktivitas alternatif yang lebih interaktif dan bermanfaat daripada waktu layar berlebihan."),
            BenefitData(19, 3, "Membantu orang tua membimbing anak menggunakan teknologi secara bijak dan bertanggung jawab.")
        ),
        20 to listOf(
            BenefitData(20, 1, "Memberikan strategi praktis untuk membentuk kebiasaan tidur yang sehat pada anak."),
            BenefitData(20, 2, "Membantu anak memiliki pola tidur yang teratur dan berkualitas untuk tumbuh kembang optimal."),
            BenefitData(20, 3, "Mengurangi masalah tidur umum pada anak dan meningkatkan kualitas tidur seluruh anggota keluarga.")
        )
    )


    override suspend fun getBenefitsForCourse(courseId: Int?): List<BenefitData> {
        return benefits[courseId] ?: emptyList()
    }
}