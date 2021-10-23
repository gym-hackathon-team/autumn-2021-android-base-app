package com.example.gateway.gateway.auth

import com.example.gateway.entities.retrofit.response.AuthResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("/auth/user/login")
    fun auth(
        @Field("email") username: String,
        @Field("password") password: String
    ): Single<AuthResponse>
}