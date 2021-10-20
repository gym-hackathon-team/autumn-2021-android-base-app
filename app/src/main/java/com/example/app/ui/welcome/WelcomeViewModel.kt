package com.example.app.ui.welcome

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

data class WelcomeFragmentViewState(
    val a: Int = 0
) : BaseViewState

class WelcomeViewModel @AssistedInject constructor(
    @Assisted state: WelcomeFragmentViewState
): BaseViewModel<WelcomeFragmentViewState, WelcomeFragmentViewEvents, WelcomeFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory: AssistedViewModelFactory<WelcomeViewModel, WelcomeFragmentViewState>


    companion object : MavericksViewModelFactory<WelcomeViewModel, WelcomeFragmentViewState> by hiltMavericksViewModelFactory()

}