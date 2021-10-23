@file:Suppress("MaxLineLength")
package com.example.app.ui.login

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import com.example.domain.gateway.auth.AuthGateway
import com.example.domain.gateway.shared_preferences.SharedPreferencesGateway
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.schedulers.Schedulers

data class LoginFragmentViewState(
    val a: Int = 0
): BaseViewState

class LoginViewModel @AssistedInject constructor(
    @Assisted state: LoginFragmentViewState,
    private val authGateway: AuthGateway,
    private val sharedPreferencesGateway: SharedPreferencesGateway
): BaseViewModel<LoginFragmentViewState, LoginFragmentViewEvents, LoginFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<LoginViewModel, LoginFragmentViewState>


    fun authUser(email:String,password:String) {
        authGateway.auth(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                sharedPreferencesGateway.saveToken(it.token)
                _viewEvents.post(LoginFragmentViewEvents.GoToMainFragment)
            }, {
                _viewEvents.post(LoginFragmentViewEvents.ShowError)
                it.printStackTrace()
            })
            .disposeOnCleared()

    }


    companion object : MavericksViewModelFactory<LoginViewModel, LoginFragmentViewState> by hiltMavericksViewModelFactory()
}
