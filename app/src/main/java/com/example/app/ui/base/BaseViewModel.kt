package com.example.app.ui.base

import com.airbnb.mvrx.MavericksViewModel
import com.example.app.di.viewmodel.DataSource
import com.example.app.di.viewmodel.PublishDataSource


abstract class BaseViewModel<S: BaseViewState, VE: BaseViewEvents, VA: BaseViewActions>(
    state: S
) : MavericksViewModel<S>(state) {

    protected val _viewEvents = PublishDataSource<VE>()
    val viewEvents: DataSource<VE> = _viewEvents

    open fun handle(action: VA) = Unit

}