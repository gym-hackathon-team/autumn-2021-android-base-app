package com.example.app.ui.main

import com.airbnb.mvrx.MavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState

data class MainActivityViewState(
    val a: Int = 0
) : BaseViewState

class MainViewModel @AssistedInject constructor(
    @Assisted state: MainActivityViewState
) : BaseViewModel<MainActivityViewState, MainActivityViewEvents, MainActivityViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<MainViewModel, MainActivityViewState>


    companion object : MavericksViewModelFactory<MainViewModel, MainActivityViewState>
        by hiltMavericksViewModelFactory()
}