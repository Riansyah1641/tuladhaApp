package com.thesis.tuladhaapp.data.dataSource.kuisCourse

import com.thesis.tuladhaapp.model.kuis.Quiz

class DummyKuisCourseDataSource : kuisCourseDataSource {

    private val quizMap: Map<Int, List<Quiz>> = mapOf(
        1 to listOf(
            Quiz(101, "Pada usia 0-3 bulan, stimulasi apa yang penting untuk perkembangan motorik kasar bayi?", "Mendudukkan bayi", "Membiarkan bayi berbaring", "Tummy time", "Mengajari bayi berdiri", "Tummy time"),
            Quiz(102, "Salah satu milestone motorik kasar bayi usia 0-3 bulan adalah...", "Berjalan", "Mengucapkan kata pertama", "Menegakkan kepala", "Menggambar", "Menegakkan kepala"),
            Quiz(103, "Pola asuh responsif menekankan pada...", "Memenuhi semua keinginan bayi", "Memberikan hukuman saat bayi menangis", "Merespon kebutuhan bayi dengan hangat dan tepat", "Mengabaikan tangisan bayi", "Merespon kebutuhan bayi dengan hangat dan tepat"),
            Quiz(104, "Interaksi hangat antara orang tua dan bayi dapat mendukung...", "Keterlambatan bicara", "Perkembangan motorik yang lambat", "Bonding yang kuat", "Ketidakpercayaan pada orang tua", "Bonding yang kuat"),
            Quiz(105, "Stimulasi motorik pada bayi sebaiknya dilakukan...", "Secara paksa", "Saat orang tua ada waktu luang saja", "Sesuai usia dan kemampuan bayi", "Saat bayi sedang tidur", "Sesuai usia dan kemampuan bayi"),
            Quiz(106, "Menuntut kemampuan bayi secara berlebihan dapat menyebabkan...", "Bayi menjadi lebih cepat berkembang", "Stres pada bayi", "Bayi menjadi lebih mandiri", "Bayi lebih mudah diatur", "Stres pada bayi"),
            Quiz(107, "Contoh dukungan sensitif pada perkembangan motorik bayi adalah...", "Membiarkan bayi berusaha sendiri tanpa bantuan", "Memberikan bantuan yang sesuai saat bayi kesulitan", "Membandingkan kemampuan bayi dengan bayi lain", "Memarahi bayi jika tidak bisa melakukan gerakan", "Memberikan bantuan yang sesuai saat bayi kesulitan")
        ).map {
            it.copy(answer = it.answer) // Memastikan answer sesuai dengan salah satu opsi
        },
        2 to listOf(
            Quiz(201, "E-course ini fokus pada pembangunan kemandirian gerak anak usia...", "0-3 bulan", "3-6 bulan", "6-9 bulan", "9-12 bulan", "3-6 bulan"),
            Quiz(202, "Selain latihan fisik, membangun kemandirian gerak juga memerlukan...", "Makanan bergizi", "Penguatan emosional", "Lingkungan yang sepi", "Pakaian yang ketat", "Penguatan emosional"),
            Quiz(203, "Pola asuh yang mendorong kemandirian anak adalah...", "Authoritarian", "Permissive", "Authoritative", "Neglectful", "Authoritative"),
            Quiz(204, "Strategi mendorong kemandirian gerak sebaiknya dilakukan dengan...", "Memaksa anak bergerak", "Mengabaikan usaha anak", "Memberikan dukungan positif", "Melarang anak bergerak", "Memberikan dukungan positif"),
            Quiz(205, "Membiarkan anak tanpa arahan dalam bergerak termasuk pola asuh...", "Authoritative", "Authoritarian", "Permissive", "Demokratis", "Permissive"),
            Quiz(206, "Melatih bayi duduk atau berdiri sebaiknya dilakukan dengan...", "Terburu-buru", "Bertahap sesuai kesiapan anak", "Menggunakan alat bantu terus menerus", "Tanpa pengawasan", "Bertahap sesuai kesiapan anak"),
            Quiz(207, "Penguatan emosional dalam melatih gerak dapat berupa...", "Memberikan hadiah setiap berhasil", "Membandingkan dengan anak lain", "Memberikan semangat dan pujian", "Menghukum jika tidak berhasil", "Memberikan semangat dan pujian"),
            Quiz(208, "Tujuan utama membangun kemandirian gerak adalah agar anak...", "Cepat menjadi atlet", "Tidak merepotkan orang tua", "Lebih percaya diri", "Selalu menurut", "Lebih percaya diri")
        ).map {
            it.copy(answer = it.answer)
        },
        3 to listOf(
            Quiz(301, "E-course ini membahas langkah bijak menyambut anak belajar berjalan pada usia...", "0-3 bulan", "3-6 bulan", "6-9 bulan", "9-12 bulan", "3-6 bulan"),
            Quiz(302, "Langkah pertama dalam menyambut anak belajar berjalan adalah...", "Memakaikan sepatu khusus", "Mengenali kesiapan anak", "Memeganginya terus menerus", "Membiarkannya sendiri", "Mengenali kesiapan anak"),
            Quiz(303, "Memberikan dukungan yang sabar dan positif termasuk dalam pola asuh...", "Authoritarian", "Permissive", "Authoritative", "Tidak peduli", "Authoritative"),
            Quiz(304, "Pendekatan memaksa anak berjalan termasuk pola asuh...", "Authoritative", "Permissive", "Authoritarian", "Demokratis", "Authoritarian"),
            Quiz(305, "Pendekatan mendorong anak berjalan secara bertahap termasuk pola asuh...", "Authoritarian", "Permissive", "Authoritative", "Tidak terlibat", "Authoritative"),
            Quiz(306, "Jika anak dibiarkan tanpa stimulasi berjalan, risikonya adalah...", "Perkembangan motorik lebih cepat", "Tidak ada risiko", "Keterlambatan perkembangan motorik", "Anak menjadi lebih kuat", "Keterlambatan perkembangan motorik"),
            Quiz(307, "Orang tua perlu belajar mengenali... anak berjalan.", "Kecepatan", "Kekuatan", "Kesiapan", "Ketakutan", "Kesiapan"),
            Quiz(308, "Dukungan positif saat anak belajar berjalan dapat membangun...", "Ketergantungan", "Ketidakpercayaan diri", "Kepercayaan diri", "Ketakutan jatuh", "Kepercayaan diri")
        ).map {
            it.copy(answer = it.answer)
        },
        4 to listOf(
            Quiz(401, "E-course ini mengajarkan cara mendorong eksplorasi bayi usia...", "0-3 bulan", "3-6 bulan", "6-9 bulan", "9-12 bulan", "6-9 bulan"),
            Quiz(402, "Stimulasi eksplorasi membantu bayi belajar...", "Berbicara", "Membaca", "Gerak", "Menulis", "Gerak"),
            Quiz(403, "Dalam eksplorasi bayi, pengawasan orang tua tetap...", "Tidak perlu", "Kadang-kadang saja", "Perlu", "Berlebihan", "Perlu"),
            Quiz(404, "Pengasuhan suportif dan responsif termasuk pola asuh...", "Authoritarian", "Permissive", "Authoritative", "Abusive", "Authoritative"),
            Quiz(405, "Terlalu membatasi eksplorasi bayi termasuk pola asuh...", "Authoritative", "Permissive", "Authoritarian", "Demokratis", "Authoritarian"),
            Quiz(406, "Melepas bayi tanpa arahan dalam eksplorasi termasuk pola asuh...", "Authoritative", "Permissive", "Authoritarian", "Tidak peduli", "Permissive"),
            Quiz(407, "Tujuan memberikan batasan yang aman saat eksplorasi adalah...", "Agar bayi tidak penasaran", "Mencegah bahaya", "Agar bayi cepat bosan", "Melatih kepatuhan", "Mencegah bahaya"),
            Quiz(408, "Pola asuh authoritative dalam eksplorasi menyeimbangkan antara...", "Kebebasan dan kekangan", "Hadiah dan hukuman", "Peraturan dan kebebasan", "Kritik dan pujian", "Peraturan dan kebebasan")
        ).map {
            it.copy(answer = it.answer)
        },
        5 to listOf(
            Quiz(501, "E-course ini membahas strategi komunikasi awal anak usia...", "0-3 bulan", "3-6 bulan", "9-12 bulan", "1-2 Tahun", "9-12 bulan"),
            Quiz(502, "Mengenalkan nama benda pada bayi termasuk dalam perkembangan...", "Motorik kasar", "Motorik halus", "Bahasa", "Sosial", "Bahasa"),
            Quiz(503, "Merespon ucapan anak adalah awal dari perkembangan...", "Kognitif", "Emosi", "Bahasa", "Fisik", "Bahasa"),
            Quiz(504, "Komunikasi efektif berbeda dampaknya berdasarkan...", "Waktu komunikasi", "Tempat komunikasi", "Pola asuh", "Jumlah orang yang terlibat", "Pola asuh"),
            Quiz(505, "Pola asuh responsif dalam komunikasi berarti...", "Selalu menuruti perkataan anak", "Mengabaikan perkataan anak", "Merespon dengan perhatian dan pengertian", "Memaksakan anak untuk berbicara", "Merespon dengan perhatian dan pengertian"),
            Quiz(506, "Pola asuh kaku (authoritarian) dalam komunikasi cenderung...", "Banyak bertanya pada anak", "Memberikan perintah tanpa penjelasan", "Mendengarkan pendapat anak", "Berdiskusi dengan anak", "Memberikan perintah tanpa penjelasan"),
            Quiz(507, "Pola asuh permisif dalam komunikasi cenderung...", "Memberikan banyak batasan", "Membiarkan anak tanpa arahan", "Selalu mengkritik anak", "Memberikan banyak pujian tanpa alasan", "Membiarkan anak tanpa arahan"),
            Quiz(508, "Contoh strategi komunikasi awal yang positif adalah...", "Mengabaikan celotehan bayi", "Menyuruh anak diam", "Merespon dengan senyuman dan anggukan", "Berbicara dengan nada tinggi", "Merespon dengan senyuman dan anggukan")
        ).map {
            it.copy(answer = it.answer)
        },
        6 to listOf(
            Quiz(601, "E-course ini fokus pada melatih motorik kasar anak usia...", "0-6 bulan", "6-12 bulan", "1-2 tahun", "2-3 tahun", "1-2 tahun"),
            Quiz(602, "Aktivitas fisik seperti mendorong dengan kaki melatih otot...", "Tangan", "Kaki", "Leher", "Wajah", "Kaki"),
            Quiz(603, "Dukungan orang tua sangat penting dalam melatih motorik kasar agar anak merasa...", "Takut", "Cemas", "Percaya diri", "Malas", "Percaya diri"),
            Quiz(604, "Pola asuh authoritative membimbing anak berkembang aktif dengan...", "Banyak larangan", "Sedikit arahan", "Arahan yang jelas dan dukungan", "Kebebasan tanpa batas", "Arahan yang jelas dan dukungan"),
            Quiz(605, "Pola asuh otoriter cenderung memberikan... dalam melatih motorik kasar.", "Banyak pujian", "Sedikit aturan", "Penuh larangan", "Kebebasan bereksplorasi", "Penuh larangan"),
            Quiz(606, "Pola asuh permisif cenderung memberikan... dalam melatih motorik kasar.", "Arahan yang terstruktur", "Minim arahan", "Hukuman jika tidak berhasil", "Target yang tinggi", "Minim arahan"),
            Quiz(607, "Contoh bermain terarah untuk melatih motorik kasar adalah...", "Menonton televisi", "Bermain gadget", "Mendorong bola", "Duduk diam", "Mendorong bola"),
            Quiz(608, "Melalui bermain yang terarah, anak dapat mengembangkan...", "Kemampuan membaca cepat", "Keterampilan menulis halus", "Keterampilan motorik kasar dan kepercayaan diri", "Kemampuan menghafal", "Keterampilan motorik kasar dan kepercayaan diri")
        ).map {
            it.copy(answer = it.answer)
        },
        7 to listOf(
            Quiz(701, "E-course ini membahas pengembangan bahasa anak usia...", "0-1 tahun", "1-2 tahun", "2-3 tahun", "3-4 tahun", "1-2 tahun"),
            Quiz(702, "Penggunaan bahasa yang kaya di lingkungan rumah sangat...", "Tidak penting", "Sedikit berpengaruh", "Sangat penting", "Membuat anak bingung", "Sangat penting"),
            Quiz(703, "Melibatkan anak secara verbal sambil memberi struktur termasuk pola asuh...", "Authoritarian", "Permissive", "Authoritative", "Neglectful", "Authoritative"),
            Quiz(704, "Memaksa anak bicara termasuk pola asuh...", "Authoritative", "Permissive", "Authoritarian", "Demokratis", "Authoritarian"),
            Quiz(705, "Membiarkan anak tanpa stimulasi bahasa termasuk pola asuh...", "Authoritative", "Permissive", "Authoritarian", "Tidak peduli", "Permissive"),
            Quiz(706, "Contoh penggunaan bahasa yang kaya adalah...", "Berbicara dengan satu kata saja", "Menggunakan kalimat kompleks yang tidak dipahami anak", "Mendeskripsikan benda dan aktivitas sehari-hari", "Diam saat bersama anak", "Mendeskripsikan benda dan aktivitas sehari-hari"),
            Quiz(707, "Percakapan sehari-hari dengan anak dapat meningkatkan...", "Kemampuan motorik halus", "Kemampuan motorik kasar", "Perkembangan bahasa", "Kemampuan berhitung", "Perkembangan bahasa"),
            Quiz(708, "Interaksi verbal yang interaktif melibatkan...", "Orang tua berbicara terus menerus", "Anak berbicara terus menerus", "Percakapan dua arah antara orang tua dan anak", "Tidak ada komunikasi", "Percakapan dua arah antara orang tua dan anak")
        ).map {
            it.copy(answer = it.answer)
        }, 8 to listOf(
            Quiz(801, "E-course ini membahas membangun imajinasi dan regulasi emosi anak usia...", "0-1 tahun", "1-2 tahun", "2-3 tahun", "3-4 tahun", "2-3 tahun"),
            Quiz(802, "Permainan menirukan hewan dapat menstimulasi...", "Kemampuan membaca", "Kemampuan menulis", "Kreativitas, motorik, dan ekspresi emosional", "Kemampuan menghafal", "Kreativitas, motorik, dan ekspresi emosional"),
            Quiz(803, "Keseimbangan antara kebebasan berekspresi dan batasan aman termasuk pola asuh...", "Authoritarian", "Permissive", "Authoritative", "Tidak terlibat", "Authoritative"),
            Quiz(804, "Penekanan yang berlebihan pada anak termasuk pola asuh...", "Authoritative", "Permissive", "Authoritarian", "Demokratis", "Authoritarian"),
            Quiz(805, "Kebebasan berekspresi tanpa batasan termasuk pola asuh...", "Authoritative", "Permissive", "Authoritarian", "Tidak peduli", "Permissive"),
            Quiz(806, "Bermain peran dapat membantu anak mengembangkan...", "Kemampuan fisik", "Kemampuan akademik", "Imajinasi dan regulasi emosi", "Kemampuan berbahasa asing", "Imajinasi dan regulasi emosi"),
            Quiz(807, "Contoh permainan peran yang baik untuk anak usia 2-3 tahun adalah...", "Bermain catur", "Bermain puzzle rumit", "Menirukan suara dan gerakan binatang", "Membaca buku tanpa gambar", "Menirukan suara dan gerakan binatang"),
            Quiz(808, "Regulasi emosi pada anak dapat dilatih melalui...", "Memberikan hukuman setiap marah", "Mengabaikan emosi anak", "Membantu anak mengenali dan mengelola perasaannya", "Melarang anak menunjukkan emosi", "Membantu anak mengenali dan mengelola perasaannya")
        ).map {
            it.copy(answer = it.answer)
        },
        9 to listOf(
            Quiz(901, "E-course ini mengajarkan konsep matematika dasar untuk anak usia...", "1-2 tahun", "2-3 tahun", "3-4 tahun", "4-5 tahun", "3-4 tahun"),
            Quiz(902, "Mengajarkan angka, mencocokkan, dan menghitung sebaiknya dilakukan melalui...", "Hafalan", "Paksaan", "Permainan yang menyenangkan", "Tes tertulis", "Permainan yang menyenangkan"),
            Quiz(903, "Pola asuh authoritative dalam mengajarkan matematika memberikan...", "Tekanan untuk cepat bisa", "Kebebasan tanpa arahan", "Struktur dan stimulasi", "Tidak ada intervensi", "Struktur dan stimulasi"),
            Quiz(904, "Pola asuh authoritarian dalam mengajarkan matematika cenderung...", "Memberikan banyak pujian", "Memberikan sedikit latihan", "Memberikan tekanan berlebihan", "Membiarkan anak belajar sendiri", "Memberikan tekanan berlebihan"),
            Quiz(905, "Pola asuh permissive dalam mengajarkan matematika cenderung...", "Memberikan batasan waktu belajar", "Memberikan banyak tugas", "Terlalu bebas tanpa arah", "Memberikan hadiah setiap berhasil", "Terlalu bebas tanpa arah"),
            Quiz(906, "Contoh aktivitas menyenangkan untuk mengajarkan konsep angka adalah...", "Menulis angka berulang-ulang", "Mewarnai angka", "Bermain dengan balok angka", "Menghafal semua angka", "Bermain dengan balok angka"),
            Quiz(907, "Mencocokkan dapat dilatih dengan meminta anak memasangkan...", "Huruf dengan gambar", "Warna dengan bentuk", "Angka dengan jumlah benda", "Kata dengan artinya", "Angka dengan jumlah benda"),
            Quiz(908, "Konsep menghitung dasar dapat diajarkan dengan menggunakan...", "Soal matematika rumit", "Benda-benda konkret sehari-hari", "Buku teks tebal", "Video pembelajaran panjang", "Benda-benda konkret sehari-hari")
        ).map {
            it.copy(answer = it.answer)
        },
        10 to listOf(
            Quiz(1001, "E-course ini menanamkan konsep ukuran dan perbandingan untuk anak usia...", "2-3 tahun", "3-4 tahun", "4-5 tahun", "5-6 tahun", "4-5 tahun"),
            Quiz(1002, "Anak belajar konsep besar-kecil dan berat-ringan melalui...", "Ceramah", "Membaca buku", "Eksperimen sederhana", "Menulis karangan", "Eksperimen sederhana"),
            Quiz(1003, "Pola asuh authoritative mendorong rasa ingin tahu anak secara...", "Pasif", "Terpaksa", "Aktif namun terarah", "Bebas tanpa batasan", "Aktif namun terarah"),
            Quiz(1004, "Pola asuh authoritarian dalam mengajarkan ukuran cenderung...", "Mendorong eksplorasi bebas", "Memberikan banyak pilihan", "Menekan hasil yang benar", "Memberikan pujian berlebihan", "Menekan hasil yang benar"),
            Quiz(1005, "Pola asuh permissive dalam mengajarkan ukuran cenderung...", "Memberikan struktur yang jelas", "Memberikan banyak aturan", "Membiarkan anak tanpa bimbingan", "Selalu mengawasi anak", "Membiarkan anak tanpa bimbingan"),
            Quiz(1006, "Contoh eksperimen sederhana untuk memahami besar-kecil adalah...", "Melihat gambar di buku", "Mendengarkan penjelasan orang tua", "Membandingkan dua benda yang ukurannya berbeda", "Menghafal istilah besar dan kecil", "Membandingkan dua benda yang ukurannya berbeda"),
            Quiz(1007, "Konsep berat-ringan dapat dipelajari dengan meminta anak...", "Menggambar benda berat dan ringan", "Menulis daftar benda berat dan ringan", "Memegang dan membandingkan langsung benda yang berbeda beratnya", "Melihat video tentang berat dan ringan", "Memegang dan membandingkan langsung benda yang berbeda beratnya"),
            Quiz(1008, "Tujuan menanamkan konsep ukuran dan perbandingan adalah untuk mengembangkan...", "Kemampuan motorik halus", "Kemampuan berbahasa asing", "Pemahaman kognitif dasar", "Keterampilan sosial", "Pemahaman kognitif dasar")
        ).map {
            it.copy(answer = it.answer)
        }
    )

    override fun getAllQuizzes(): Map<Int, List<Quiz>> = quizMap

    override fun getQuizById(id: Int): List<Quiz> = quizMap[id] ?: emptyList()
}