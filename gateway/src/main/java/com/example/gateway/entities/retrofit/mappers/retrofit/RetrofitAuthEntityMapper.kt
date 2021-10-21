package com.example.gateway.entities.retrofit.mappers.retrofit

import com.example.domain.entities.AuthEntity
import com.example.gateway.entities.retrofit.base.BaseRetrofitMapper
import com.example.gateway.entities.retrofit.response.AuthResponse

internal object RetrofitAuthEntityMapper: BaseRetrofitMapper<AuthResponse, AuthEntity> {

    override fun map(retrofitModel: AuthResponse): AuthEntity {
        return AuthEntity(
            refreshToken = retrofitModel.refreshToken,
            accessToken = retrofitModel.accessToken
        )
    }

    override fun map(entity: AuthEntity): AuthResponse {
        return AuthResponse(
            refreshToken = entity.refreshToken,
            accessToken = entity.accessToken
        )
    }
}