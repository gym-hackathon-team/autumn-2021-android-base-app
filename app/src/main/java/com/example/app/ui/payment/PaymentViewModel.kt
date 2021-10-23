package com.example.app.ui.payment

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import com.example.app.ui.blank.TemplateFragmentViewActions
import com.example.app.ui.blank.TemplateFragmentViewEvents
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


data class PaymentFragmentViewState(
    val a: Int = 0
): BaseViewState

class PaymentViewModel @AssistedInject constructor(
    @Assisted state: PaymentFragmentViewState
): BaseViewModel<PaymentFragmentViewState, PaymentFragmentViewEvents, PaymentFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<PaymentViewModel, PaymentFragmentViewState>


    companion object : MavericksViewModelFactory<PaymentViewModel, PaymentFragmentViewState> by hiltMavericksViewModelFactory()
}
