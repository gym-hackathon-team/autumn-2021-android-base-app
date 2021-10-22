package com.example.gateway.gateway.base

import dagger.Lazy
import io.reactivex.Completable
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmObject
import com.example.domain.entities.BaseEntity
import com.example.gateway.entities.mappers.base.BaseRealmMapper

open class BaseRealmGateway<R: RealmObject, E: BaseEntity>(
    private val _realm: Lazy<Realm>,
    private val mapper: BaseRealmMapper<R, E>
) {

    protected val realm: Realm
        get() {
            return _realm.get()
        }

    /**
     * Функция, которая маппит модель Realm в сущность бизнес-логики
     * @param block Блок кода, в который мы прокидываем полученную модель
     * @return Объект типа Single
     */
    fun withMapper(block: () -> Single<R>): Single<E> {
        val realmModel = block().blockingGet()
        return Single.just(mapper.map(realmModel))
    }

    /**
     * Функция, которая маппит сущность в модель для Realm
     * @param entity Сущсность, которая будет маппиться
     * @param block Блок кода, в который мы прокидываем полученную модель
     */
    fun withMapper(entity: E, block: (R) -> Unit) = Completable.fromAction {
        val realmModel = mapper.map(entity)
        block(realmModel)
    }
}