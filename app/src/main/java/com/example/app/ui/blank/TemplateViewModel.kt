@file:Suppress("MaxLineLength")
package com.example.app.ui.blank

import com.airbnb.mvrx.MavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState

data class TemplateFragmentViewState(
    val a: Int = 0
): BaseViewState

class TemplateViewModel @AssistedInject constructor(
    @Assisted state: TemplateFragmentViewState
): BaseViewModel<TemplateFragmentViewState, TemplateFragmentViewEvents, TemplateFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<TemplateViewModel, TemplateFragmentViewState>


    companion object : MavericksViewModelFactory<TemplateViewModel, TemplateFragmentViewState> by hiltMavericksViewModelFactory()
}
