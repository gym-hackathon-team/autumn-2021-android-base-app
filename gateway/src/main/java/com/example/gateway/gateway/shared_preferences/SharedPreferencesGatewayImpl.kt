package com.example.gateway.gateway.shared_preferences

import android.content.SharedPreferences
import com.example.domain.gateway.shared_preferences.SharedPreferencesGateway
import javax.inject.Inject

class SharedPreferencesGatewayImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) : SharedPreferencesGateway {

    override var isTokenOverdue: Boolean
        set(value) = save(FIELD_TOKEN_IS_OVERDUE, value)
        get() = readBoolean(FIELD_TOKEN_IS_OVERDUE)

    override var accessToken: String
        set(value) = save(FIELD_ACCESS_TOKEN, value)
        get() = readString(FIELD_ACCESS_TOKEN).toString()

    override var refreshToken: String
        set(value) = save(FIELD_REFRESH_TOKEN, value)
        get() = readString(FIELD_REFRESH_TOKEN).toString()

    override fun saveToken(accessToken: String, refreshToken: String) {
        this.accessToken = accessToken
        this.refreshToken = refreshToken
    }

    override fun clearAll() {
        accessToken = ""
        refreshToken = ""
    }

    private fun save(key: String, value: String) =
        sharedPreferences.edit().putString(key, value).apply()

    private fun readString(key: String) =
        sharedPreferences.getString(key, "")

    @Suppress("UnusedPrivateMember")
    private fun save(key: String, value: Int) =
        sharedPreferences.edit().putInt(key, value).apply()

    @Suppress("UnusedPrivateMember")
    private fun readInt(key: String) =
        sharedPreferences.getInt(key, 0)

    private fun save(key: String, value: Boolean) =
        sharedPreferences.edit().putBoolean(key, value).apply()

    private fun readBoolean(key: String) =
        sharedPreferences.getBoolean(key, false)


    companion object {
        private const val FIELD_ACCESS_TOKEN = "access_token"
        private const val FIELD_REFRESH_TOKEN = "refresh_token"
        private const val FIELD_TOKEN_IS_OVERDUE = "token_is_overdue"
    }
}