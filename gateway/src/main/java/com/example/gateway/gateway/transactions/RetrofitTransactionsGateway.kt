package com.example.gateway.gateway.transactions

import com.example.domain.entities.TransactionStatusEntity
import com.example.domain.gateway.transactions.TransactionsGateway
import com.example.gateway.entities.mappers.retrofit.RetrofitTransactionStatusMapper
import com.example.gateway.entities.retrofit.response.TransactionResponse
import com.example.gateway.gateway.base.BaseRetrofitGateway
import javax.inject.Inject

class RetrofitTransactionsGateway @Inject constructor(
    private val transactionsApi: TransactionsApi
) : BaseRetrofitGateway<TransactionResponse, TransactionStatusEntity>(
    RetrofitTransactionStatusMapper
), TransactionsGateway {

    override fun makeTransaction(cardId: String, toCardId: String, amount: Float) = withMapper {
        transactionsApi.makeTransaction(
            cardId = cardId,
            toCard = toCardId,
            amount = amount
        )
    }

    override fun makePayment(cardId: String, accountId: String, amount: Float) = withMapper {
        transactionsApi.makePayment(
            cardId = cardId,
            toAccount = accountId,
            amount = amount
        )
    }
}