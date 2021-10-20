package com.example.app.ui.profile

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

data class ProfileFragmentViewState(
    val a: Int? = null
) : BaseViewState

class ProfileViewModel @AssistedInject constructor(
    @Assisted state: ProfileFragmentViewState
): BaseViewModel<ProfileFragmentViewState, ProfileFragmentViewEvents, ProfileFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<ProfileViewModel, ProfileFragmentViewState>


    companion object : MavericksViewModelFactory<ProfileViewModel, ProfileFragmentViewState> by hiltMavericksViewModelFactory()
}