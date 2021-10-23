package com.example.gateway.entities.retrofit.response

import com.example.gateway.entities.retrofit.base.BaseRetrofitModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CardResponse(
    val id: String,
    val balance: Float,
    val accountId: String,
    val number: String
): BaseRetrofitModel