package com.example.app.ui.base

import com.airbnb.mvrx.MavericksViewModel
import com.example.app.di.viewmodel.DataSource
import com.example.app.di.viewmodel.PublishDataSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo


abstract class BaseViewModel<S: BaseViewState, VE: BaseViewEvents, VA: BaseViewActions>(
    state: S
) : MavericksViewModel<S>(state) {

    protected val _viewEvents = PublishDataSource<VE>()
    private val compositeDisposable = CompositeDisposable()
    val viewEvents: DataSource<VE> = _viewEvents


    protected fun Disposable.disposeOnCleared() {
        this.addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    open fun handle(action: VA) = Unit

}