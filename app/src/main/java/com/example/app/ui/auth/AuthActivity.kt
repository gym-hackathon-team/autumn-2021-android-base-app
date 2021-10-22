package com.example.app.ui.auth

import com.airbnb.mvrx.viewModel
import com.example.app.databinding.ActivityAuthBinding
import com.example.app.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding>() {

    override val viewModel: AuthActivityViewModel by viewModel()


    override fun getBinding(): ActivityAuthBinding {
        return ActivityAuthBinding.inflate(layoutInflater)
    }
}