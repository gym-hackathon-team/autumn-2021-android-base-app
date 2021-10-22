package com.example.gateway.entities.mappers.base

import com.example.domain.entities.BaseEntity

interface BaseApolloMapper<A, E: BaseEntity> : BaseMapper<A, E> {

    fun map(apolloModel: A): E
}