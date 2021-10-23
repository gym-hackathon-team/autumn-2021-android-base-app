package com.example.gateway.entities.retrofit.response

import com.example.gateway.entities.retrofit.base.BaseRetrofitModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthResponse(
    val token: String,
    val userId: String
) : BaseRetrofitModel