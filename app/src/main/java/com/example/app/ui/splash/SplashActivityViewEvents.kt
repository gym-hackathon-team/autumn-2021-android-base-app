package com.example.app.ui.splash

import com.example.app.ui.base.BaseViewEvents

sealed class SplashActivityViewEvents : BaseViewEvents {
    object NavigateToAuthActivity : SplashActivityViewEvents()
    object NavigateToMainActivity : SplashActivityViewEvents()
}