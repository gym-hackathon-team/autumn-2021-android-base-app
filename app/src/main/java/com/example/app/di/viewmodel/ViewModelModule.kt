package com.example.app.di.viewmodel

import com.example.app.ui.auth.AuthActivityViewModel
import com.example.app.ui.blank.TemplateViewModel
import com.example.app.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap
import com.example.app.ui.main.MainViewModel
import com.example.app.ui.main_page.MainFragmentViewModel
import com.example.app.ui.payments_list.PaymentsListViewModel
import com.example.app.ui.payment.PaymentViewModel
import com.example.app.ui.splash.SplashActivityViewModel
import com.example.app.ui.succes_screen.SuccessViewModel

@Module
@InstallIn(MavericksViewModelComponent::class)
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModelFactory(factory: MainViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(SplashActivityViewModel::class)
    fun bindSplashViewModelFactory(factory: SplashActivityViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(AuthActivityViewModel::class)
    fun bindAuthViewModelFactory(factory: AuthActivityViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(TemplateViewModel::class)
    fun bindTemplateViewModelFactory(factory: TemplateViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(SuccessViewModel::class)
    fun bindSuccessViewModelFactory(factory: SuccessViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(PaymentsListViewModel::class)
    fun bindPaymentsListViewModelFactory(factory: PaymentsListViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindPaymentsLoginViewModelFactory(factory: LoginViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(PaymentViewModel::class)
    fun bindPaymentViewModelFactory(factory: PaymentViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    fun bindMainFragmentViewModelFactory(factory: MainFragmentViewModel.Factory): AssistedViewModelFactory<*, *>
    }