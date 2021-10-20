package com.example.app.ui.sign_in

import com.example.app.ui.base.BaseViewEvents

sealed class SignInFragmentViewEvents : BaseViewEvents {
    object NavigateToMainActivity: SignInFragmentViewEvents()
}