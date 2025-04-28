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
        return listOf(
            Course(
                id = 1,
                name = "Mengasuh Anak Usia Dini dengan Cinta",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/Screen_Recording_20250120_084726.mp4?raw=true",
                level = "beginner",
                rating = 4.8,
                categoryId = 1,
                description = "Pelajari pendekatan pengasuhan berbasis kasih sayang dan empati.",
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
                name = "Psikologi Anak untuk Orang Tua",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                level = "intermediate",
                rating = 4.7,
                categoryId = 5,
                description = "Pahami tahapan psikologis anak untuk mendampingi tumbuh kembangnya.",
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
                category = CourseCategory(5, "2 - 3 Tahun"),
                courseCreator = CourseCreator(2, "Rian Surya, M.Psi"),
                benefits = listOf(
                    CourseBenefit(3, 2, "Memahami emosi anak"),
                    CourseBenefit(4, 2, "Menangani tantrum dengan tepat")
                )
            ),
            Course(
                id = 3,
                name = "Komunikasi Efektif dengan Anak Remaja",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "advanced",
                rating = 4.5,
                categoryId = 1,
                description = "Strategi komunikasi yang membangun kepercayaan dan keterbukaan.",
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
                category = CourseCategory(1, "Authoritative"),
                courseCreator = CourseCreator(3, "Tula"),
                benefits = listOf(
                    CourseBenefit(5, 3, "Menghindari konflik dengan anak remaja"),
                    CourseBenefit(6, 3, "Membangun empati dua arah")
                )
            ),
            Course(
                id = 4,
                name = "Membentuk Karakter Anak Sejak Dini",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "beginner",
                rating = 4.6,
                categoryId = 6,
                description = "Teknik mendidik nilai dan moral pada anak usia dini.",
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
                category = CourseCategory(6, "4 - 5 Tahun"),
                courseCreator = CourseCreator(4, "Dewi Maharani"),
                benefits = listOf(
                    CourseBenefit(7, 4, "Membentuk karakter positif"),
                    CourseBenefit(8, 4, "Mendidik dengan konsistensi")
                )
            ),
            Course(
                id = 5,
                name = "Parenting Digital untuk Anak Zaman Now",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "intermediate",
                rating = 4.7,
                categoryId = 1,
                description = "Tips parenting di era digital",
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
                name = "Menyiapkan Mental Ibu Baru",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "beginner",
                rating = 4.8,
                categoryId = 4,
                description = "Dukungan mental untuk ibu baru",
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
                category = CourseCategory(4, "0 - 1 Tahun"),
                courseCreator = CourseCreator(5, "Dr. Ana"),
                benefits = listOf(
                    CourseBenefit(11, 6, "Mental health awareness")
                )
            ),
            Course(
                id = 7,
                name = "Pengasuhan Anak Tanpa Kekerasan",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "intermediate",
                rating = 4.9,
                categoryId = 1,
                description = "Praktik positif tanpa kekerasan",
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
                courseCreator = CourseCreator(3, "Tula"),
                benefits = listOf(
                    CourseBenefit(12, 7, "Gentle parenting")
                )
            ),
            Course(
                id = 8,
                name = "Mengenali Gaya Belajar Anak",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "beginner",
                rating = 4.6,
                categoryId = 6,
                description = "Optimalkan pembelajaran anak",
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
                category = CourseCategory(6, "4 - 5 Tahun"),
                courseCreator = CourseCreator(2, "Rian Surya"),
                benefits = listOf(
                    CourseBenefit(13, 8, "Membantu anak belajar")
                )
            ),
            Course(
                id = 9,
                name = "Ayah dalam Pengasuhan",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "beginner",
                rating = 4.7,
                categoryId = 2,
                description = "Peran ayah dalam tumbuh kembang",
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
                name = "Mendampingi Anak Berkebutuhan Khusus",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "advanced",
                rating = 4.9,
                categoryId = 3,
                description = "Strategi pengasuhan ABK",
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
                name = "Mengasuh Anak Usia Dini dengan Cinta",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = "https://github.com/riansyah251641/tuladhaAsset/blob/main/categoryAssets/Screen_Recording_20250120_084726.mp4?raw=true",
                level = "beginner",
                rating = 4.8,
                categoryId = 1,
                description = "Pelajari pendekatan pengasuhan berbasis kasih sayang dan empati.",
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
                name = "Psikologi Anak untuk Orang Tua",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                level = "intermediate",
                rating = 4.7,
                categoryId = 5,
                description = "Pahami tahapan psikologis anak untuk mendampingi tumbuh kembangnya.",
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
                category = CourseCategory(5, "2 - 3 Tahun"),
                courseCreator = CourseCreator(2, "Rian Surya, M.Psi"),
                benefits = listOf(
                    CourseBenefit(3, 2, "Memahami emosi anak"),
                    CourseBenefit(4, 2, "Menangani tantrum dengan tepat")
                )
            ),
            Course(
                id = 3,
                name = "Komunikasi Efektif dengan Anak Remaja",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "advanced",
                rating = 4.5,
                categoryId = 1,
                description = "Strategi komunikasi yang membangun kepercayaan dan keterbukaan.",
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
                category = CourseCategory(1, "Authoritative"),
                courseCreator = CourseCreator(3, "Tula"),
                benefits = listOf(
                    CourseBenefit(5, 3, "Menghindari konflik dengan anak remaja"),
                    CourseBenefit(6, 3, "Membangun empati dua arah")
                )
            ),
            Course(
                id = 4,
                name = "Membentuk Karakter Anak Sejak Dini",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "beginner",
                rating = 4.6,
                categoryId = 6,
                description = "Teknik mendidik nilai dan moral pada anak usia dini.",
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
                category = CourseCategory(6, "4 - 5 Tahun"),
                courseCreator = CourseCreator(4, "Dewi Maharani"),
                benefits = listOf(
                    CourseBenefit(7, 4, "Membentuk karakter positif"),
                    CourseBenefit(8, 4, "Mendidik dengan konsistensi")
                )
            ),
            Course(
                id = 5,
                name = "Parenting Digital untuk Anak Zaman Now",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "intermediate",
                rating = 4.7,
                categoryId = 1,
                description = "Tips parenting di era digital",
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
                name = "Menyiapkan Mental Ibu Baru",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "beginner",
                rating = 4.8,
                categoryId = 4,
                description = "Dukungan mental untuk ibu baru",
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
                category = CourseCategory(4, "0 - 1 Tahun"),
                courseCreator = CourseCreator(5, "Dr. Ana"),
                benefits = listOf(
                    CourseBenefit(11, 6, "Mental health awareness")
                )
            ),
            Course(
                id = 7,
                name = "Pengasuhan Anak Tanpa Kekerasan",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "intermediate",
                rating = 4.9,
                categoryId = 1,
                description = "Praktik positif tanpa kekerasan",
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
                courseCreator = CourseCreator(3, "Tula"),
                benefits = listOf(
                    CourseBenefit(12, 7, "Gentle parenting")
                )
            ),
            Course(
                id = 8,
                name = "Mengenali Gaya Belajar Anak",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "beginner",
                rating = 4.6,
                categoryId = 6,
                description = "Optimalkan pembelajaran anak",
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
                category = CourseCategory(6, "4 - 5 Tahun"),
                courseCreator = CourseCreator(2, "Rian Surya"),
                benefits = listOf(
                    CourseBenefit(13, 8, "Membantu anak belajar")
                )
            ),
            Course(
                id = 9,
                name = "Ayah dalam Pengasuhan",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "beginner",
                rating = 4.7,
                categoryId = 2,
                description = "Peran ayah dalam tumbuh kembang",
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
                name = "Mendampingi Anak Berkebutuhan Khusus",
                imageUrl = "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                videoPreviewUrl = null,
                level = "advanced",
                rating = 4.9,
                categoryId = 3,
                description = "Strategi pengasuhan ABK",
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
            "promo" -> filteredCourses.sortedByDescending { it.rating }
            "terpopular" -> filteredCourses.sortedByDescending { it.totalUser }
            "terbaru" -> filteredCourses.sortedByDescending { it.createdAt }
            else -> filteredCourses.sortedByDescending { it.createdAt }
        }

        return sortedCourses.toList()
    }
}
