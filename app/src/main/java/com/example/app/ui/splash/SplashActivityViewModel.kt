@file:SuppressLint("CustomSplashScreen")
package com.example.app.ui.splash

import android.annotation.SuppressLint
import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

data class SplashActivityViewState(
    val a: Int = 0
): BaseViewState

class SplashActivityViewModel @AssistedInject constructor(
    @Assisted state: SplashActivityViewState
): BaseViewModel<SplashActivityViewState, SplashActivityViewEvents, SplashActivityViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<SplashActivityViewModel, SplashActivityViewState>

    init {
        checkUserLogon()
    }

    private fun checkUserLogon() {
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
            .subscribe {
                _viewEvents.post(SplashActivityViewEvents.NavigateToAuthScreen)
            }
            .disposeOnCleared()
    }


    companion object : MavericksViewModelFactory<SplashActivityViewModel, SplashActivityViewState> by hiltMavericksViewModelFactory()
}