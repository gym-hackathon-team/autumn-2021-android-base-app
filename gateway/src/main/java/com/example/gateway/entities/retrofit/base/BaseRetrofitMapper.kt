package com.example.gateway.entities.retrofit.base

import com.example.domain.entities.BaseEntity
import com.example.gateway.entities.BaseMapper


interface BaseRetrofitMapper<R: BaseRetrofitModel, E: BaseEntity> : BaseMapper<R, E> {

    fun map(retrofitModel: R): E
    fun map(entity: E): R
}