package com.example.app.ui.payment

import com.airbnb.mvrx.*
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import com.example.app.ui.main_page.recycler_view.model.CardModel
import com.example.domain.gateway.card.CardGateway
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


data class PaymentFragmentViewState(
    val cards: Async<List<CardModel>> = Uninitialized,
    val selectedCard: CardModel? = null
) : BaseViewState

class PaymentViewModel @AssistedInject constructor(
    @Assisted state: PaymentFragmentViewState,
    private val cardGateway: CardGateway
) : BaseViewModel<PaymentFragmentViewState, PaymentFragmentViewEvents, PaymentFragmentViewActions>(
    state
) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<PaymentViewModel, PaymentFragmentViewState>

    init {
        fetchCards()
    }

    override fun handle(action: PaymentFragmentViewActions) {
        when (action) {
            is PaymentFragmentViewActions.OnCardSelected -> handleOnCardSelected(action)
            is PaymentFragmentViewActions.OnProceedClicked -> handleProceed(action)
        }
    }

    private fun handleProceed(action: PaymentFragmentViewActions.OnProceedClicked) {
        withState {
            if (action.accountId.isNotBlank() && action.amount != 0.0f) {
                val card = it.selectedCard ?: return@withState
                _viewEvents.post(
                    PaymentFragmentViewEvents.NavigateToConfirmation(
                        accountId = action.accountId,
                        amount = action.amount,
                        fromAccount = it.selectedCard.id
                    )
                )
            }
        }
    }

    private fun handleOnCardSelected(action: PaymentFragmentViewActions.OnCardSelected) {
        setState {
            copy(
                selectedCard = action.cardModel
            )
        }
    }

    private fun fetchCards() {
        cardGateway.getUserCards()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                setState {
                    copy(
                        cards = Loading(listOf())
                    )
                }
            }
            .subscribe({
                setState {
                    copy(
                        cards = Success(it.map {
                            CardModel(
                                id = it.id,
                                accountId = it.accountId,
                                number = it.number,
                                balance = it.balance
                            )
                        })
                    )
                }
            }, {
//                setState {
//                    copy(
//                        cards = Fail(it)
//                    )
//                }
                setState {
                    copy(
                        cards = Success(
                            listOf(
                                CardModel(
                                    id = "dsjadlaksjd",
                                    balance = 300f,
                                    accountId = "dsajlkdjas",
                                    number = "1234124124124"
                                ),
                                CardModel(
                                    id = "dsjadlaksjdewae",
                                    balance = 300f,
                                    accountId = "dsajlkdjas",
                                    number = "1234124124124"
                                )
                            )
                        )
                    )
                }
                it.printStackTrace()
            })
            .disposeOnCleared()
    }

    companion object :
        MavericksViewModelFactory<PaymentViewModel, PaymentFragmentViewState> by hiltMavericksViewModelFactory()
}
