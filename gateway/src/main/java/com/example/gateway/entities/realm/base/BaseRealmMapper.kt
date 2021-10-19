package com.example.gateway.entities.realm.base

import io.realm.RealmObject
import com.example.domain.entities.BaseEntity
import com.example.gateway.entities.BaseMapper


interface BaseRealmMapper<R: RealmObject, E: BaseEntity> : BaseMapper<R, E> {

    fun map(realmObject: R): E
    fun map(entity: E): R
}