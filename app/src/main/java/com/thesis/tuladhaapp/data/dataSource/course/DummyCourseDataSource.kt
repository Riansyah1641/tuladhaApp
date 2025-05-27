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
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/Screen_Recording_20250120_084726.mp4?raw=true",
                level = "0-3 Bulan",
                rating = 4.8,
                categoryId = 1,
                description = "E-course ini mengajarkan orang tua cara mendampingi perkembangan motorik kasar bayi secara sensitif dan penuh dukungan, seperti menegakkan kepala dan tengkurap. Orang tua dengan pola asuh authoritative akan diajak berinteraksi hangat dan memberikan stimulasi yang sesuai usia, bukan menuntut kemampuan bayi secara berlebihan.",
                classCode = "PARENT01",
                totalModule = 6,
                totalDuration = 120,
                type = "gratis",
                price = 150000,
                promoDiscountPercentage = 20,
                totalUser = 340,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-10-01T10:00:00Z",
                updatedAt = "2024-10-10T10:00:00Z",
                category = CourseCategory(1, "Authoritative"),
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
                videoPreviewUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                level = "3-6 Bulan",
                rating = 4.7,
                categoryId = 5,
                description = "Melatih bayi duduk atau berdiri tidak hanya membutuhkan latihan fisik, tapi juga penguatan emosional. E-course ini membekali orang tua dengan strategi mendorong kemandirian anak melalui pola asuh yang mendorong (authoritative), bukan memaksa (authoritarian) atau membiarkan tanpa arahan (permissive).",
                classCode = "PARENT02",
                totalModule = 8,
                totalDuration = 150,
                type = "premium",
                price = 180000,
                promoDiscountPercentage = 15,
                totalUser = 290,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-09-20T09:30:00Z",
                updatedAt = "2024-10-02T09:30:00Z",
                category = CourseCategory(1, "Authoritative"),
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
                videoPreviewUrl = null,
                level = "3-6 Bulan",
                rating = 4.5,
                categoryId = 1,
                description = "Orang tua akan belajar mengenali kesiapan anak berjalan, lalu memberikan dukungan dengan sabar dan positif. Materi ini membandingkan pendekatan memaksa (authoritarian) versus pendekatan mendorong bertahap (authoritative), dan membahas risiko jika anak dibiarkan tanpa stimulasi (permissive).",
                classCode = "PARENT03",
                totalModule = 10,
                totalDuration = 180,
                type = "premium",
                price = 200000,
                promoDiscountPercentage = 25,
                totalUser = 220,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-08-15T08:00:00Z",
                updatedAt = "2024-09-10T08:00:00Z",
                category = CourseCategory(2, "Authoritarian"),
                courseCreator = CourseCreator(3, "Tuladha Parenting"),
                benefits = listOf(
                    CourseBenefit(5, 3, "Menghindari konflik dengan anak remaja"),
                    CourseBenefit(6, 3, "Membangun empati dua arah")
                )
            ),
            Course(
                id = 4,
                name = "Mendorong Eksplorasi Bayi dengan Batasan yang Aman",
                imageUrl = "https://plus.unsplash.com/premium_photo-1666299721610-5853da3427ac?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = null,
                level = "6-9 Bulan",
                rating = 4.6,
                categoryId = 6,
                description = "Stimulasi eksplorasi membantu bayi belajar gerak, tetapi tetap perlu pengawasan. Course ini mengajarkan orang tua bagaimana menerapkan pengasuhan yang suportif dan responsif (authoritative) dibanding terlalu membatasi (authoritarian) atau melepas tanpa arahan (permissive).",
                classCode = "PARENT04",
                totalModule = 7,
                totalDuration = 110,
                type = "gratis",
                price = 130000,
                promoDiscountPercentage = 10,
                totalUser = 400,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-07-10T10:00:00Z",
                updatedAt = "2024-07-15T10:00:00Z",
                category = CourseCategory(2, "Authoritarian"),
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
                videoPreviewUrl = null,
                level = "9-12 Bulan",
                rating = 4.7,
                categoryId = 1,
                description = "Mengenalkan nama benda dan merespon ucapan anak jadi awal perkembangan bahasanya. Dalam course ini, orang tua diajak memahami bagaimana komunikasi efektif berbeda dampaknya berdasarkan pola asuh yang diterapkan—baik itu responsif, kaku, atau permisif.",
                classCode = "PARENT05",
                totalModule = 5,
                totalDuration = 90,
                type = "gratis",
                price = 140000,
                promoDiscountPercentage = 15,
                totalUser = 280,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-07-11",
                updatedAt = "2024-07-15",
                category = CourseCategory(1, "Authoritative"),
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
                videoPreviewUrl = null,
                level = "1-2 Tahun",
                rating = 4.8,
                categoryId = 4,
                description = "Aktivitas fisik seperti mendorong dengan kaki atau bermain aktif membutuhkan dukungan orang tua. E-course ini membahas bagaimana pola asuh authoritative dapat membimbing anak berkembang aktif dan percaya diri, dibanding otoriter yang penuh larangan atau permisif yang minim arahan.",
                classCode = "PARENT06",
                totalModule = 6,
                totalDuration = 100,
                type = "premium",
                price = 120000,
                promoDiscountPercentage = 0,
                totalUser = 190,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-07-01",
                updatedAt = "2024-07-05",
                category = CourseCategory(2, "Authoritarian"),
                courseCreator = CourseCreator(5, "Dr. Ana"),
                benefits = listOf(
                    CourseBenefit(11, 6, "Mental health awareness")
                )
            ),
            Course(
                id = 7,
                name = "Mengembangkan Bahasa Anak Lewat Deskripsi dan Percakapan Sehari-hari",
                imageUrl = "https://images.unsplash.com/photo-1544776193-352d25ca82cd?q=80&w=1929&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = null,
                level = "1-2 Tahun",
                rating = 4.9,
                categoryId = 1,
                description = "Penggunaan bahasa yang kaya dan interaktif di lingkungan rumah sangat penting. Course ini mengajak orang tua melibatkan anak secara verbal sambil tetap memberi struktur (authoritative), tidak memaksa anak bicara (authoritarian), atau membiarkan anak tanpa stimulasi bahasa (permissive).",
                classCode = "PARENT07",
                totalModule = 8,
                totalDuration = 130,
                type = "gratis",
                price = 180000,
                promoDiscountPercentage = 30,
                totalUser = 500,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-06-01",
                updatedAt = "2024-06-10",
                category = CourseCategory(1, "Authoritative"),
                courseCreator = CourseCreator(3, "Tuladha Parenting"),
                benefits = listOf(
                    CourseBenefit(12, 7, "Gentle parenting")
                )
            ),
            Course(
                id = 8,
                name = "Membangun Imajinasi dan Regulasi Emosi Anak Lewat Bermain Peran",
                imageUrl = "https://plus.unsplash.com/premium_photo-1682751162797-86ae25215217?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = null,
                level = "2-3 Tahun",
                rating = 4.6,
                categoryId = 6,
                description = "Permainan menirukan hewan dapat menstimulasi kreativitas, motorik, dan ekspresi emosional. Course ini menekankan pentingnya keseimbangan antara kebebasan berekspresi (permissive) dan batasan aman (authoritative), serta menghindari penekanan yang berlebihan (authoritarian).",
                classCode = "PARENT08",
                totalModule = 4,
                totalDuration = 80,
                type = "premium",
                price = 100000,
                promoDiscountPercentage = 0,
                totalUser = 150,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-05-15",
                updatedAt = "2024-05-20",
                category = CourseCategory(3, "Permissive"),
                courseCreator = CourseCreator(2, "Rian Surya"),
                benefits = listOf(
                    CourseBenefit(13, 8, "Membantu anak belajar")
                )
            ),
            Course(
                id = 9,
                name = "Mengajarkan Konsep Matematika Dasar dalam Pola Asuh Seimbang",
                imageUrl = "https://images.unsplash.com/photo-1581089778245-3ce67677f718?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = null,
                level = "3-4 Tahun",
                rating = 4.7,
                categoryId = 2,
                description = "Mengajarkan angka, mencocokkan, dan menghitung dapat dilakukan secara menyenangkan melalui permainan. E-course ini membantu orang tua memilih pendekatan sesuai pola asuh: struktur dan stimulasi (authoritative), tekanan berlebihan (authoritarian), atau terlalu bebas tanpa arah (permissive).",
                classCode = "PARENT09",
                totalModule = 5,
                totalDuration = 95,
                type = "premium",
                price = 110000,
                promoDiscountPercentage = 5,
                totalUser = 120,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-05-01",
                updatedAt = "2024-05-05",
                category = CourseCategory(2, "Authoritarian"),
                courseCreator = CourseCreator(6, "Budi Santoso"),
                benefits = listOf(
                    CourseBenefit(14, 9, "Peran ayah aktif")
                )
            ),
            Course(
                id = 10,
                name = "Menanamkan Konsep Ukuran dan Perbandingan Lewat Aktivitas Bermain",
                imageUrl = "https://images.unsplash.com/photo-1714646082106-188388cc2e3c?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = null,
                level = "4-5 Tahun",
                rating = 4.9,
                categoryId = 3,
                description = "Anak belajar konsep besar-kecil dan berat-ringan lewat eksperimen sederhana. Course ini membimbing orang tua untuk mendorong rasa ingin tahu anak secara aktif namun terarah (authoritative), bukan menekan hasil (authoritarian) atau membiarkan anak tanpa bimbingan (permissive).",
                classCode = "PARENT10",
                totalModule = 9,
                totalDuration = 160,
                type = "gratis",
                price = 210000,
                promoDiscountPercentage = 40,
                totalUser = 100,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-04-10",
                updatedAt = "2024-04-15",
                category = CourseCategory(3, "Permissive"),
                courseCreator = CourseCreator(7, "Dr. Nia"),
                benefits = listOf(
                    CourseBenefit(15, 10, "Pendampingan ABK")
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
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/Screen_Recording_20250120_084726.mp4?raw=true",
                level = "0-3 Bulan",
                rating = 4.8,
                categoryId = 1,
                description = "E-course ini mengajarkan orang tua cara mendampingi perkembangan motorik kasar bayi secara sensitif dan penuh dukungan, seperti menegakkan kepala dan tengkurap. Orang tua dengan pola asuh authoritative akan diajak berinteraksi hangat dan memberikan stimulasi yang sesuai usia, bukan menuntut kemampuan bayi secara berlebihan.",
                classCode = "PARENT01",
                totalModule = 6,
                totalDuration = 120,
                type = "gratis",
                price = 150000,
                promoDiscountPercentage = 20,
                totalUser = 340,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-10-01T10:00:00Z",
                updatedAt = "2024-10-10T10:00:00Z",
                category = CourseCategory(1, "Authoritative"),
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
                videoPreviewUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                level = "3-6 Bulan",
                rating = 4.7,
                categoryId = 5,
                description = "Melatih bayi duduk atau berdiri tidak hanya membutuhkan latihan fisik, tapi juga penguatan emosional. E-course ini membekali orang tua dengan strategi mendorong kemandirian anak melalui pola asuh yang mendorong (authoritative), bukan memaksa (authoritarian) atau membiarkan tanpa arahan (permissive).",
                classCode = "PARENT02",
                totalModule = 8,
                totalDuration = 150,
                type = "premium",
                price = 180000,
                promoDiscountPercentage = 15,
                totalUser = 290,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-09-20T09:30:00Z",
                updatedAt = "2024-10-02T09:30:00Z",
                category = CourseCategory(1, "Authoritative"),
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
                videoPreviewUrl = null,
                level = "3-6 Bulan",
                rating = 4.5,
                categoryId = 1,
                description = "Orang tua akan belajar mengenali kesiapan anak berjalan, lalu memberikan dukungan dengan sabar dan positif. Materi ini membandingkan pendekatan memaksa (authoritarian) versus pendekatan mendorong bertahap (authoritative), dan membahas risiko jika anak dibiarkan tanpa stimulasi (permissive).",
                classCode = "PARENT03",
                totalModule = 10,
                totalDuration = 180,
                type = "premium",
                price = 200000,
                promoDiscountPercentage = 25,
                totalUser = 220,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-08-15T08:00:00Z",
                updatedAt = "2024-09-10T08:00:00Z",
                category = CourseCategory(2, "Authoritarian"),
                courseCreator = CourseCreator(3, "Tuladha Parenting"),
                benefits = listOf(
                    CourseBenefit(5, 3, "Menghindari konflik dengan anak remaja"),
                    CourseBenefit(6, 3, "Membangun empati dua arah")
                )
            ),
            Course(
                id = 4,
                name = "Mendorong Eksplorasi Bayi dengan Batasan yang Aman",
                imageUrl = "https://plus.unsplash.com/premium_photo-1666299721610-5853da3427ac?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = null,
                level = "6-9 Bulan",
                rating = 4.6,
                categoryId = 6,
                description = "Stimulasi eksplorasi membantu bayi belajar gerak, tetapi tetap perlu pengawasan. Course ini mengajarkan orang tua bagaimana menerapkan pengasuhan yang suportif dan responsif (authoritative) dibanding terlalu membatasi (authoritarian) atau melepas tanpa arahan (permissive).",
                classCode = "PARENT04",
                totalModule = 7,
                totalDuration = 110,
                type = "gratis",
                price = 130000,
                promoDiscountPercentage = 10,
                totalUser = 400,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-07-10T10:00:00Z",
                updatedAt = "2024-07-15T10:00:00Z",
                category = CourseCategory(2, "Authoritarian"),
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
                videoPreviewUrl = null,
                level = "9-12 Bulan",
                rating = 4.7,
                categoryId = 1,
                description = "Mengenalkan nama benda dan merespon ucapan anak jadi awal perkembangan bahasanya. Dalam course ini, orang tua diajak memahami bagaimana komunikasi efektif berbeda dampaknya berdasarkan pola asuh yang diterapkan—baik itu responsif, kaku, atau permisif.",
                classCode = "PARENT05",
                totalModule = 5,
                totalDuration = 90,
                type = "gratis",
                price = 140000,
                promoDiscountPercentage = 15,
                totalUser = 280,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-07-11",
                updatedAt = "2024-07-15",
                category = CourseCategory(1, "Authoritative"),
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
                videoPreviewUrl = null,
                level = "1-2 Tahun",
                rating = 4.8,
                categoryId = 4,
                description = "Aktivitas fisik seperti mendorong dengan kaki atau bermain aktif membutuhkan dukungan orang tua. E-course ini membahas bagaimana pola asuh authoritative dapat membimbing anak berkembang aktif dan percaya diri, dibanding otoriter yang penuh larangan atau permisif yang minim arahan.",
                classCode = "PARENT06",
                totalModule = 6,
                totalDuration = 100,
                type = "premium",
                price = 120000,
                promoDiscountPercentage = 0,
                totalUser = 190,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-07-01",
                updatedAt = "2024-07-05",
                category = CourseCategory(2, "Authoritarian"),
                courseCreator = CourseCreator(5, "Dr. Ana"),
                benefits = listOf(
                    CourseBenefit(11, 6, "Mental health awareness")
                )
            ),
            Course(
                id = 7,
                name = "Mengembangkan Bahasa Anak Lewat Deskripsi dan Percakapan Sehari-hari",
                imageUrl = "https://images.unsplash.com/photo-1544776193-352d25ca82cd?q=80&w=1929&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = null,
                level = "1-2 Tahun",
                rating = 4.9,
                categoryId = 1,
                description = "Penggunaan bahasa yang kaya dan interaktif di lingkungan rumah sangat penting. Course ini mengajak orang tua melibatkan anak secara verbal sambil tetap memberi struktur (authoritative), tidak memaksa anak bicara (authoritarian), atau membiarkan anak tanpa stimulasi bahasa (permissive).",
                classCode = "PARENT07",
                totalModule = 8,
                totalDuration = 130,
                type = "gratis",
                price = 180000,
                promoDiscountPercentage = 30,
                totalUser = 500,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-06-01",
                updatedAt = "2024-06-10",
                category = CourseCategory(1, "Authoritative"),
                courseCreator = CourseCreator(3, "Tuladha Parenting"),
                benefits = listOf(
                    CourseBenefit(12, 7, "Gentle parenting")
                )
            ),
            Course(
                id = 8,
                name = "Membangun Imajinasi dan Regulasi Emosi Anak Lewat Bermain Peran",
                imageUrl = "https://plus.unsplash.com/premium_photo-1682751162797-86ae25215217?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = null,
                level = "2-3 Tahun",
                rating = 4.6,
                categoryId = 6,
                description = "Permainan menirukan hewan dapat menstimulasi kreativitas, motorik, dan ekspresi emosional. Course ini menekankan pentingnya keseimbangan antara kebebasan berekspresi (permissive) dan batasan aman (authoritative), serta menghindari penekanan yang berlebihan (authoritarian).",
                classCode = "PARENT08",
                totalModule = 4,
                totalDuration = 80,
                type = "premium",
                price = 100000,
                promoDiscountPercentage = 0,
                totalUser = 150,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-05-15",
                updatedAt = "2024-05-20",
                category = CourseCategory(3, "Permissive"),
                courseCreator = CourseCreator(2, "Rian Surya"),
                benefits = listOf(
                    CourseBenefit(13, 8, "Membantu anak belajar")
                )
            ),
            Course(
                id = 9,
                name = "Mengajarkan Konsep Matematika Dasar dalam Pola Asuh Seimbang",
                imageUrl = "https://images.unsplash.com/photo-1581089778245-3ce67677f718?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = null,
                level = "3-4 Tahun",
                rating = 4.7,
                categoryId = 2,
                description = "Mengajarkan angka, mencocokkan, dan menghitung dapat dilakukan secara menyenangkan melalui permainan. E-course ini membantu orang tua memilih pendekatan sesuai pola asuh: struktur dan stimulasi (authoritative), tekanan berlebihan (authoritarian), atau terlalu bebas tanpa arah (permissive).",
                classCode = "PARENT09",
                totalModule = 5,
                totalDuration = 95,
                type = "premium",
                price = 110000,
                promoDiscountPercentage = 5,
                totalUser = 120,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-05-01",
                updatedAt = "2024-05-05",
                category = CourseCategory(2, "Authoritarian"),
                courseCreator = CourseCreator(6, "Budi Santoso"),
                benefits = listOf(
                    CourseBenefit(14, 9, "Peran ayah aktif")
                )
            ),
            Course(
                id = 10,
                name = "Menanamkan Konsep Ukuran dan Perbandingan Lewat Aktivitas Bermain",
                imageUrl = "https://images.unsplash.com/photo-1714646082106-188388cc2e3c?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                videoPreviewUrl = null,
                level = "4-5 Tahun",
                rating = 4.9,
                categoryId = 3,
                description = "Anak belajar konsep besar-kecil dan berat-ringan lewat eksperimen sederhana. Course ini membimbing orang tua untuk mendorong rasa ingin tahu anak secara aktif namun terarah (authoritative), bukan menekan hasil (authoritarian) atau membiarkan anak tanpa bimbingan (permissive).",
                classCode = "PARENT10",
                totalModule = 9,
                totalDuration = 160,
                type = "gratis",
                price = 210000,
                promoDiscountPercentage = 40,
                totalUser = 100,
                courseBy = "Tuladha",
                createdBy = 1,
                createdAt = "2024-04-10",
                updatedAt = "2024-04-15",
                category = CourseCategory(3, "Permissive"),
                courseCreator = CourseCreator(7, "Dr. Nia"),
                benefits = listOf(
                    CourseBenefit(15, 10, "Pendampingan ABK")
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
