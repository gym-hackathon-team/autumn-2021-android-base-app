package com.example.app.ui.auth

import android.content.Intent
import com.airbnb.mvrx.viewModel
import com.example.app.databinding.ActivityAuthBinding
import com.example.app.ui.base.BaseActivity
import com.example.app.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding>() {

    override val viewModel: AuthViewModel by viewModel()

    override fun getBinding(): ActivityAuthBinding {
        return ActivityAuthBinding.inflate(layoutInflater)
    }

    fun navigateToMainActivity() {
        Intent(this, MainActivity::class.java).let(::startActivity)
        finish()
    }

}