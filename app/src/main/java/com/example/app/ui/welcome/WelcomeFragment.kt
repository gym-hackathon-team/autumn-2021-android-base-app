package com.example.app.ui.welcome

import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentWelcomeBinding
import com.example.app.ui.base.BaseFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {

    override val viewModel: WelcomeViewModel by fragmentViewModel()

    override fun setupListeners() {
        views.bSignUp.setOnClickListener {
            WelcomeFragmentDirections.navigateToSignUp().let(findNavController()::navigate)
        }
        views.bSignIn.setOnClickListener {
            WelcomeFragmentDirections.navigateToSignIn().let(findNavController()::navigate)
        }
    }

    override fun getBinding(): FragmentWelcomeBinding {
        return FragmentWelcomeBinding.inflate(layoutInflater)
    }

}