package com.example.app.ui.sign_up

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

data class SignUpFragmentViewState(
    val test: String = ""
) : BaseViewState

class SignUpViewModel @AssistedInject constructor(
    @Assisted state: SignUpFragmentViewState
): BaseViewModel<SignUpFragmentViewState, SignUpFragmentViewEvents, SignUpFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory: AssistedViewModelFactory<SignUpViewModel, SignUpFragmentViewState>


    companion object : MavericksViewModelFactory<SignUpViewModel, SignUpFragmentViewState> by hiltMavericksViewModelFactory()
}