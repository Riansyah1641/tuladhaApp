package com.thesis.tuladhaapp.data.dataSource.assesmentCourse

import com.thesis.tuladhaapp.model.kuis.Assesment

class DummyAssesmentCourse() : AssesmentCourseDataSource {
    private val assesments = listOf(
        Assesment(
            1,
            "Latihan Menegakkan Kepala pada Bayi",
            "Gendonglah bayi dalam posisi tegak menghadap ke depan sambil berjalan-jalan di sekitar rumah. Tunjukkan atau arahkan perhatian bayi pada benda-benda yang menarik. Aktivitas ini membantu bayi melihat sekelilingnya dan sekaligus melatih otot lehernya agar mampu menahan kepala tetap tegak."
        ),
        Assesment(
            2,
            " Melatih Kemampuan Duduk pada Bayi",
            "Bantu bayi belajar duduk secara mandiri. Awalnya, posisikan bayi di kursi yang memiliki sandaran untuk mencegahnya jatuh ke belakang. Saat bayi dalam posisi duduk, berikan mainan kecil di tangannya untuk merangsang perhatian. Bila bayi belum bisa duduk tegak sendiri, topang tubuhnya. Namun jika sudah mampu duduk tegak, dudukkan bayi di lantai beralas selimut tanpa sandaran atau penyangga agar kemampuan duduknya semakin terasah."
        ),
        Assesment(
            3,
            "Melatih Bayi Berjalan dengan Berpegangan",
            "Setelah bayi mampu berdiri, letakkan mainan favoritnya di depannya dalam jarak yang tidak terlalu jauh. Ajak bayi berjalan sambil berpegangan pada ranjang atau perabot rumah tangga untuk meraih mainan tersebut. Anda juga bisa membantu dengan memegang kedua tangannya dan mengajaknya melangkah agar lebih percaya diri dalam belajar berjalan."
        ), Assesment(
            4,
            "Memberikan bayi kesempatan untuk meraih mainan dan mengeksplor lingkungan sekitarnya",
            "Letakkan sebuah mainan sedikit di luar jangkauan bayi. Gerak-gerakkan mainan itu di depan bayi sambil bicara kepadanya agar ia berusaha untuk mendapatkan mainan itu. Jangan terlalu lama membiarkan bayi berusaha meraih mainan tersebut agar ia merasa berhasil."
        ),
        Assesment(
            5,
            "Melatih Anak Mengenal Nama-Nama Benda di Sekitar",
            "Selain mengenalkan bagian tubuh, ajak anak menyebutkan nama-nama benda yang terlihat saat sedang bepergian. Tanggapi dan kembangkan kata-kata yang anak coba ucapkan atau tunjukkan. Misalnya, jika anak menunjuk truk dan berkata \"T\" atau \"Truk\", responlah dengan, \"Ya, itu truk berwarna biru yang besar,\" untuk memperkaya kosakatanya."
        ),
        Assesment(
            6,
            " Melatih Anak Mendorong dengan Kaki",
            "Letakkan anak dalam posisi duduk di atas mainan roda atau benda yang bisa didorong, seperti mobil-mobilan atau kursi kecil yang aman. Ajak anak untuk mendorong dirinya maju dengan menggunakan kedua kakinya. Anda bisa memberi contoh terlebih dahulu atau memegang tangan anak untuk memberi semangat. Aktivitas ini membantu memperkuat otot kaki, melatih keseimbangan, dan mengembangkan koordinasi motorik kasar."
        ),
        Assesment(
            7,
            "Melatih Anak Menyebutkan Nama, Sifat, Guna, dan Keadaan Suatu Benda",
            "Ajak anak menyebutkan nama-nama benda yang dikenalnya melalui gambar atau benda nyata. Saat berbicara dengan anak, gunakan kalimat yang menggambarkan sifat, kegunaan, atau posisi benda tersebut. Contohnya: “Pakai kemeja yang merah”, “Bolamu yang kuning ada di bawah meja”, atau “Mobil-mobilan yang biru itu ada di dalam laci”. Aktivitas ini membantu anak memahami konsep deskriptif dan memperluas kemampuan berbahasanya."
        ), Assesment(
            8,
            "Mengajak Anak Menirukan Hewan",
            "Tunjukkan pada anak bagaimana hewan berjalan, misalnya anjing yang berjalan dengan kedua tangan dan kaki. Anda juga bisa mengajak anak ke kebun binatang dan menirukan gerakan-gerakan hewan yang dilihat, seperti cara berjalan gajah, melompat seperti katak, atau mengepakkan tangan seperti burung. Aktivitas ini bermanfaat untuk melatih imajinasi, motorik kasar, serta kemampuan observasi anak."
        ), Assesment(
            9,
            "Mengenalkan angka, konsep hitung, dan mencocokkan",
            "Ajak anak menyebutkan nama-nama benda yang dikenalnya melalui gambar atau benda nyata. Saat berbicara dengan anak, gunakan kalimat yang menggambarkan sifat, kegunaan, atau posisi benda tersebut. Contohnya: “Pakai kemeja yang merah”, “Bolamu yang kuning ada di bawah meja”, atau “Mobil-mobilan yang biru itu ada di dalam laci”. Aktivitas ini membantu anak memahami konsep deskriptif dan memperluas kemampuan berbahasanya."
        ), Assesment(
            10,
            "Mengenalkan konsep besar-kecil, panjang-pendek, banyak-sedikit, berat-ringan",
            "Ajak anak bermain mengelompokkan benda, menyusun 3 buah piring berbeda ukuran atau 3 gelas diisi air dengan isi tidak sama. Minta anak menyusun piring atau gelas tersebut dari yang ukuran kecil ke besar, jumlah sedikit ke banyak, atau dari ringan ke berat. Bila anak dapat menyusun ketiga benda itu, tambah jumlahnya menjadi 4 atau lebih."
        )
    )

    override fun getAssesmentById(id: Int): Assesment? {
        return assesments.find { it.id == id }
    }
}