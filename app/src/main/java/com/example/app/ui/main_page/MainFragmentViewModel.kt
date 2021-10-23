@file:Suppress("MaxLineLength")
package com.example.app.ui.main_page

import com.airbnb.mvrx.MavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState

data class MainFragmentViewState(
    val a: Int = 0
): BaseViewState

class MainFragmentViewModel @AssistedInject constructor(
    @Assisted state: MainFragmentViewState
): BaseViewModel<MainFragmentViewState, MainFragmentViewEvents, MainFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<MainFragmentViewModel, MainFragmentViewState>


    companion object : MavericksViewModelFactory<MainFragmentViewModel, MainFragmentViewState> by hiltMavericksViewModelFactory()
}