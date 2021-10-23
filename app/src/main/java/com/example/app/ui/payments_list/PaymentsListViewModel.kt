@file:Suppress("MaxLineLength")
package com.example.app.ui.payments_list

import com.airbnb.mvrx.MavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState

data class PaymentsListFragmentViewState(
    val a: Int = 0
): BaseViewState

class PaymentsListViewModel @AssistedInject constructor(
    @Assisted state: PaymentsListFragmentViewState
): BaseViewModel<PaymentsListFragmentViewState, PaymentsListFragmentViewEvents, PaymentsListFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<PaymentsListViewModel, PaymentsListFragmentViewState>


    companion object : MavericksViewModelFactory<PaymentsListViewModel, PaymentsListFragmentViewState> by hiltMavericksViewModelFactory()
}