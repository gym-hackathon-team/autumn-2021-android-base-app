package com.example.app.ui.splash

import android.content.Intent
import android.os.Bundle
import com.airbnb.mvrx.viewModel
import com.example.app.databinding.ActivitySplashBinding
import com.example.app.ui.auth.AuthActivity
import com.example.app.ui.base.BaseActivity
import com.example.app.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override val viewModel: SplashViewModel by viewModel()

    override fun getBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.checkUser()
    }

    override fun setupListeners() {
        super.setupListeners()
        viewModel.observeViewEvents {
            when (it) {
                SplashActivityViewEvents.NavigateToAuthActivity -> navigateToAuthActivity()
                SplashActivityViewEvents.NavigateToMainActivity -> navigateToMainActivity()
            }
        }
    }

    private fun navigateToMainActivity() {
        Intent(this, MainActivity::class.java).let(::startActivity)
        finish()
    }

    private fun navigateToAuthActivity() {
        Intent(this, AuthActivity::class.java).let(::startActivity)
        finish()
    }


}