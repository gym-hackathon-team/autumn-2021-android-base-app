package com.example.app.ui.auth

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

data class AuthActivityViewState(
    val a: Int = 0
): BaseViewState

class AuthActivityViewModel @AssistedInject constructor(
    @Assisted state: AuthActivityViewState
): BaseViewModel<AuthActivityViewState, AuthActivityViewEvents, AuthActivityViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<AuthActivityViewModel, AuthActivityViewState>


    companion object : MavericksViewModelFactory<AuthActivityViewModel, AuthActivityViewState> by hiltMavericksViewModelFactory()
}