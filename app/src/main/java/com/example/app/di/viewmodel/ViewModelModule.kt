package com.example.app.di.viewmodel

import com.example.app.ui.auth.AuthActivityViewModel
import com.example.app.ui.blank.TemplateViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap
import com.example.app.ui.main.MainViewModel
import com.example.app.ui.splash.SplashActivityViewModel

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
}