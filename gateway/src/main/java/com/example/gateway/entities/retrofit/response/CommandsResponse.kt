package com.example.gateway.entities.retrofit.response

import com.example.gateway.entities.retrofit.base.BaseRetrofitModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CommandsResponse(
    val decision: Boolean,
    val voiceCommand: String
) : BaseRetrofitModel