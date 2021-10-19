package com.example.app.ui.main

import com.airbnb.mvrx.viewModel
import com.example.app.databinding.ActivityMainBinding
import com.example.app.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModel()

    override fun getBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

}