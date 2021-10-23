//package com.example.app.network.authenticators
//
//import okhttp3.Authenticator
//import okhttp3.Request
//import okhttp3.Response
//import okhttp3.Route
//import com.example.domain.entities.AuthEntity
//import com.example.domain.gateway.auth.AuthGateway
//import com.example.domain.gateway.shared_preferences.SharedPreferencesGateway
//import java.io.IOException
//import javax.inject.Inject
//
//class TokenAuthenticator @Inject constructor(
//    private val authGateway: AuthGateway,
//    private val sharedPreferencesGateway: SharedPreferencesGateway
//) : Authenticator {
//
//    override fun authenticate(route: Route?, response: Response): Request {
//        synchronized(this) {
//            val responseBody = response.body.toString()
//            val refreshToken = sharedPreferencesGateway.refreshToken
//            val token = when {
//                responseBody.contains(TOKEN_IS_EXPIRED)
//                        || responseBody.contains(REFRESH_TOKEN_IS_EXPIRED) -> null
//                refreshToken == "" -> null
//                else -> try {
//                    sharedPreferencesGateway.isTokenOverdue = true
//                    val data: AuthEntity = authGateway.auth(refreshToken = refreshToken).blockingGet()
//                    sharedPreferencesGateway.refreshToken = data.refreshToken
//                    sharedPreferencesGateway.accessToken = data.accessToken
//                    sharedPreferencesGateway.isTokenOverdue = false
//                    data.accessToken
//                } catch (e: Throwable) {
//                    // TODO перезапускать активность
//                    sharedPreferencesGateway.clearAll()
//                    e.printStackTrace()
//                    null
//                }
//            }
//
//            return if (token == null) {
//                // TODO перезапускать активность
//                sharedPreferencesGateway.clearAll()
//                throw IOException(responseBody)
//            } else {
//                response.request
//                    .newBuilder()
//                    .header("Authorization", "Bearer $token")
//                    .build()
//            }
//        }
//    }
//
//
//    companion object {
//        private const val TOKEN_IS_EXPIRED = "token provided has expired"
//        private const val REFRESH_TOKEN_IS_EXPIRED = "Refresh token has expired"
//    }
//}
