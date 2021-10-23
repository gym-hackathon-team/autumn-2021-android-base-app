package com.example.domain.gateway.auth

import io.reactivex.Single
import com.example.domain.entities.AuthEntity

interface AuthGateway {

    fun auth(email: String, password: String): Single<AuthEntity>
}