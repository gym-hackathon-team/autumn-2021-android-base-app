package com.example.domain.gateway.transactions

import com.example.domain.entities.TransactionStatusEntity
import io.reactivex.Single

interface TransactionsGateway {

    fun makeTransaction(
        cardId: String,
        toCardId: String,
        amount: Float
    ): Single<TransactionStatusEntity>

    fun makePayment(
        cardId: String,
        accountId: String,
        amount: Float
    ): Single<TransactionStatusEntity>
}