package com.example.app.ui.succes_screen

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.accessibility.AccessibilityViewCommand
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.R
import com.example.app.databinding.FragmentSuccessBinding
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.main.MainActivity
import com.example.app.ui.splash.SplashActivityViewEvents

class SuccessFragment : BaseFragment<FragmentSuccessBinding>()  {

    override val viewModel: SuccessViewModel by fragmentViewModel()

    override fun getBinding(): FragmentSuccessBinding {
        return FragmentSuccessBinding.inflate(layoutInflater)
    }
    override fun setupListeners() {
        viewModel.observeViewEvents(::handle)
    }

    private fun handle(event: SuccessFragmentViewEvents) {
        when (event) {
            SuccessFragmentViewEvents.ChangeToErrorImage -> changeToErrorImage()
        }
    }
    private fun changeToErrorImage() {
        views.cvGoodResponse.visibility= View.INVISIBLE
        views.cvBadResponse.visibility= View.VISIBLE
    }

    override fun onStart() {
        super.onStart()
        val arguments= Bundle()
//        arguments.putBoolean("ANSWER",true)
        viewModel.handleResponse(arguments)
    }

}
