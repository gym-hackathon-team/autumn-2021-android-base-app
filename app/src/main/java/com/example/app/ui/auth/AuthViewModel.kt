package com.example.app.ui.auth

import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

data class AuthActivityViewState(
    val counter: Int = 0
) : BaseViewState

class AuthViewModel @AssistedInject constructor(
    @Assisted state: AuthActivityViewState
): BaseViewModel<AuthActivityViewState, AuthActivityViewEvents, AuthActivityViewActions>(state)