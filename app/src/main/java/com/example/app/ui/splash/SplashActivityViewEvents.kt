@file:SuppressLint("CustomSplashScreen")
package com.example.app.ui.splash

import android.annotation.SuppressLint
import com.example.app.ui.base.BaseViewEvents

sealed class SplashActivityViewEvents: BaseViewEvents {
    object NavigateToAuthScreen : SplashActivityViewEvents()
}
