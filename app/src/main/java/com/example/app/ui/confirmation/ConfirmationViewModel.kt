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
import com.example.domain.gateway.transactions.TransactionsGateway
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

data class ConfirmationFragmentViewState(
    val a: Int = 0
) : BaseViewState

class ConfirmationViewModel @AssistedInject constructor(
    @Assisted state: ConfirmationFragmentViewState,
    private val transactionsGateway: TransactionsGateway
) : BaseViewModel<ConfirmationFragmentViewState, ConfirmationFragmentViewEvents, ConfirmationFragmentViewActions>(
    state
) {

    @AssistedFactory
    interface Factory :
        AssistedViewModelFactory<ConfirmationViewModel, ConfirmationFragmentViewState>


    override fun handle(action: ConfirmationFragmentViewActions) {
        when (action) {
            is ConfirmationFragmentViewActions.ActionConfirm -> handleConfirm(action)
        }
    }

    private fun handleConfirm(action: ConfirmationFragmentViewActions.ActionConfirm) {
        transactionsGateway.makePayment(
            cardId = action.fromAccount,
            accountId = action.accountId,
            amount = action.amount
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _viewEvents.post(ConfirmationFragmentViewEvents.NavigateToResult(it.status))
            }, {
                _viewEvents.post(ConfirmationFragmentViewEvents.NavigateToResult(false))
                it.printStackTrace()
            })
            .disposeOnCleared()
    }


    companion object :
        MavericksViewModelFactory<ConfirmationViewModel, ConfirmationFragmentViewState> by hiltMavericksViewModelFactory()
}
