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
                videoPreviewUrl = null,
                level = "Beginner",
                rating = 4.8,
                categoryId = 5,
                description = "Pelajari pendekatan pengasuhan berbasis kasih sayang dan empati.",
                classCode = "PARENT01",
                totalModule = 6,
                totalDuration = 120,
                type = "Video",
                price = 150000,
                promoDiscountPercentage = 20,
                totalUser = 340,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-10-01T10:00:00Z",
                updatedAt = "2024-10-10T10:00:00Z",
                category = CourseCategory(5, "Parenting"),
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
                videoPreviewUrl = null,
                level = "Intermediate",
                rating = 4.7,
                categoryId = 5,
                description = "Pahami tahapan psikologis anak untuk mendampingi tumbuh kembangnya.",
                classCode = "PARENT02",
                totalModule = 8,
                totalDuration = 150,
                type = "Video",
                price = 180000,
                promoDiscountPercentage = 15,
                totalUser = 290,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-09-20T09:30:00Z",
                updatedAt = "2024-10-02T09:30:00Z",
                category = CourseCategory(5, "Parenting"),
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
                level = "Advanced",
                rating = 4.5,
                categoryId = 5,
                description = "Strategi komunikasi yang membangun kepercayaan dan keterbukaan.",
                classCode = "PARENT03",
                totalModule = 10,
                totalDuration = 180,
                type = "Video",
                price = 200000,
                promoDiscountPercentage = 25,
                totalUser = 220,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-08-15T08:00:00Z",
                updatedAt = "2024-09-10T08:00:00Z",
                category = CourseCategory(5, "Parenting"),
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
                level = "Beginner",
                rating = 4.6,
                categoryId = 5,
                description = "Teknik mendidik nilai dan moral pada anak usia dini.",
                classCode = "PARENT04",
                totalModule = 7,
                totalDuration = 110,
                type = "Video",
                price = 130000,
                promoDiscountPercentage = 10,
                totalUser = 400,
                courseBy = "Tuladha Parenting",
                createdBy = 1,
                createdAt = "2024-07-10T10:00:00Z",
                updatedAt = "2024-07-15T10:00:00Z",
                category = CourseCategory(5, "Parenting"),
                courseCreator = CourseCreator(4, "Dewi Maharani"),
                benefits = listOf(
                    CourseBenefit(7, 4, "Membentuk karakter positif"),
                    CourseBenefit(8, 4, "Mendidik dengan konsistensi")
                )
            ),
            Course(
                5,
                "Parenting Digital untuk Anak Zaman Now",
                "https://images.unsplash.com/photo-1607746882042-944635dfe10ea",
                null,
                "Intermediate",
                4.7,
                5,
                "Tips parenting di era digital",
                "PARENT05",
                5,
                90,
                "Video",
                140000,
                15,
                280,
                "Tuladha",
                1,
                "2024-07-11",
                "2024-07-15",
                CourseCategory(5, "Parenting"),
                CourseCreator(2, "Rian Surya"),
                listOf(
                    CourseBenefit(9, 5, "Aman berinternet"),
                    CourseBenefit(10, 5, "Membimbing anak di media sosial")
                )
            ),
            Course(
                6,
                "Menyiapkan Mental Ibu Baru",
                "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                null,
                "Beginner",
                4.8,
                5,
                "Dukungan mental untuk ibu baru",
                "PARENT06",
                6,
                100,
                "Video",
                120000,
                0,
                190,
                "Tuladha",
                1,
                "2024-07-01",
                "2024-07-05",
                CourseCategory(5, "Parenting"),
                CourseCreator(5, "Dr. Ana"),
                listOf(
                    CourseBenefit(11, 6, "Mental health awareness")
                )
            ),
            Course(
                7,
                "Pengasuhan Anak Tanpa Kekerasan",
                "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                null,
                "Intermediate",
                4.9,
                5,
                "Praktik positif tanpa kekerasan",
                "PARENT07",
                8,
                130,
                "Video",
                180000,
                30,
                500,
                "Tuladha",
                1,
                "2024-06-01",
                "2024-06-10",
                CourseCategory(5, "Parenting"),
                CourseCreator(3, "Tula"),
                listOf(
                    CourseBenefit(12, 7, "Gentle parenting")
                )
            ),
            Course(
                8,
                "Mengenali Gaya Belajar Anak",
                "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                null,
                "Beginner",
                4.6,
                5,
                "Optimalkan pembelajaran anak",
                "PARENT08",
                4,
                80,
                "Video",
                100000,
                0,
                150,
                "Tuladha",
                1,
                "2024-05-15",
                "2024-05-20",
                CourseCategory(5, "Parenting"),
                CourseCreator(2, "Rian Surya"),
                listOf(
                    CourseBenefit(13, 8, "Membantu anak belajar")
                )
            ),
            Course(
                9,
                "Ayah dalam Pengasuhan",
                "https://images.unsplash.com/photo-1607746882042-944635dfe10e",
                null,
                "Beginner",
                4.7,
                5,
                "Peran ayah dalam tumbuh kembang",
                "PARENT09",
                5,
                95,
                "Video",
                110000,
                5,
                120,
                "Tuladha",
                1,
                "2024-05-01",
                "2024-05-05",
                CourseCategory(5, "Parenting"),
                CourseCreator(6, "Budi Santoso"),
                listOf(
                    CourseBenefit(14, 9, "Peran ayah aktif")
                )
            ),
            Course(
                10,
                "Mendampingi Anak Berkebutuhan Khusus",
                "https://images.unsplash.com/photo-1607746882042-944635dfe10ea",
                null,
                "Advanced",
                4.9,
                5,
                "Strategi pengasuhan ABK",
                "PARENT10",
                9,
                160,
                "Video",
                210000,
                40,
                100,
                "Tuladha",
                1,
                "2024-04-10",
                "2024-04-15",
                CourseCategory(5, "Parenting"),
                CourseCreator(7, "Dr. Nia"),
                listOf(
                    CourseBenefit(15, 10, "Pendampingan ABK")
                )
            )
        )
    }
}
