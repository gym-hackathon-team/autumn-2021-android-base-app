package com.example.gateway.gateway.auth

import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.example.gateway.ApiConstants.GRANT_TYPE_PASSWORD
import com.example.gateway.BuildConfig
import com.example.gateway.entities.retrofit.response.AuthResponse

interface AuthApi {

    @FormUrlEncoded
    @POST("/oauth/v2/token")
    fun auth(
        @Field("grant_type") grantType: String = GRANT_TYPE_PASSWORD,
        @Field("client_id") clientId: String = BuildConfig.CLIENT_ID,
        @Field("client_secret") clientSecret: String = BuildConfig.CLIENT_SECRET,
        @Field("username") username: String,
        @Field("password") password: String
    ): Single<AuthResponse>

    @FormUrlEncoded
    @POST("/oauth/v2/token")
    fun auth(
        @Field("grant_type") grantType: String = GRANT_TYPE_PASSWORD,
        @Field("client_id") clientId: String = BuildConfig.CLIENT_ID,
        @Field("client_secret") clientSecret: String = BuildConfig.CLIENT_SECRET,
        @Field("refresh_token") refreshToken: String
    ): Single<AuthResponse>
}