package com.example.gateway.gateway.auth

import com.example.gateway.entities.retrofit.response.AuthResponse
import io.reactivex.Single
import retrofit2.http.*

interface AuthApi {

    @Headers("Content-Type: application/json")
    @POST("auth/user/login")
    fun auth(
        @Body body: Map<String, String>
    ): Single<AuthResponse>
}