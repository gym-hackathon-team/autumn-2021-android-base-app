package com.example.app.qwerty

import com.example.domain.entities.LoginEntity
import com.example.gateway.entities.retrofit.response.AuthResponse
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import javax.inject.Inject
import javax.inject.Singleton

class RepositoryIMPL:Repository {
    fun provideRetrofit(): Retrofit {
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("http://5.63.154.19:8079/")
            .client(client)
            .build()
    }
    override fun auth (loginEntity: LoginEntity): Single<AuthResponse> {
            val authData = HashMap<String, String>()
            authData.put("email", loginEntity.email)
            authData.put("password", loginEntity.password)


        val body: RequestBody =
            loginEntity.toString().toRequestBody("application/json".toMediaTypeOrNull())
        return  provideRetrofit().create(ApiService::class.java).auth(authData)
    }
}
interface Repository{
    fun auth (loginEntity:LoginEntity): Single<AuthResponse>
}
interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("auth/user/login")
    fun auth(
        @Body authData: Map<String, String>
//        @Body body: RequestBody
//        ,        @Field("password") password: String
    ): Single<AuthResponse>
}