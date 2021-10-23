package com.example.domain.entities

data class CardEntity(
    val id: String,
    val balance: Float,
    val accountId: String,
    val number: String
): BaseEntity