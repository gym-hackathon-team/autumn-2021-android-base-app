package com.example.domain.entities

data class AuthEntity(
    val refreshToken: String,
    val accessToken: String
): BaseEntity