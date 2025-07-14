package com.thesis.tuladhaapp.data.dataSource.course


import com.thesis.tuladhaapp.model.course.Course
import com.thesis.tuladhaapp.model.course.CourseBenefit
import com.thesis.tuladhaapp.model.course.CourseCategory
import com.thesis.tuladhaapp.model.course.CourseCreator

class DummyCourseDataSource : DataSourceCourse {
    override suspend fun getCourses(
        search: String?,
        type: String?,
        category: Int?,
        level: String?,
        sortBy: String?
    ): List<Course> {
        val allCourses = listOf(
            Course(
                id = 1,
                name = "Mendukung Perkembangan Motorik Bayi Melalui Pendekatan Responsif",
                imageUrl = "https://images.unsplash.com/photo-1629360046014-c8c91b6c2881?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.8,
                categoryId = 4,
                description = "E-course ini mengajarkan orang tua cara mendampingi perkembangan motorik kasar bayi secara sensitif dan penuh dukungan, seperti menegakkan kepala dan tengkurap. Orang tua dengan pola asuh authoritative akan diajak berinteraksi hangat dan memberikan stimulasi yang sesuai usia, bukan menuntut kemampuan bayi secara berlebihan.",
                classCode = "PARENT01",
                totalModule = 6,
                totalDuration = 120,
                type = "Umum",
                price = 150000,
                promoDiscountPercentage = 20,
                totalUser = 340,
                courseBy = "Dr. Andini Pratama",
                createdBy = 1,
                createdAt = "2024-10-01T10:00:00Z",
                updatedAt = "2024-10-10T10:00:00Z",
                category = CourseCategory(4, "0-3 Bulan"),
                courseCreator = CourseCreator(1, "Dr. Andini Pratama"),
                benefits = listOf(
                    CourseBenefit(1, 1, "Meningkatkan bonding dengan anak"),
                    CourseBenefit(2, 1, "Mengelola emosi saat mengasuh")
                )
            ),
            Course(
                id = 2,
                name = "Membangun Kemandirian Gerak Anak dengan Dukungan Positif",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoriterr.mp4?raw=true",
                level = "Si kecil",
                rating = 4.7,
                categoryId = 5,
                description = "Melatih bayi duduk atau berdiri tidak hanya membutuhkan latihan fisik, tapi juga penguatan emosional. E-course ini membekali orang tua dengan strategi mendorong kemandirian anak melalui pola asuh yang mendorong (authoritative), bukan memaksa (authoritarian) atau membiarkan tanpa arahan (permissive).",
                classCode = "PARENT02",
                totalModule = 8,
                totalDuration = 150,
                type = "Umum",
                price = 180000,
                promoDiscountPercentage = 15,
                totalUser = 290,
                courseBy = "Rian Surya, M.Psi",
                createdBy = 1,
                createdAt = "2024-09-20T09:30:00Z",
                updatedAt = "2024-10-02T09:30:00Z",
                category = CourseCategory(5, "3-6 Bulan"),
                courseCreator = CourseCreator(2, "Rian Surya, M.Psi"),
                benefits = listOf(
                    CourseBenefit(3, 2, "Memahami emosi anak"),
                    CourseBenefit(4, 2, "Menangani tantrum dengan tepat")
                )
            ),
            Course(
                id = 3,
                name = "Langkah Bijak Menyambut Anak Belajar Berjalan",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661545941394-91ce7c6f750e?q=80&w=2084&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.5,
                categoryId = 5,
                description = "Orang tua akan belajar mengenali kesiapan anak berjalan, lalu memberikan dukungan dengan sabar dan positif. Materi ini membandingkan pendekatan memaksa (authoritarian) versus pendekatan mendorong bertahap (authoritative), dan membahas risiko jika anak dibiarkan tanpa stimulasi (permissive).",
                classCode = "PARENT03",
                totalModule = 10,
                totalDuration = 180,
                type = "khusus",
                price = 200000,
                promoDiscountPercentage = 25,
                totalUser = 220,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2024-08-15T08:00:00Z",
                updatedAt = "2024-09-10T08:00:00Z",
                category = CourseCategory(5, "3-6 Bulan"),
                courseCreator = CourseCreator(3, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(5, 3, "Menghindari konflik dengan anak remaja"),
                    CourseBenefit(6, 3, "Membangun empati dua arah")
                )
            ),
            Course(
                id = 4,
                name = "Mendorong Eksplorasi Bayi dengan Batasan yang Aman",
                imageUrl = "https://plus.unsplash.com/premium_photo-1666299721610-5853da3427ac?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/permisif_vidioo.mp4?raw=true",
                level = "Si kecil",
                rating = 4.6,
                categoryId = 6,
                description = "Stimulasi eksplorasi membantu bayi belajar gerak, tetapi tetap perlu pengawasan. Course ini mengajarkan orang tua bagaimana menerapkan pengasuhan yang suportif dan responsif (authoritative) dibanding terlalu membatasi (authoritarian) atau melepas tanpa arahan (permissive).",
                classCode = "PARENT04",
                totalModule = 7,
                totalDuration = 110,
                type = "ringkas",
                price = 130000,
                promoDiscountPercentage = 10,
                totalUser = 400,
                courseBy = "Dewi Maharani",
                createdBy = 1,
                createdAt = "2024-07-10T10:00:00Z",
                updatedAt = "2024-07-15T10:00:00Z",
                category = CourseCategory(6, "6-9 Bulan"),
                courseCreator = CourseCreator(4, "Dewi Maharani"),
                benefits = listOf(
                    CourseBenefit(7, 4, "Membentuk karakter positif"),
                    CourseBenefit(8, 4, "Mendidik dengan konsistensi")
                )
            ),
            Course(
                id = 5,
                name = "Strategi Komunikasi Awal Anak Sesuai Pola Asuh Positif",
                imageUrl = "https://plus.unsplash.com/premium_vector-1724144958875-25d1dc8da246?q=80&w=2360&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.7,
                categoryId = 7,
                description = "Mengenalkan nama benda dan merespon ucapan anak jadi awal perkembangan bahasanya. Dalam course ini, orang tua diajak memahami bagaimana komunikasi efektif berbeda dampaknya berdasarkan pola asuh yang diterapkan—baik itu responsif, kaku, atau permisif.",
                classCode = "PARENT05",
                totalModule = 5,
                totalDuration = 90,
                type = "Umum",
                price = 140000,
                promoDiscountPercentage = 15,
                totalUser = 280,
                courseBy = "Rian Surya",
                createdBy = 1,
                createdAt = "2024-07-11",
                updatedAt = "2024-07-15",
                category = CourseCategory(7, "9-12 Bulan"),
                courseCreator = CourseCreator(2, "Rian Surya"),
                benefits = listOf(
                    CourseBenefit(9, 5, "Aman berinternet"),
                    CourseBenefit(10, 5, "Membimbing anak di media sosial")
                )
            ),
            Course(
                id = 6,
                name = "Melatih Motorik Kasar Anak Lewat Bermain yang Terarah",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661517729115-4b1069692b4b?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.8,
                categoryId = 1,
                description = "Aktivitas fisik seperti mendorong dengan kaki atau bermain aktif membutuhkan dukungan orang tua. E-course ini membahas bagaimana pola asuh authoritative dapat membimbing anak berkembang aktif dan percaya diri, dibanding otoriter yang penuh larangan atau permisif yang minim arahan.",
                classCode = "PARENT06",
                totalModule = 6,
                totalDuration = 100,
                type = "Umum",
                price = 120000,
                promoDiscountPercentage = 0,
                totalUser = 190,
                courseBy = "Dr. Anatasya S.Kep",
                createdBy = 1,
                createdAt = "2024-07-01",
                updatedAt = "2024-07-05",
                category = CourseCategory(1, "Otoritatif"),
                courseCreator = CourseCreator(5, "Dr. Anatasya S.Kep"),
                benefits = listOf(
                    CourseBenefit(11, 6, "Mental health awareness")
                )
            ),
            Course(
                id = 7,
                name = "Mengembangkan Bahasa Anak Lewat Deskripsi dan Percakapan Sehari-hari",
                imageUrl = "https://images.unsplash.com/photo-1544776193-352d25ca82cd?q=80&w=1929&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoriterr.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.9,
                categoryId = 1,
                description = "Penggunaan bahasa yang kaya dan interaktif di lingkungan rumah sangat penting. Course ini mengajak orang tua melibatkan anak secara verbal sambil tetap memberi struktur (authoritative), tidak memaksa anak bicara (authoritarian), atau membiarkan anak tanpa stimulasi bahasa (permissive).",
                classCode = "PARENT07",
                totalModule = 8,
                totalDuration = 130,
                type = "Khusus",
                price = 180000,
                promoDiscountPercentage = 30,
                totalUser = 500,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2024-06-01",
                updatedAt = "2024-06-10",
                category = CourseCategory(1, "Otoritatif"),
                courseCreator = CourseCreator(3, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(12, 7, "Gentle parenting")
                )
            ),
            Course(
                id = 8,
                name = "Membangun Imajinasi dan Regulasi Emosi Anak Lewat Bermain Peran",
                imageUrl = "https://plus.unsplash.com/premium_photo-1682751162797-86ae25215217?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/permisif_vidioo.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.6,
                categoryId = 3,
                description = "Permainan menirukan hewan dapat menstimulasi kreativitas, motorik, dan ekspresi emosional. Course ini menekankan pentingnya keseimbangan antara kebebasan berekspresi (permissive)",
                classCode = "PARENT08",
                totalModule = 4,
                totalDuration = 80,
                type = "Khusus",
                price = 100000,
                promoDiscountPercentage = 0,
                totalUser = 150,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2024-05-15",
                updatedAt = "2024-05-20",
                category = CourseCategory(3, "Permisif"),
                courseCreator = CourseCreator(2, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(13, 8, "Membantu anak belajar")
                )
            ),
            Course(
                id = 9,
                name = "Mengajarkan Konsep Matematika Dasar dalam Pola Asuh Seimbang",
                imageUrl = "https://images.unsplash.com/photo-1581089778245-3ce67677f718?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoriterr.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.7,
                categoryId = 2,
                description = "Mengajarkan angka, mencocokkan, dan menghitung dapat dilakukan secara menyenangkan melalui permainan. E-course ini membantu orang tua memilih pendekatan sesuai pola asuh: struktur dan stimulasi (authoritative), tekanan berlebihan (authoritarian), atau terlalu bebas tanpa arah (permissive).",
                classCode = "PARENT09",
                totalModule = 5,
                totalDuration = 95,
                type = "Khusus",
                price = 110000,
                promoDiscountPercentage = 5,
                totalUser = 120,
                courseBy = "Budi Santoso, M.Psi",
                createdBy = 1,
                createdAt = "2024-05-01",
                updatedAt = "2024-05-05",
                category = CourseCategory(2, "Otoriter"),
                courseCreator = CourseCreator(6, "Budi Santoso, M.Psi"),
                benefits = listOf(
                    CourseBenefit(14, 9, "Peran ayah aktif")
                )
            ),
            Course(
                id = 10,
                name = "Menanamkan Konsep Ukuran dan Perbandingan Lewat Aktivitas Bermain",
                imageUrl = "https://images.unsplash.com/photo-1714646082106-188388cc2e3c?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/permisif_vidioo.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.9,
                categoryId = 3,
                description = "Anak belajar konsep besar-kecil dan berat-ringan lewat eksperimen sederhana. Course ini membimbing orang tua untuk mendorong rasa ingin tahu anak secara aktif namun terarah (authoritative), bukan menekan hasil (authoritarian) atau membiarkan anak tanpa bimbingan (permissive).",
                classCode = "PARENT10",
                totalModule = 9,
                totalDuration = 160,
                type = "Khusus",
                price = 210000,
                promoDiscountPercentage = 40,
                totalUser = 100,
                courseBy = "Dr. Nia, M.Psi",
                createdBy = 1,
                createdAt = "2024-04-10",
                updatedAt = "2024-04-15",
                category = CourseCategory(3, "Permisif"),
                courseCreator = CourseCreator(7, "Dr. Nia, M.Psi"),
                benefits = listOf(
                    CourseBenefit(15, 10, "Pendampingan ABK")
                )
            ), Course(
                id = 11,
                name = "Kunci Sukses Toilet Training dengan Pendekatan Positif",
                imageUrl = "https://images.unsplash.com/photo-1629360046014-c8c91b6c2881?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.8,
                categoryId = 8,
                description = "E-course ini membimbing orang tua melalui proses toilet training dengan sabar, menerapkan pola asuh authoritative yang fokus pada dukungan dan penguatan positif, bukan paksaan atau tekanan berlebihan. Pelajari cara mengenali kesiapan anak dan menghadapi tantangan dengan empati.",
                classCode = "PARENT11",
                totalModule = 7,
                totalDuration = 110, // Umum
                type = "Umum",
                price = 160000,
                promoDiscountPercentage = 10,
                totalUser = 310,
                courseBy = "Dr. Andini Pratama",
                createdBy = 1,
                createdAt = "2024-03-20T10:00:00Z",
                updatedAt = "2024-03-25T10:00:00Z",
                category = CourseCategory(8, "1-2 Tahun"),
                courseCreator = CourseCreator(1, "Dr. Andini Pratama"),
                benefits = listOf(
                    CourseBenefit(16, 11, "Membantu anak mandiri toilet"),
                    CourseBenefit(17, 11, "Mengurangi stres toilet training")
                )
            ),
            Course(
                id = 12,
                name = "Mengembangkan Kreativitas Anak Usia Dini Melalui Seni",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/permisif_vidioo.mp4?raw=true",
                level = "Si kecil",
                rating = 4.7,
                categoryId = 9,
                description = "E-course ini membahas bagaimana orang tua dapat memfasilitasi ekspresi artistik anak tanpa batasan kaku (authoritarian) atau kebebasan tanpa arahan (permissive). Fokus pada pola asuh authoritative untuk mendukung imajinasi dan regulasi emosi anak melalui seni.",
                classCode = "PARENT12",
                totalModule = 5,
                totalDuration = 90,
                type = "ringkas",
                price = 140000,
                promoDiscountPercentage = 15,
                totalUser = 270,
                courseBy = "Rian Surya, M.Psi",
                createdBy = 1,
                createdAt = "2024-03-01T09:30:00Z",
                updatedAt = "2024-03-05T09:30:00Z",
                category = CourseCategory(9, "2-3 Tahun"),
                courseCreator = CourseCreator(2, "Rian Surya, M.Psi"),
                benefits = listOf(
                    CourseBenefit(18, 12, "Stimulasi kognitif lewat seni"),
                    CourseBenefit(19, 12, "Membangun kepercayaan diri anak")
                )
            ),
            Course(
                id = 13,
                name = "Strategi Efektif Mengatasi Tantrum pada Balita",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661545941394-91ce7c6f750e?q=80&w=2084&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.9,
                categoryId = 10,
                description = "Tantrum adalah bagian Umum dari perkembangan, namun cara orang tua meresponnya sangat krusial. Pelajari teknik-teknik pengasuhan authoritative untuk membimbing anak melalui emosinya, menetapkan batasan yang jelas, dan mengelola perilaku sulit dengan tenang dan penuh kasih sayang.",
                classCode = "PARENT13",
                totalModule = 8,
                totalDuration = 150,
                type = "Umum",
                price = 190000,
                promoDiscountPercentage = 20,
                totalUser = 450,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2024-02-10T08:00:00Z",
                updatedAt = "2024-02-15T08:00:00Z",
                category = CourseCategory(10, "3-4 Tahun"),
                courseCreator = CourseCreator(3, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(20, 13, "Mengelola emosi anak"),
                    CourseBenefit(21, 13, "Membangun ketahanan emosional")
                )
            ),
            Course(
                id = 14,
                name = "Membangun Kemampuan Sosial Anak Pra-Sekolah",
                imageUrl = "https://plus.unsplash.com/premium_photo-1666299721610-5853da3427ac?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoriterr.mp4?raw=true",
                level = "Si kecil",
                rating = 4.6,
                categoryId = 11,
                description = "E-course ini membimbing orang tua dalam mengembangkan keterampilan sosial anak melalui interaksi bermain dan komunikasi yang sehat. Pelajari cara mendorong empati, berbagi, dan kerjasama dengan pendekatan authoritative yang menghargai individu anak dan menetapkan batasan yang wajar.",
                classCode = "PARENT14",
                totalModule = 6,
                totalDuration = 100,
                type = "ringkas",
                price = 150000,
                promoDiscountPercentage = 10,
                totalUser = 380,
                courseBy = "Dewi Maharani",
                createdBy = 1,
                createdAt = "2024-01-05T10:00:00Z",
                updatedAt = "2024-01-10T10:00:00Z",
                category = CourseCategory(11, "4-5 Tahun"),
                courseCreator = CourseCreator(4, "Dewi Maharani"),
                benefits = listOf(
                    CourseBenefit(22, 14, "Meningkatkan interaksi sosial anak"),
                    CourseBenefit(23, 14, "Mengatasi rasa malu anak")
                )
            ),
            Course(
                id = 15,
                name = "Fondasi Literasi Awal: Membaca dan Menulis untuk Balita",
                imageUrl = "https://plus.unsplash.com/premium_vector-1724144958875-25d1dc8da246?q=80&w=2360&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.7,
                categoryId = 8,
                description = "Mengenalkan dunia membaca dan menulis sejak dini melalui permainan interaktif. Course ini membahas pendekatan authoritative yang mendorong rasa ingin tahu anak terhadap huruf dan angka, tanpa tekanan yang bisa membuat anak stres atau kehilangan minat belajar.",
                classCode = "PARENT15",
                totalModule = 9,
                totalDuration = 170,
                type = "Khusus",
                price = 200000,
                promoDiscountPercentage = 25,
                totalUser = 250,
                courseBy = "Rian Surya",
                createdBy = 1,
                createdAt = "2023-12-20T09:00:00Z",
                updatedAt = "2023-12-25T09:00:00Z",
                category = CourseCategory(8, "1-2 Tahun"),
                courseCreator = CourseCreator(2, "Rian Surya"),
                benefits = listOf(
                    CourseBenefit(24, 15, "Menumbuhkan minat baca anak"),
                    CourseBenefit(25, 15, "Mengenalkan dasar menulis")
                )
            ),
            Course(
                id = 16,
                name = "Membangun Resiliensi pada Anak Pra-Sekolah",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661517729115-4b1069692b4b?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/stress_pada_orangtua.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.8,
                categoryId = 1,
                description = "E-course ini fokus pada pengembangan ketahanan mental anak usia pra-sekolah melalui pola asuh authoritative. Orang tua akan belajar cara mendukung anak menghadapi tantangan, membangun rasa percaya diri, dan memecahkan masalah tanpa terlalu campur tangan atau terlalu permisif.",
                classCode = "PARENT16",
                totalModule = 7,
                totalDuration = 130,
                type = "Umum",
                price = 170000,
                promoDiscountPercentage = 10,
                totalUser = 300,
                courseBy = "Dr. Anatasya S.Kep",
                createdBy = 1,
                createdAt = "2023-11-01T10:00:00Z",
                updatedAt = "2023-11-05T10:00:00Z",
                category = CourseCategory(1, "Otoritatif"),
                courseCreator = CourseCreator(5, "Dr. Anatasya S.Kep"),
                benefits = listOf(
                    CourseBenefit(26, 16, "Meningkatkan ketahanan mental anak"),
                    CourseBenefit(27, 16, "Mengajarkan problem solving")
                )
            ),
            Course(
                id = 17,
                name = "Mengajarkan Batasan dan Disiplin Positif pada Anak",
                imageUrl = "https://images.unsplash.com/photo-1544776193-352d25ca82cd?q=80&w=1929&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/kekerasan_pada_anak.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.9,
                categoryId = 2,
                description = "Meskipun disiplin penting, pendekatan otoriter seringkali kontraproduktif. Course ini membahas strategi disiplin positif yang efektif, menghindari hukuman fisik, dan mendorong anak untuk memahami konsekuensi dari tindakannya, bukan hanya takut akan hukuman.",
                classCode = "PARENT17",
                totalModule = 6,
                totalDuration = 100,
                type = "ringkas",
                price = 145000,
                promoDiscountPercentage = 0,
                totalUser = 200,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2023-10-15T09:00:00Z",
                updatedAt = "2023-10-20T09:00:00Z",
                category = CourseCategory(2, "Otoriter"),
                courseCreator = CourseCreator(3, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(28, 17, "Menerapkan disiplin tanpa kekerasan"),
                    CourseBenefit(29, 17, "Membangun ketaatan anak")
                )
            ),
            Course(
                id = 18,
                name = "Langkah Mengelola Mental Ketika Mengasuh Anak",
                imageUrl = "https://plus.unsplash.com/premium_photo-1682751162797-86ae25215217?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/langkah_mengelola_mental.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.6,
                categoryId = 3,
                description = "Meskipun kebebasan bermain penting, tanpa panduan, mainan bisa jadi kurang optimal. Course ini membahas bagaimana orang tua dapat membimbing anak memilih mainan yang mendukung perkembangan kognitif dan motorik, tanpa harus terlalu membatasi atau menuntut hasil.",
                classCode = "PARENT18",
                totalModule = 4,
                totalDuration = 80,
                type = "ringkas",
                price = 120000,
                promoDiscountPercentage = 5,
                totalUser = 180,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2023-09-01T08:30:00Z",
                updatedAt = "2023-09-05T08:30:00Z",
                category = CourseCategory(3, "Permisif"),
                courseCreator = CourseCreator(3, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(30, 18, "Optimasi stimulasi anak"),
                    CourseBenefit(31, 18, "Mengurangi screen time anak")
                )
            ),
            Course(
                id = 19,
                name = "Manajemen Waktu Layar yang Sehat untuk Anak dan Remaja",
                imageUrl = "https://images.unsplash.com/photo-1581089778245-3ce67677f718?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoriterr.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.7,
                categoryId = 1,
                description = "E-course ini mengajarkan orang tua bagaimana menetapkan batasan waktu layar yang sehat dengan pendekatan authoritative. Fokus pada komunikasi terbuka, alasan di balik aturan, dan mencari alternatif aktivitas yang menarik, bukan hanya melarang atau membiarkan tanpa kontrol.",
                classCode = "PARENT19",
                totalModule = 5,
                totalDuration = 95,
                type = "ringkas",
                price = 135000,
                promoDiscountPercentage = 15,
                totalUser = 260,
                courseBy = "Budi Santoso, M.Psi",
                createdBy = 1,
                createdAt = "2023-08-20T10:00:00Z",
                updatedAt = "2023-08-25T10:00:00Z",
                category = CourseCategory(1, "Otoritatif"),
                courseCreator = CourseCreator(6, "Budi Santoso, M.Psi"),
                benefits = listOf(
                    CourseBenefit(32, 19, "Mengatur waktu gadget anak"),
                    CourseBenefit(33, 19, "Mendorong aktivitas offline")
                )
            ),
            Course(
                id = 20,
                name = "Membangun Kebiasaan Tidur Sehat untuk Anak Usia Sekolah",
                imageUrl = "https://images.unsplash.com/photo-1714646082106-188388cc2e3c?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/permisif_vidioo.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.9,
                categoryId = 1,
                description = "Tidur yang cukup sangat penting bagi perkembangan anak. Course ini mengajarkan orang tua cara membentuk rutinitas tidur yang konsisten dengan pola asuh authoritative, memberikan panduan yang jelas dan dukungan, tanpa harus otoriter atau terlalu longgar.",
                classCode = "PARENT20",
                totalModule = 8,
                totalDuration = 160,
                type = "Khusus",
                price = 220000,
                promoDiscountPercentage = 30,
                totalUser = 350,
                courseBy = "Dr. Nia, M.Psi",
                createdBy = 1,
                createdAt = "2023-07-01T11:00:00Z",
                updatedAt = "2023-07-05T11:00:00Z",
                category = CourseCategory(1, "Otoritatif"),
                courseCreator = CourseCreator(7, "Dr. Nia, M.Psi"),
                benefits = listOf(
                    CourseBenefit(34, 20, "Mengatasi masalah tidur anak"),
                    CourseBenefit(35, 20, "Membangun rutinitas sehat")
                )
            )
        )


        val filteredCourses = allCourses
            .asSequence()
            .filter { course ->
                search.isNullOrBlank() || course.name?.contains(search, ignoreCase = true) ?: false
            }
            .filter { course ->
                type.isNullOrBlank() || course.type.equals(type, ignoreCase = true)
            }

        val sortedCourses = when (sortBy) {
            "promo" -> filteredCourses.sortedByDescending { it.rating }
            "terpopular" -> filteredCourses.sortedByDescending { it.totalUser }
            "terbaru" -> filteredCourses.sortedByDescending { it.createdAt }
            else -> filteredCourses.sortedByDescending { it.createdAt }
        }

        return sortedCourses.toList()

    }

    override suspend fun getCoursesClass(
        search: String?,
        type: String?,
        category: List<Int>?,
        level: List<String>?,
        sortBy: String?
    ): List<Course> {
        val allCourses = listOf(
            Course(
                id = 1,
                name = "Mendukung Perkembangan Motorik Bayi Melalui Pendekatan Responsif",
                imageUrl = "https://images.unsplash.com/photo-1629360046014-c8c91b6c2881?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.8,
                categoryId = 4,
                description = "E-course ini mengajarkan orang tua cara mendampingi perkembangan motorik kasar bayi secara sensitif dan penuh dukungan, seperti menegakkan kepala dan tengkurap. Orang tua dengan pola asuh authoritative akan diajak berinteraksi hangat dan memberikan stimulasi yang sesuai usia, bukan menuntut kemampuan bayi secara berlebihan.",
                classCode = "PARENT01",
                totalModule = 6,
                totalDuration = 120,
                type = "Umum",
                price = 150000,
                promoDiscountPercentage = 20,
                totalUser = 340,
                courseBy = "Dr. Andini Pratama",
                createdBy = 1,
                createdAt = "2024-10-01T10:00:00Z",
                updatedAt = "2024-10-10T10:00:00Z",
                category = CourseCategory(4, "0-3 Bulan"),
                courseCreator = CourseCreator(1, "Dr. Andini Pratama"),
                benefits = listOf(
                    CourseBenefit(1, 1, "Meningkatkan bonding dengan anak"),
                    CourseBenefit(2, 1, "Mengelola emosi saat mengasuh")
                )
            ),
            Course(
                id = 2,
                name = "Membangun Kemandirian Gerak Anak dengan Dukungan Positif",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoriterr.mp4?raw=true",
                level = "Si kecil",
                rating = 4.7,
                categoryId = 5,
                description = "Melatih bayi duduk atau berdiri tidak hanya membutuhkan latihan fisik, tapi juga penguatan emosional. E-course ini membekali orang tua dengan strategi mendorong kemandirian anak melalui pola asuh yang mendorong (authoritative), bukan memaksa (authoritarian) atau membiarkan tanpa arahan (permissive).",
                classCode = "PARENT02",
                totalModule = 8,
                totalDuration = 150,
                type = "Umum",
                price = 180000,
                promoDiscountPercentage = 15,
                totalUser = 290,
                courseBy = "Rian Surya, M.Psi",
                createdBy = 1,
                createdAt = "2024-09-20T09:30:00Z",
                updatedAt = "2024-10-02T09:30:00Z",
                category = CourseCategory(5, "3-6 Bulan"),
                courseCreator = CourseCreator(2, "Rian Surya, M.Psi"),
                benefits = listOf(
                    CourseBenefit(3, 2, "Memahami emosi anak"),
                    CourseBenefit(4, 2, "Menangani tantrum dengan tepat")
                )
            ),
            Course(
                id = 3,
                name = "Langkah Bijak Menyambut Anak Belajar Berjalan",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661545941394-91ce7c6f750e?q=80&w=2084&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.5,
                categoryId = 5,
                description = "Orang tua akan belajar mengenali kesiapan anak berjalan, lalu memberikan dukungan dengan sabar dan positif. Materi ini membandingkan pendekatan memaksa (authoritarian) versus pendekatan mendorong bertahap (authoritative), dan membahas risiko jika anak dibiarkan tanpa stimulasi (permissive).",
                classCode = "PARENT03",
                totalModule = 10,
                totalDuration = 180,
                type = "khusus",
                price = 200000,
                promoDiscountPercentage = 25,
                totalUser = 220,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2024-08-15T08:00:00Z",
                updatedAt = "2024-09-10T08:00:00Z",
                category = CourseCategory(5, "3-6 Bulan"),
                courseCreator = CourseCreator(3, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(5, 3, "Menghindari konflik dengan anak remaja"),
                    CourseBenefit(6, 3, "Membangun empati dua arah")
                )
            ),
            Course(
                id = 4,
                name = "Mendorong Eksplorasi Bayi dengan Batasan yang Aman",
                imageUrl = "https://plus.unsplash.com/premium_photo-1666299721610-5853da3427ac?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/permisif_vidioo.mp4?raw=true",
                level = "Si kecil",
                rating = 4.6,
                categoryId = 6,
                description = "Stimulasi eksplorasi membantu bayi belajar gerak, tetapi tetap perlu pengawasan. Course ini mengajarkan orang tua bagaimana menerapkan pengasuhan yang suportif dan responsif (authoritative) dibanding terlalu membatasi (authoritarian) atau melepas tanpa arahan (permissive).",
                classCode = "PARENT04",
                totalModule = 7,
                totalDuration = 110,
                type = "ringkas",
                price = 130000,
                promoDiscountPercentage = 10,
                totalUser = 400,
                courseBy = "Dewi Maharani",
                createdBy = 1,
                createdAt = "2024-07-10T10:00:00Z",
                updatedAt = "2024-07-15T10:00:00Z",
                category = CourseCategory(6, "6-9 Bulan"),
                courseCreator = CourseCreator(4, "Dewi Maharani"),
                benefits = listOf(
                    CourseBenefit(7, 4, "Membentuk karakter positif"),
                    CourseBenefit(8, 4, "Mendidik dengan konsistensi")
                )
            ),
            Course(
                id = 5,
                name = "Strategi Komunikasi Awal Anak Sesuai Pola Asuh Positif",
                imageUrl = "https://plus.unsplash.com/premium_vector-1724144958875-25d1dc8da246?q=80&w=2360&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.7,
                categoryId = 7,
                description = "Mengenalkan nama benda dan merespon ucapan anak jadi awal perkembangan bahasanya. Dalam course ini, orang tua diajak memahami bagaimana komunikasi efektif berbeda dampaknya berdasarkan pola asuh yang diterapkan—baik itu responsif, kaku, atau permisif.",
                classCode = "PARENT05",
                totalModule = 5,
                totalDuration = 90,
                type = "Umum",
                price = 140000,
                promoDiscountPercentage = 15,
                totalUser = 280,
                courseBy = "Rian Surya",
                createdBy = 1,
                createdAt = "2024-07-11",
                updatedAt = "2024-07-15",
                category = CourseCategory(7, "9-12 Bulan"),
                courseCreator = CourseCreator(2, "Rian Surya"),
                benefits = listOf(
                    CourseBenefit(9, 5, "Aman berinternet"),
                    CourseBenefit(10, 5, "Membimbing anak di media sosial")
                )
            ),
            Course(
                id = 6,
                name = "Melatih Motorik Kasar Anak Lewat Bermain yang Terarah",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661517729115-4b1069692b4b?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.8,
                categoryId = 1,
                description = "Aktivitas fisik seperti mendorong dengan kaki atau bermain aktif membutuhkan dukungan orang tua. E-course ini membahas bagaimana pola asuh authoritative dapat membimbing anak berkembang aktif dan percaya diri, dibanding otoriter yang penuh larangan atau permisif yang minim arahan.",
                classCode = "PARENT06",
                totalModule = 6,
                totalDuration = 100,
                type = "Umum",
                price = 120000,
                promoDiscountPercentage = 0,
                totalUser = 190,
                courseBy = "Dr. Anatasya S.Kep",
                createdBy = 1,
                createdAt = "2024-07-01",
                updatedAt = "2024-07-05",
                category = CourseCategory(1, "Otoritatif"),
                courseCreator = CourseCreator(5, "Dr. Anatasya S.Kep"),
                benefits = listOf(
                    CourseBenefit(11, 6, "Mental health awareness")
                )
            ),
            Course(
                id = 7,
                name = "Mengembangkan Bahasa Anak Lewat Deskripsi dan Percakapan Sehari-hari",
                imageUrl = "https://images.unsplash.com/photo-1544776193-352d25ca82cd?q=80&w=1929&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoriterr.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.9,
                categoryId = 1,
                description = "Penggunaan bahasa yang kaya dan interaktif di lingkungan rumah sangat penting. Course ini mengajak orang tua melibatkan anak secara verbal sambil tetap memberi struktur (authoritative), tidak memaksa anak bicara (authoritarian), atau membiarkan anak tanpa stimulasi bahasa (permissive).",
                classCode = "PARENT07",
                totalModule = 8,
                totalDuration = 130,
                type = "Khusus",
                price = 180000,
                promoDiscountPercentage = 30,
                totalUser = 500,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2024-06-01",
                updatedAt = "2024-06-10",
                category = CourseCategory(1, "Otoritatif"),
                courseCreator = CourseCreator(3, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(12, 7, "Gentle parenting")
                )
            ),
            Course(
                id = 8,
                name = "Membangun Imajinasi dan Regulasi Emosi Anak Lewat Bermain Peran",
                imageUrl = "https://plus.unsplash.com/premium_photo-1682751162797-86ae25215217?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/permisif_vidioo.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.6,
                categoryId = 3,
                description = "Permainan menirukan hewan dapat menstimulasi kreativitas, motorik, dan ekspresi emosional. Course ini menekankan pentingnya keseimbangan antara kebebasan berekspresi (permissive)",
                classCode = "PARENT08",
                totalModule = 4,
                totalDuration = 80,
                type = "Khusus",
                price = 100000,
                promoDiscountPercentage = 0,
                totalUser = 150,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2024-05-15",
                updatedAt = "2024-05-20",
                category = CourseCategory(3, "Permisif"),
                courseCreator = CourseCreator(2, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(13, 8, "Membantu anak belajar")
                )
            ),
            Course(
                id = 9,
                name = "Mengajarkan Konsep Matematika Dasar dalam Pola Asuh Seimbang",
                imageUrl = "https://images.unsplash.com/photo-1581089778245-3ce67677f718?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoriterr.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.7,
                categoryId = 2,
                description = "Mengajarkan angka, mencocokkan, dan menghitung dapat dilakukan secara menyenangkan melalui permainan. E-course ini membantu orang tua memilih pendekatan sesuai pola asuh: struktur dan stimulasi (authoritative), tekanan berlebihan (authoritarian), atau terlalu bebas tanpa arah (permissive).",
                classCode = "PARENT09",
                totalModule = 5,
                totalDuration = 95,
                type = "Khusus",
                price = 110000,
                promoDiscountPercentage = 5,
                totalUser = 120,
                courseBy = "Budi Santoso, M.Psi",
                createdBy = 1,
                createdAt = "2024-05-01",
                updatedAt = "2024-05-05",
                category = CourseCategory(2, "Otoriter"),
                courseCreator = CourseCreator(6, "Budi Santoso, M.Psi"),
                benefits = listOf(
                    CourseBenefit(14, 9, "Peran ayah aktif")
                )
            ),
            Course(
                id = 10,
                name = "Menanamkan Konsep Ukuran dan Perbandingan Lewat Aktivitas Bermain",
                imageUrl = "https://images.unsplash.com/photo-1714646082106-188388cc2e3c?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/permisif_vidioo.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.9,
                categoryId = 3,
                description = "Anak belajar konsep besar-kecil dan berat-ringan lewat eksperimen sederhana. Course ini membimbing orang tua untuk mendorong rasa ingin tahu anak secara aktif namun terarah (authoritative), bukan menekan hasil (authoritarian) atau membiarkan anak tanpa bimbingan (permissive).",
                classCode = "PARENT10",
                totalModule = 9,
                totalDuration = 160,
                type = "Khusus",
                price = 210000,
                promoDiscountPercentage = 40,
                totalUser = 100,
                courseBy = "Dr. Nia, M.Psi",
                createdBy = 1,
                createdAt = "2024-04-10",
                updatedAt = "2024-04-15",
                category = CourseCategory(3, "Permisif"),
                courseCreator = CourseCreator(7, "Dr. Nia, M.Psi"),
                benefits = listOf(
                    CourseBenefit(15, 10, "Pendampingan ABK")
                )
            ), Course(
                id = 11,
                name = "Kunci Sukses Toilet Training dengan Pendekatan Positif",
                imageUrl = "https://images.unsplash.com/photo-1629360046014-c8c91b6c2881?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.8,
                categoryId = 8,
                description = "E-course ini membimbing orang tua melalui proses toilet training dengan sabar, menerapkan pola asuh authoritative yang fokus pada dukungan dan penguatan positif, bukan paksaan atau tekanan berlebihan. Pelajari cara mengenali kesiapan anak dan menghadapi tantangan dengan empati.",
                classCode = "PARENT11",
                totalModule = 7,
                totalDuration = 110, // Umum
                type = "Umum",
                price = 160000,
                promoDiscountPercentage = 10,
                totalUser = 310,
                courseBy = "Dr. Andini Pratama",
                createdBy = 1,
                createdAt = "2024-03-20T10:00:00Z",
                updatedAt = "2024-03-25T10:00:00Z",
                category = CourseCategory(8, "1-2 Tahun"),
                courseCreator = CourseCreator(1, "Dr. Andini Pratama"),
                benefits = listOf(
                    CourseBenefit(16, 11, "Membantu anak mandiri toilet"),
                    CourseBenefit(17, 11, "Mengurangi stres toilet training")
                )
            ),
            Course(
                id = 12,
                name = "Mengembangkan Kreativitas Anak Usia Dini Melalui Seni",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/permisif_vidioo.mp4?raw=true",
                level = "Si kecil",
                rating = 4.7,
                categoryId = 9,
                description = "E-course ini membahas bagaimana orang tua dapat memfasilitasi ekspresi artistik anak tanpa batasan kaku (authoritarian) atau kebebasan tanpa arahan (permissive). Fokus pada pola asuh authoritative untuk mendukung imajinasi dan regulasi emosi anak melalui seni.",
                classCode = "PARENT12",
                totalModule = 5,
                totalDuration = 90,
                type = "ringkas",
                price = 140000,
                promoDiscountPercentage = 15,
                totalUser = 270,
                courseBy = "Rian Surya, M.Psi",
                createdBy = 1,
                createdAt = "2024-03-01T09:30:00Z",
                updatedAt = "2024-03-05T09:30:00Z",
                category = CourseCategory(9, "2-3 Tahun"),
                courseCreator = CourseCreator(2, "Rian Surya, M.Psi"),
                benefits = listOf(
                    CourseBenefit(18, 12, "Stimulasi kognitif lewat seni"),
                    CourseBenefit(19, 12, "Membangun kepercayaan diri anak")
                )
            ),
            Course(
                id = 13,
                name = "Strategi Efektif Mengatasi Tantrum pada Balita",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661545941394-91ce7c6f750e?q=80&w=2084&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.9,
                categoryId = 10,
                description = "Tantrum adalah bagian Umum dari perkembangan, namun cara orang tua meresponnya sangat krusial. Pelajari teknik-teknik pengasuhan authoritative untuk membimbing anak melalui emosinya, menetapkan batasan yang jelas, dan mengelola perilaku sulit dengan tenang dan penuh kasih sayang.",
                classCode = "PARENT13",
                totalModule = 8,
                totalDuration = 150,
                type = "Umum",
                price = 190000,
                promoDiscountPercentage = 20,
                totalUser = 450,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2024-02-10T08:00:00Z",
                updatedAt = "2024-02-15T08:00:00Z",
                category = CourseCategory(10, "3-4 Tahun"),
                courseCreator = CourseCreator(3, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(20, 13, "Mengelola emosi anak"),
                    CourseBenefit(21, 13, "Membangun ketahanan emosional")
                )
            ),
            Course(
                id = 14,
                name = "Membangun Kemampuan Sosial Anak Pra-Sekolah",
                imageUrl = "https://plus.unsplash.com/premium_photo-1666299721610-5853da3427ac?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoriterr.mp4?raw=true",
                level = "Si kecil",
                rating = 4.6,
                categoryId = 11,
                description = "E-course ini membimbing orang tua dalam mengembangkan keterampilan sosial anak melalui interaksi bermain dan komunikasi yang sehat. Pelajari cara mendorong empati, berbagi, dan kerjasama dengan pendekatan authoritative yang menghargai individu anak dan menetapkan batasan yang wajar.",
                classCode = "PARENT14",
                totalModule = 6,
                totalDuration = 100,
                type = "ringkas",
                price = 150000,
                promoDiscountPercentage = 10,
                totalUser = 380,
                courseBy = "Dewi Maharani",
                createdBy = 1,
                createdAt = "2024-01-05T10:00:00Z",
                updatedAt = "2024-01-10T10:00:00Z",
                category = CourseCategory(11, "4-5 Tahun"),
                courseCreator = CourseCreator(4, "Dewi Maharani"),
                benefits = listOf(
                    CourseBenefit(22, 14, "Meningkatkan interaksi sosial anak"),
                    CourseBenefit(23, 14, "Mengatasi rasa malu anak")
                )
            ),
            Course(
                id = 15,
                name = "Fondasi Literasi Awal: Membaca dan Menulis untuk Balita",
                imageUrl = "https://plus.unsplash.com/premium_vector-1724144958875-25d1dc8da246?q=80&w=2360&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoritatifff.mp4?raw=true",
                level = "Si kecil",
                rating = 4.7,
                categoryId = 8,
                description = "Mengenalkan dunia membaca dan menulis sejak dini melalui permainan interaktif. Course ini membahas pendekatan authoritative yang mendorong rasa ingin tahu anak terhadap huruf dan angka, tanpa tekanan yang bisa membuat anak stres atau kehilangan minat belajar.",
                classCode = "PARENT15",
                totalModule = 9,
                totalDuration = 170,
                type = "Khusus",
                price = 200000,
                promoDiscountPercentage = 25,
                totalUser = 250,
                courseBy = "Rian Surya",
                createdBy = 1,
                createdAt = "2023-12-20T09:00:00Z",
                updatedAt = "2023-12-25T09:00:00Z",
                category = CourseCategory(8, "1-2 Tahun"),
                courseCreator = CourseCreator(2, "Rian Surya"),
                benefits = listOf(
                    CourseBenefit(24, 15, "Menumbuhkan minat baca anak"),
                    CourseBenefit(25, 15, "Mengenalkan dasar menulis")
                )
            ),
            Course(
                id = 16,
                name = "Membangun Resiliensi pada Anak Pra-Sekolah",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661517729115-4b1069692b4b?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/stress_pada_orangtua.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.8,
                categoryId = 1,
                description = "E-course ini fokus pada pengembangan ketahanan mental anak usia pra-sekolah melalui pola asuh authoritative. Orang tua akan belajar cara mendukung anak menghadapi tantangan, membangun rasa percaya diri, dan memecahkan masalah tanpa terlalu campur tangan atau terlalu permisif.",
                classCode = "PARENT16",
                totalModule = 7,
                totalDuration = 130,
                type = "Umum",
                price = 170000,
                promoDiscountPercentage = 10,
                totalUser = 300,
                courseBy = "Dr. Anatasya S.Kep",
                createdBy = 1,
                createdAt = "2023-11-01T10:00:00Z",
                updatedAt = "2023-11-05T10:00:00Z",
                category = CourseCategory(1, "Otoritatif"),
                courseCreator = CourseCreator(5, "Dr. Anatasya S.Kep"),
                benefits = listOf(
                    CourseBenefit(26, 16, "Meningkatkan ketahanan mental anak"),
                    CourseBenefit(27, 16, "Mengajarkan problem solving")
                )
            ),
            Course(
                id = 17,
                name = "Mengajarkan Batasan dan Disiplin Positif pada Anak",
                imageUrl = "https://images.unsplash.com/photo-1544776193-352d25ca82cd?q=80&w=1929&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/kekerasan_pada_anak.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.9,
                categoryId = 2,
                description = "Meskipun disiplin penting, pendekatan otoriter seringkali kontraproduktif. Course ini membahas strategi disiplin positif yang efektif, menghindari hukuman fisik, dan mendorong anak untuk memahami konsekuensi dari tindakannya, bukan hanya takut akan hukuman.",
                classCode = "PARENT17",
                totalModule = 6,
                totalDuration = 100,
                type = "ringkas",
                price = 145000,
                promoDiscountPercentage = 0,
                totalUser = 200,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2023-10-15T09:00:00Z",
                updatedAt = "2023-10-20T09:00:00Z",
                category = CourseCategory(2, "Otoriter"),
                courseCreator = CourseCreator(3, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(28, 17, "Menerapkan disiplin tanpa kekerasan"),
                    CourseBenefit(29, 17, "Membangun ketaatan anak")
                )
            ),
            Course(
                id = 18,
                name = "Langkah Mengelola Mental Ketika Mengasuh Anak",
                imageUrl = "https://plus.unsplash.com/premium_photo-1682751162797-86ae25215217?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/langkah_mengelola_mental.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.6,
                categoryId = 3,
                description = "Meskipun kebebasan bermain penting, tanpa panduan, mainan bisa jadi kurang optimal. Course ini membahas bagaimana orang tua dapat membimbing anak memilih mainan yang mendukung perkembangan kognitif dan motorik, tanpa harus terlalu membatasi atau menuntut hasil.",
                classCode = "PARENT18",
                totalModule = 4,
                totalDuration = 80,
                type = "ringkas",
                price = 120000,
                promoDiscountPercentage = 5,
                totalUser = 180,
                courseBy = "Mahadewi Zahra, M.Psi",
                createdBy = 1,
                createdAt = "2023-09-01T08:30:00Z",
                updatedAt = "2023-09-05T08:30:00Z",
                category = CourseCategory(3, "Permisif"),
                courseCreator = CourseCreator(3, "Mahadewi Zahra, M.Psi"),
                benefits = listOf(
                    CourseBenefit(30, 18, "Optimasi stimulasi anak"),
                    CourseBenefit(31, 18, "Mengurangi screen time anak")
                )
            ),
            Course(
                id = 19,
                name = "Manajemen Waktu Layar yang Sehat untuk Anak dan Remaja",
                imageUrl = "https://images.unsplash.com/photo-1581089778245-3ce67677f718?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/vidio_otoriterr.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.7,
                categoryId = 1,
                description = "E-course ini mengajarkan orang tua bagaimana menetapkan batasan waktu layar yang sehat dengan pendekatan authoritative. Fokus pada komunikasi terbuka, alasan di balik aturan, dan mencari alternatif aktivitas yang menarik, bukan hanya melarang atau membiarkan tanpa kontrol.",
                classCode = "PARENT19",
                totalModule = 5,
                totalDuration = 95,
                type = "ringkas",
                price = 135000,
                promoDiscountPercentage = 15,
                totalUser = 260,
                courseBy = "Budi Santoso, M.Psi",
                createdBy = 1,
                createdAt = "2023-08-20T10:00:00Z",
                updatedAt = "2023-08-25T10:00:00Z",
                category = CourseCategory(1, "Otoritatif"),
                courseCreator = CourseCreator(6, "Budi Santoso, M.Psi"),
                benefits = listOf(
                    CourseBenefit(32, 19, "Mengatur waktu gadget anak"),
                    CourseBenefit(33, 19, "Mendorong aktivitas offline")
                )
            ),
            Course(
                id = 20,
                name = "Membangun Kebiasaan Tidur Sehat untuk Anak Usia Sekolah",
                imageUrl = "https://images.unsplash.com/photo-1714646082106-188388cc2e3c?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/permisif_vidioo.mp4?raw=true",
                level = "Orang Tua",
                rating = 4.9,
                categoryId = 1,
                description = "Tidur yang cukup sangat penting bagi perkembangan anak. Course ini mengajarkan orang tua cara membentuk rutinitas tidur yang konsisten dengan pola asuh authoritative, memberikan panduan yang jelas dan dukungan, tanpa harus otoriter atau terlalu longgar.",
                classCode = "PARENT20",
                totalModule = 8,
                totalDuration = 160,
                type = "Khusus",
                price = 220000,
                promoDiscountPercentage = 30,
                totalUser = 350,
                courseBy = "Dr. Nia, M.Psi",
                createdBy = 1,
                createdAt = "2023-07-01T11:00:00Z",
                updatedAt = "2023-07-05T11:00:00Z",
                category = CourseCategory(1, "Otoritatif"),
                courseCreator = CourseCreator(7, "Dr. Nia, M.Psi"),
                benefits = listOf(
                    CourseBenefit(34, 20, "Mengatasi masalah tidur anak"),
                    CourseBenefit(35, 20, "Membangun rutinitas sehat")
                )
            )
        )


        val filteredCourses = allCourses
            .asSequence()
            .filter { course ->
                search.isNullOrBlank() || course.name?.contains(search, ignoreCase = true) ?: false
            }
            .filter { course ->
                type.isNullOrBlank() || course.type.equals(type, ignoreCase = true)
            }
            .filter { course ->
                category.isNullOrEmpty() || category.contains(course.categoryId)
            }
            .filter { course ->
                level.isNullOrEmpty() || level.any { it.equals(course.level, ignoreCase = true) }
            }

        val sortedCourses = when (sortBy) {
            "rating" -> filteredCourses.sortedByDescending { it.rating }
            "terpopular" -> filteredCourses.sortedByDescending { it.totalUser }
            "terbaru" -> filteredCourses.sortedByDescending { it.createdAt }
            else -> filteredCourses.sortedByDescending { it.createdAt }
        }

        return sortedCourses.toList()
    }
}
