package com.example.app.di.apollo

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx3.rxMutate
import com.example.app.di.retrofit.OkHttpModule
import com.example.gateway.ApiConstants
import com.example.gateway.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module(includes = [OkHttpModule::class])
@InstallIn(SingletonComponent::class)
class ApolloModule {

    @Provides
    @Singleton
    fun provideApolloClient(
        okHttpClient: OkHttpClient
    ): ApolloClient {
        return ApolloClient.builder()
            .serverUrl("${BuildConfig.BASE_URL}${ApiConstants.GRAPHQL_ENDPOINT}")
            .okHttpClient(okHttpClient)
            .build()
    }

}