package com.example.domain.gateway.shared_preferences

interface SharedPreferencesGateway {

    var isTokenOverdue: Boolean
    var accessToken: String
    var refreshToken: String


    fun saveToken(accessToken: String, refreshToken: String)
    fun clearAll()
}
