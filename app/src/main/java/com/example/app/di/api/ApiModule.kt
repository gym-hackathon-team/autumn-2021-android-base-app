package com.example.app.di.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import com.example.app.di.retrofit.RetrofitModule
import com.example.gateway.gateway.auth.AuthApi
import com.example.gateway.gateway.card.CardApi
import com.example.gateway.gateway.commands.CommandsApi
import com.example.gateway.gateway.transactions.TransactionsApi
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideAuthApi(
        @Named("AuthRetrofit")
        retrofit: Retrofit
    ): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCardApi(
        retrofit: Retrofit
    ): CardApi {
        return retrofit.create(CardApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTransactionApi(
        retrofit: Retrofit
    ): TransactionsApi {
        return retrofit.create(TransactionsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCommandsApi(
        retrofit: Retrofit
    ): CommandsApi {
        return retrofit.create(CommandsApi::class.java)
    }
}