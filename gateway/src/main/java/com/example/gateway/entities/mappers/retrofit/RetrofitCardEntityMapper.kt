package com.example.gateway.entities.mappers.retrofit

import com.example.domain.entities.CardEntity
import com.example.gateway.entities.mappers.base.BaseRetrofitMapper
import com.example.gateway.entities.retrofit.response.CardResponse

object RetrofitCardEntityMapper : BaseRetrofitMapper<CardResponse, CardEntity> {

    override fun map(retrofitModel: CardResponse): CardEntity {
        return CardEntity(
            id = retrofitModel.id,
            number = retrofitModel.number,
            balance = retrofitModel.balance,
            accountId = retrofitModel.accountId
        )
    }

    override fun map(entity: CardEntity): CardResponse {
        return CardResponse(
            id = entity.id,
            number = entity.number,
            balance = entity.balance,
            accountId = entity.accountId
        )
    }
}