@file:SuppressLint("CustomSplashScreen")
package com.example.app.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import com.airbnb.mvrx.viewModel
import com.example.app.databinding.ActivitySplashBinding
import com.example.app.ui.auth.AuthActivity
import com.example.app.ui.base.BaseActivity
import com.example.app.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override val viewModel: SplashActivityViewModel by viewModel()

    override fun getBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun setupListeners() {
        viewModel.observeViewEvents(::handle)
    }

    private fun handle(event: SplashActivityViewEvents) {
        when (event) {
            SplashActivityViewEvents.NavigateToAuthScreen -> handleNavigateToAuthActivity()
        }
    }

    private fun handleNavigateToAuthActivity() {
        Intent(this, AuthActivity::class.java).let { intent ->
            startActivity(intent)
            finish()
        }
    }
}