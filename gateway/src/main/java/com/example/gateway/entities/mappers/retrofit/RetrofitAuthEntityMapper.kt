package com.example.gateway.entities.mappers.retrofit

import com.example.domain.entities.AuthEntity
import com.example.gateway.entities.mappers.base.BaseRetrofitMapper
import com.example.gateway.entities.retrofit.response.AuthResponse

internal object RetrofitAuthEntityMapper: BaseRetrofitMapper<AuthResponse, AuthEntity> {

    override fun map(retrofitModel: AuthResponse): AuthEntity {
        return AuthEntity(
            token = retrofitModel.token,
            userId = retrofitModel.userId
        )
    }

    override fun map(entity: AuthEntity): AuthResponse {
        return AuthResponse(
            token = entity.token,
            userId = entity.userId
        )
    }
}