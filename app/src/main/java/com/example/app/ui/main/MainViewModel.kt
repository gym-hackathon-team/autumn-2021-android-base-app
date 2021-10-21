package com.example.app.ui.main

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import com.example.domain.gateway.anime.AnimeGateway
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

data class MainActivityViewState(
    val a: Int = 0
): BaseViewState

class MainViewModel @AssistedInject constructor(
    @Assisted state: MainActivityViewState,
    private val animeGateway: AnimeGateway
): BaseViewModel<MainActivityViewState, MainActivityViewEvents, MainActivityViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<MainViewModel, MainActivityViewState>

    init {
        fetchAnime()
    }

    private fun fetchAnime() {
        animeGateway.fetchAnime()
    }

    companion object : MavericksViewModelFactory<MainViewModel, MainActivityViewState> by hiltMavericksViewModelFactory()

}