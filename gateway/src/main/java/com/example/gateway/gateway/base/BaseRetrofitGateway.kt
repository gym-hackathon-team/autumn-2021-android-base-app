package com.example.gateway.gateway.base

import io.reactivex.Completable
import io.reactivex.Single
import com.example.domain.entities.BaseEntity
import com.example.gateway.entities.mappers.base.BaseRetrofitMapper
import com.example.gateway.entities.retrofit.base.BaseRetrofitModel

open class BaseRetrofitGateway<R: BaseRetrofitModel, E: BaseEntity>(
    private val mapper: BaseRetrofitMapper<R, E>
) {

    /**
     * Функция, которая маппит модель Retrofit в сущность бизнес-логики
     * @param block Блок кода, в который мы прокидываем полученную модель
     * @return Объект типа Single
     */
    fun withMapper(block: () -> Single<R>): Single<E> {
        val retrofitModel = block().blockingGet()
        return Single.just(mapper.map(retrofitModel))
    }

    /**
     * Функция, которая маппит сущность в модель для Retrofit
     * @param entity Сущсность, которая будет маппиться
     * @param block Блок кода, в который мы прокидываем полученную модель
     */
    fun withMapper(entity: E, block: (R) -> Completable) = Completable.fromAction {
        val retrofitModel = mapper.map(entity)
        block(retrofitModel)
    }
}