package com.example.app.di.gateway

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.domain.gateway.shared_preferences.SharedPreferencesGateway
import com.example.app.di.api.ApiModule
import com.example.app.di.app.AppModule
import com.example.app.di.realm.RealmModule
import com.example.gateway.gateway.shared_preferences.SharedPreferencesGatewayImpl
import javax.inject.Singleton

@Module(includes = [RealmModule::class, ApiModule::class, AppModule::class])
@InstallIn(SingletonComponent::class)
abstract class GatewayModule {

    @Binds
    @Singleton
    abstract fun bindsSharedPreferencesGateway(
        sharedPreferencesGateway: SharedPreferencesGatewayImpl
    ): SharedPreferencesGateway

}