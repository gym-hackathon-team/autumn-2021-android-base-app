package com.example.gateway.gateway.commands

import com.example.gateway.entities.retrofit.response.CommandsResponse
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface CommandsApi {

    @Multipart
    @POST("/request/voiceCommand")
    fun uploadFile(
        @Part upload_file: MultipartBody.Part,
    ): Single<CommandsResponse>
}