package com.example.gateway.gateway.base

import com.apollographql.apollo.api.Response
import com.example.domain.entities.BaseEntity
import com.example.gateway.entities.mappers.base.BaseApolloMapper
import io.reactivex.Observable


open class BaseApolloGateway<A, E: BaseEntity>(
    private val mapper: BaseApolloMapper<A, E>
) {

    fun withMapper(block: () -> Observable<Response<A>>): Observable<E> {
        val apolloModel = block().blockingFirst().data!!
        return Observable.just(mapper.map(apolloModel))
    }
}