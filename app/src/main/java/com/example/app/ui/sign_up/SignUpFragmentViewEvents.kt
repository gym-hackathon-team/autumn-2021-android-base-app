package com.example.app.ui.sign_up

import com.example.app.ui.base.BaseViewEvents

sealed class SignUpFragmentViewEvents : BaseViewEvents {
    object NavigateToMainActivity: SignUpFragmentViewEvents()
}