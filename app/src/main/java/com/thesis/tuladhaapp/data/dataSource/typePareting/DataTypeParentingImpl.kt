package com.thesis.tuladhaapp.data.dataSource.typePareting

import com.thesis.tuladhaapp.model.testpolaasuh.TypeParenting

class DataTypeParentingImpl : DataSourceTypeParenting {

    private val typeParenting = listOf<TypeParenting>(
        TypeParenting(
            1, "authoritative",
            "Pola asuh ini menekankan komunikasi terbuka, aturan yang jelas, dan dukungan emosional. Orang tua memberikan bimbingan sambil tetap menghargai pendapat dan kebutuhan anak."
        ),
        TypeParenting(
            2, "authoritarian",
            "Pola asuh ini berfokus pada kepatuhan dan kontrol tinggi. Orang tua menuntut disiplin ketat, namun kurang melibatkan anak dalam pengambilan keputusan dan menunjukkan kehangatan emosional."
        ),
        TypeParenting(
            3, "permissive",
            "Pola asuh ini memberikan kebebasan hampir tanpa batas. Orang tua cenderung menghindari aturan tegas dan jarang memberikan konsekuensi atas perilaku anak."
        ), TypeParenting(
            4, "Tidak Diketahui",
            "Maaf, terdapat tipe pola asuh yang memiliki nilai uji yang sama, silahkan untuk melakukan tes pola asuh ulang, untuk memastikan tipe pola asuh yang cocok dengan diri anda"
        )
    )

    override suspend fun getTypeParenting(id: Int): TypeParenting {
        return typeParenting.first { it.id == id }
    }
}
