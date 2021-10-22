package com.example.gateway.gateway.auth

import com.example.domain.entities.AuthEntity
import com.example.domain.gateway.auth.AuthGateway
import com.example.gateway.entities.mappers.retrofit.RetrofitAuthEntityMapper
import com.example.gateway.entities.retrofit.response.AuthResponse
import com.example.gateway.gateway.base.BaseRetrofitGateway
import javax.inject.Inject

class RetrofitAuthGateway @Inject constructor(
    private val api: AuthApi
): BaseRetrofitGateway<AuthResponse, AuthEntity>(RetrofitAuthEntityMapper), AuthGateway {

    override fun auth(username: String, password: String) = withMapper {
        api.auth(
            clientId = "",
            clientSecret = "",
            username = username,
            password = password
        )
    }

    override fun auth(refreshToken: String) = withMapper {
        api.auth(
            clientId = "",
            clientSecret = "",
            refreshToken = refreshToken
        )
    }
}