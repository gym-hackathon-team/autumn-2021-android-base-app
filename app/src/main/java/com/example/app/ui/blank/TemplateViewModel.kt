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
import com.example.app.ui.main.MainActivityViewEvents
import com.example.domain.gateway.commands.CommandsGateway
import io.reactivex.schedulers.Schedulers
import java.io.File

data class TemplateFragmentViewState(
    val a: Int = 0
): BaseViewState

class TemplateViewModel @AssistedInject constructor(
    @Assisted state: TemplateFragmentViewState,
    private val commandsGateway: CommandsGateway
): BaseViewModel<TemplateFragmentViewState, TemplateFragmentViewEvents, TemplateFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<TemplateViewModel, TemplateFragmentViewState>

    fun sendFile(file: File?) {
        file?.let {
            commandsGateway.registerVoice(it)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({
                    _viewEvents.post(TemplateFragmentViewEvents.ShowToast)
                }, {
    //                    _viewEvents.post(MainActivityViewEvents.PerformCommand(CommandsEntity(true, Command.ORGANIZATION_PAYMENT)))
                    it.printStackTrace()
                })
                .disposeOnCleared()
    }
    }


    companion object : MavericksViewModelFactory<TemplateViewModel, TemplateFragmentViewState> by hiltMavericksViewModelFactory()
}
