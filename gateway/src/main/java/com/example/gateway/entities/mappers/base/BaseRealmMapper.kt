package com.example.gateway.entities.mappers.base

import io.realm.RealmObject
import com.example.domain.entities.BaseEntity


interface BaseRealmMapper<R: RealmObject, E: BaseEntity> : BaseMapper<R, E> {

    fun map(realmObject: R): E
    fun map(entity: E): R
}