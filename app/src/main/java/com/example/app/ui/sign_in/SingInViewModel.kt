package com.example.app.ui.sign_in

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

data class SignInFragmentViewState(
    val counter: Int = 0
) : BaseViewState

class SignInViewModel @AssistedInject constructor(
    @Assisted state: SignInFragmentViewState
): BaseViewModel<SignInFragmentViewState, SignInFragmentViewEvents, SignInFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<SignInViewModel, SignInFragmentViewState>


    companion object : MavericksViewModelFactory<SignInViewModel, SignInFragmentViewState> by hiltMavericksViewModelFactory()
}