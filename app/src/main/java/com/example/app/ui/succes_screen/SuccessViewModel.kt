package com.example.app.ui.succes_screen

import android.os.Bundle
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


data class SuccessFragmentViewState(
    val a: Int = 0
): BaseViewState

class SuccessViewModel @AssistedInject constructor(
    @Assisted state: SuccessFragmentViewState
): BaseViewModel<SuccessFragmentViewState, SuccessFragmentViewEvents, SuccessFragmentViewActions>(state) {
    private val ANSWER="ANSWER"
    @AssistedFactory
    interface Factory : AssistedViewModelFactory<SuccessViewModel, SuccessFragmentViewState>

    companion object : MavericksViewModelFactory<SuccessViewModel, SuccessFragmentViewState> by hiltMavericksViewModelFactory()


    fun handleResponse(arguments: Bundle){
        if (!arguments.getBoolean(ANSWER)){
            _viewEvents.post(SuccessFragmentViewEvents.ChangeToErrorImage)
        }
    }
    }


