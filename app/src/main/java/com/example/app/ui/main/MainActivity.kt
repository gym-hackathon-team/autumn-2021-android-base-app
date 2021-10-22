package com.example.app.ui.main

import com.airbnb.mvrx.viewModel
import com.example.app.databinding.ActivityMainBinding
import com.example.app.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModel()

    override fun getBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

//    override fun onStart() {
//        super.onStart()
//        val navHostFragment = supportFragmentManager.findFragmentById(
//            R.id.nav_host_fragment_content_main
//        ) as NavHostFragment
//        views.bottomNavigationView.setupWithNavController(navHostFragment.navController)
//    }
}