package com.thesis.tuladhaapp.model.firebase

import com.google.firebase.auth.FirebaseUser

data class User(
    val id: String,
    val fullName: String,
    val email: String,
    val uri: String
)

fun FirebaseUser?.toUser() =
    this?.let {
        User(
            id = this.uid,
            fullName = this.displayName.orEmpty(),
            email = this.email.orEmpty(),
            uri = this.photoUrl.toString()
        )
    }
