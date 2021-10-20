package com.example.app.ui.splash

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


data class SplashViewState(
    val a: Int = 0
) : BaseViewState

class SplashViewModel @AssistedInject constructor(
    @Assisted state: SplashViewState
) : BaseViewModel<SplashViewState, SplashActivityViewEvents, SplashActivityViewActions>(state) {

    @AssistedFactory
    interface Factory: AssistedViewModelFactory<SplashViewModel, SplashViewState>

    fun checkUser() {
        _viewEvents.post(SplashActivityViewEvents.NavigateToAuthActivity)
    }


    companion object : MavericksViewModelFactory<SplashViewModel, SplashViewState> by hiltMavericksViewModelFactory()
}