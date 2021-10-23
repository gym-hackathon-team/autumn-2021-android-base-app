@file:Suppress("MaxLineLength")
package com.example.app.ui.login

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import com.example.domain.gateway.auth.AuthGateway
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

data class LoginFragmentViewState(
    val a: Int = 0
): BaseViewState

class LoginViewModel @AssistedInject constructor(
    @Assisted state: LoginFragmentViewState,
    private val authGateway: AuthGateway
): BaseViewModel<LoginFragmentViewState, LoginFragmentViewEvents, LoginFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<LoginViewModel, LoginFragmentViewState>

    fun authUser() {
        authGateway.auth("n4i8x9a@n4i8x9a.ru", "ReFf2281488")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val a = 0
            }, {
                it.printStackTrace()
            })
            .disposeOnCleared()
    }

    companion object : MavericksViewModelFactory<LoginViewModel, LoginFragmentViewState> by hiltMavericksViewModelFactory()
}
