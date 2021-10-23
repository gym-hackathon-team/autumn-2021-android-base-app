package com.example.domain.entities

data class AuthEntity(
    val token: String,
    val userId: String
): BaseEntity