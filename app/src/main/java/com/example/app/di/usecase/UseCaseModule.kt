package com.example.app.di.usecase

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.app.di.gateway.GatewayModule

@Module(includes = [GatewayModule::class])
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

// Just Template
//    @Binds
//    @Singleton
//    abstract fun bindAuthUseCase(authUseCaseImpl: AuthUseCaseImpl): AuthUseCase
}