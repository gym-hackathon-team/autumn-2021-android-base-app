package com.example.app.ui.service_list

import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.app.di.viewmodel.AssistedViewModelFactory
import com.example.app.di.viewmodel.hiltMavericksViewModelFactory
import com.example.app.ui.base.BaseViewModel
import com.example.app.ui.base.BaseViewState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


data class ServiceListViewState(
    val a: Int = 0
): BaseViewState

class ServiceListViewModel @AssistedInject constructor(
    @Assisted state: ServiceListViewState
) : BaseViewModel<ServiceListViewState, ServiceListFragmentViewEvents, ServiceListFragmentViewActions>(state) {

    @AssistedFactory
    interface Factory: AssistedViewModelFactory<ServiceListViewModel, ServiceListViewState>


    companion object : MavericksViewModelFactory<ServiceListViewModel, ServiceListViewState> by hiltMavericksViewModelFactory()
}