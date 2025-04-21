package com.thesis.tuladhaapp.data.dataSource.user

import com.group2.sinow.model.profile.ProfileAuth
import com.group2.sinow.model.profile.ProfileData


class DataSourceUsersImpl(): DataSourceUsers {
    override suspend fun getUserData(): ProfileData {
        return ProfileData(
            id = 1,
            name = "Rian Surya",
            photoProfileUrl = "https://example.com/photo.jpg",
            country = "Indonesia",
            city = "Surabaya",
            role = "user",
            createdAt = "2024-01-01T10:00:00Z",
            updatedAt = "2024-04-01T10:00:00Z",
            auth = ProfileAuth(
                id = 101,
                email = "rian@example.com",
                phoneNumber = "+6281234567890",
                password = "encryptedPassword123",
                userId = 1,
                isEmailVerified = true,
                createdAt = "2024-01-01T10:00:00Z",
                updatedAt = "2024-04-01T10:00:00Z"
            )
        )
    }



}