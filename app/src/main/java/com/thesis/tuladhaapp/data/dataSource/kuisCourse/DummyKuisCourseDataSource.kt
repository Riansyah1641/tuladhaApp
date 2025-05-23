package com.thesis.tuladhaapp.data.dataSource.kuisCourse

import com.thesis.tuladhaapp.model.kuis.Quiz

class DummyKuisCourseDataSource : kuisCourseDataSource {

    private val quizMap: Map<Int, List<Quiz>> = mapOf(
        1 to listOf(
            Quiz(1, "Apa warna langit saat cerah?", "Merah", "Hijau", "Kuning", "Biru", "Biru"),
            Quiz(2, "Air itu...", "Bening", "Hitam", "Merah", "Hijau", "Bening"),
            Quiz(3, "Matahari terbit dari arah?", "Barat", "Selatan", "Timur", "Utara", "Timur")
        ),
        2 to listOf(
            Quiz(4, "1 + 1 = ?", "1", "2", "3", "4", "2"),
            Quiz(5, "5 - 2 = ?", "2", "3", "4", "5", "3"),
            Quiz(6, "3 x 2 = ?", "4", "5", "6", "7", "6")
        ),
        3 to listOf(
            Quiz(7, "Ibu kota Jepang?", "Tokyo", "Osaka", "Kyoto", "Nagoya", "Tokyo"),
            Quiz(8, "Bendera Indonesia berwarna?", "Merah Putih", "Merah Hijau", "Putih Biru", "Biru Kuning", "Merah Putih"),
            Quiz(9, "Hari kemerdekaan Indonesia?", "1 Januari", "17 Agustus", "10 November", "21 April", "17 Agustus")
        )
    )

    override fun getAllQuizzes(): Map<Int, List<Quiz>> = quizMap

    override fun getQuizById(id: Int): List<Quiz> = quizMap[id] ?: emptyList()
}