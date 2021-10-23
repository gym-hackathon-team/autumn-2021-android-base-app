package com.example.gateway.gateway.transactions

import com.example.gateway.entities.retrofit.response.TransactionResponse
import io.reactivex.Single
import retrofit2.http.Header
import retrofit2.http.POST

interface TransactionsApi {

    @POST("/request/createTransaction")
    fun makeTransaction(
        @Header("cardId") cardId: String,
        @Header("toCard") toCard: String,
        @Header("amount") amount: Float
    ): Single<TransactionResponse>

    @POST("/request/createPayment")
    fun makePayment(
        @Header("cardId") cardId: String,
        @Header("toAccount") toAccount: String,
        @Header("amount") amount: Float
    ): Single<TransactionResponse>
}