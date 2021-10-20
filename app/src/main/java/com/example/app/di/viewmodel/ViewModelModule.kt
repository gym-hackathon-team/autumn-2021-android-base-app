package com.example.app.di.viewmodel

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap
import com.example.app.ui.main.MainViewModel
import com.example.app.ui.profile.ProfileViewModel
import com.example.app.ui.service_list.ServiceListViewModel
import com.example.app.ui.sign_in.SignInViewModel
import com.example.app.ui.sign_up.SignUpViewModel
import com.example.app.ui.splash.SplashViewModel
import com.example.app.ui.welcome.WelcomeViewModel

@Module
@InstallIn(MavericksViewModelComponent::class)
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModelFactory(factory: MainViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    fun bindSignInViewModelFactory(factory: SignInViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModelFactory(factory: SplashViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel::class)
    fun bindWelcomeViewModelFactory(factory: WelcomeViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    fun bindSignUpViewModelFactory(factory: SignUpViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(ServiceListViewModel::class)
    fun bindServiceListViewModelFactory(factory: ServiceListViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileViewModelFactory(factory: ProfileViewModel.Factory): AssistedViewModelFactory<*, *>
}