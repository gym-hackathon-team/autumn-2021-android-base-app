package com.example.gateway.entities.retrofit.base

import com.example.domain.entities.BaseEntity
import com.example.gateway.entities.BaseMapper

interface BaseApolloMapper<A, E: BaseEntity> : BaseMapper<A, E> {

    fun map(apolloModel: A): E
}