package com.example.app.ui.main

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import com.example.domain.entities.Command
import com.example.domain.entities.CommandsEntity
import com.example.domain.gateway.commands.CommandsGateway
import com.example.gateway.gateway.commands.RetrofitCommandsGateway
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.schedulers.Schedulers
import java.io.File

data class MainActivityViewState(
    val a: Int = 0
): BaseViewState

class MainViewModel @AssistedInject constructor(
    @Assisted state: MainActivityViewState,
    private val commandsGateway: CommandsGateway
): BaseViewModel<MainActivityViewState, MainActivityViewEvents, MainActivityViewActions>(state) {


    @AssistedFactory
    interface Factory : AssistedViewModelFactory<MainViewModel, MainActivityViewState>


    fun sendFile(file: File?) {
        file?.let {
            commandsGateway.postCommand(it)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({
                    if (it.decision) {
                        _viewEvents.post(MainActivityViewEvents.PerformCommand(it))
                    }
                }, {
//                    _viewEvents.post(MainActivityViewEvents.PerformCommand(CommandsEntity(true, Command.ORGANIZATION_PAYMENT)))
                    it.printStackTrace()
                })
                .disposeOnCleared()
        }
    }


    companion object : MavericksViewModelFactory<MainViewModel, MainActivityViewState> by hiltMavericksViewModelFactory()

}