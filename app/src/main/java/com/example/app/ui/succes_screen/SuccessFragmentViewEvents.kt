package com.example.app.ui.succes_screen

import com.example.app.ui.base.BaseViewEvents
import com.example.app.ui.splash.SplashActivityViewEvents

sealed class SuccessFragmentViewEvents: BaseViewEvents{
    object ChangeToErrorImage : SuccessFragmentViewEvents()
}