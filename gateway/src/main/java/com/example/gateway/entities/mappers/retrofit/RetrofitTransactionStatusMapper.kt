package com.example.gateway.entities.mappers.retrofit

import com.example.domain.entities.TransactionStatusEntity
import com.example.gateway.entities.mappers.base.BaseRetrofitMapper
import com.example.gateway.entities.retrofit.response.TransactionResponse

object RetrofitTransactionStatusMapper: BaseRetrofitMapper<TransactionResponse, TransactionStatusEntity> {

    override fun map(retrofitModel: TransactionResponse): TransactionStatusEntity {
        return TransactionStatusEntity(
            status = retrofitModel.status
        )
    }

    override fun map(entity: TransactionStatusEntity): TransactionResponse {
        return TransactionResponse(
            status = entity.status
        )
    }
}