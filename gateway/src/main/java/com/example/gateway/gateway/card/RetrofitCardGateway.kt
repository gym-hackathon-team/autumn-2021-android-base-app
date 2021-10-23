package com.example.gateway.gateway.card

import com.example.domain.entities.CardEntity
import com.example.domain.gateway.card.CardGateway
import com.example.gateway.entities.mappers.retrofit.RetrofitCardEntityMapper
import io.reactivex.Single
import javax.inject.Inject

class RetrofitCardGateway @Inject constructor(
    private val cardApi: CardApi
): CardGateway {

    override fun getUserCards(): Single<List<CardEntity>> {
        val call = cardApi.getUserCards()
        return call.flatMap {
            val cardEntities = it.map { RetrofitCardEntityMapper.map(it) }
            Single.just(cardEntities)
        }
    }
}