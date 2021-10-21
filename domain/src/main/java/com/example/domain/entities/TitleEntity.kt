package com.example.domain.entities

data class TitleEntity(
    val romaji: String?,
    val english: String?,
    val native: String?,
    val userPreferred: String?
): BaseEntity