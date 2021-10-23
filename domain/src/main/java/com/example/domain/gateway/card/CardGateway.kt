package com.example.domain.gateway.card

import com.example.domain.entities.CardEntity
import io.reactivex.Single

interface CardGateway {

    fun getUserCards(): Single<List<CardEntity>>
}