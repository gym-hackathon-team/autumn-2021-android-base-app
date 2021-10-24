package com.example.app.ui.succes_screen

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


data class SuccessFragmentViewState(
    val a: Int = 0
) : BaseViewState

class SuccessViewModel @AssistedInject constructor(
    @Assisted state: SuccessFragmentViewState
) : BaseViewModel<SuccessFragmentViewState, SuccessFragmentViewEvents, SuccessFragmentViewActions>(
    state
) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<SuccessViewModel, SuccessFragmentViewState>


    companion object :
        MavericksViewModelFactory<SuccessViewModel, SuccessFragmentViewState> by hiltMavericksViewModelFactory()

}


