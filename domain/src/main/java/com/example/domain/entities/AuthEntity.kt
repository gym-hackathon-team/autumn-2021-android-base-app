package com.example.domain.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthEntity(
    @Json(name="refresh_token")
    val refreshToken: String,
    @Json(name="access_token")
    val accessToken: String
): BaseEntity