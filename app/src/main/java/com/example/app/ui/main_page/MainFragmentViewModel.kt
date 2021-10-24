@file:Suppress("MaxLineLength")
package com.example.app.ui.main_page

import com.airbnb.mvrx.*
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import com.example.app.ui.main_page.recycler_view.model.CardModel
import com.example.domain.gateway.card.CardGateway
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

data class MainFragmentViewState(
    val cards: Async<List<CardModel>> = Uninitialized
): BaseViewState

class MainFragmentViewModel @AssistedInject constructor(
    @Assisted state: MainFragmentViewState,
    private val cardGateway: CardGateway
): BaseViewModel<MainFragmentViewState, MainFragmentViewEvents, MainFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<MainFragmentViewModel, MainFragmentViewState>

    init {
        fetchCards()
    }

    override fun handle(action: MainFragmentViewActions) {
        when (action) {
            MainFragmentViewActions.OnSwipeToRefresh -> fetchCards()
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
                setState {
                    copy(
                        cards = Fail(it)
                    )
                }
                it.printStackTrace()
            })
            .disposeOnCleared()
    }

    companion object : MavericksViewModelFactory<MainFragmentViewModel, MainFragmentViewState> by hiltMavericksViewModelFactory()
}