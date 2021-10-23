@file:Suppress("MaxLineLength")
package com.example.app.ui.confirmation

import com.airbnb.mvrx.MavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState

data class ConfirmationFragmentViewState(
    val a: Int = 0
): BaseViewState

class ConfirmationViewModel @AssistedInject constructor(
    @Assisted state: ConfirmationFragmentViewState
): BaseViewModel<ConfirmationFragmentViewState, ConfirmationFragmentViewEvents, ConfirmationFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<ConfirmationViewModel, ConfirmationFragmentViewState>


    companion object : MavericksViewModelFactory<ConfirmationViewModel, ConfirmationFragmentViewState> by hiltMavericksViewModelFactory()
}
