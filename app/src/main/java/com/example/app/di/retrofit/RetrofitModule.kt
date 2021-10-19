package com.example.app.di.retrofit

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import com.example.domain.gateway.auth.AuthGateway
import com.example.domain.gateway.shared_preferences.SharedPreferencesGateway
import com.example.app.di.gateway.GatewayModule
import com.example.app.network.authenticators.TokenAuthenticator
import com.example.app.network.interceptors.TokenInterceptor
import com.example.gateway.BuildConfig
import javax.inject.Named
import javax.inject.Singleton


@Module(includes = [GatewayModule::class])
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        moshiConverterFactory: MoshiConverterFactory,
        okHttpClient: OkHttpClient,
        rxJavaCallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .addCallAdapterFactory(rxJavaCallAdapterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @Named("AuthRetrofit")
    fun provideAuthRetrofit(
        moshiConverterFactory: MoshiConverterFactory,
        @Named("AuthOkhttp")
        okHttpClient: OkHttpClient,
        rxJavaCallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .addCallAdapterFactory(rxJavaCallAdapterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttp(
        chuckInterceptor: ChuckInterceptor,
        tokenAuthenticator: TokenAuthenticator,
        tokenInterceptor: TokenInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(chuckInterceptor)
            .addInterceptor(tokenInterceptor)
            .authenticator(tokenAuthenticator)
            .build()
    }

    @Provides
    @Singleton
    @Named("AuthOkhttp")
    fun provideAuthOkHttp(
        chuckInterceptor: ChuckInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(chuckInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideTokenAuthenticator(
        authGateway: AuthGateway,
        sharedPreferencesGateway: SharedPreferencesGateway
    ): TokenAuthenticator {
        return TokenAuthenticator(authGateway, sharedPreferencesGateway)
    }

    @Provides
    @Singleton
    fun provideTokenInterceptor(
        sharedPreferencesGateway: SharedPreferencesGateway
    ): TokenInterceptor {
        return TokenInterceptor(sharedPreferencesGateway)
    }

    @Provides
    @Singleton
    fun provideChuck(
        @ApplicationContext context: Context
    ): ChuckInterceptor {
        return ChuckInterceptor(context)
    }

    @Provides
    @Singleton
    fun provideMoshiConverter(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }
}