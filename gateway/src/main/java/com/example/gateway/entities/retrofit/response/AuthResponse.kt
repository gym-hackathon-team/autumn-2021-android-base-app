package com.example.gateway.entities.retrofit.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.example.gateway.entities.retrofit.base.BaseRetrofitModel

@JsonClass(generateAdapter = true)
data class AuthResponse(
    @Json(name="refresh_token")
    val refreshToken: String,
    @Json(name="access_token")
    val accessToken: String
) : BaseRetrofitModel