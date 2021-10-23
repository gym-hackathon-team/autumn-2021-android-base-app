package com.example.gateway.gateway.card

import com.example.gateway.entities.retrofit.response.CardResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CardApi {

    @GET("/request/cards")
    fun getUserCards(): Single<List<CardResponse>>
}