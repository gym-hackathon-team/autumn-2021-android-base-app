package com.example.app.ui.sign_in

import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentSignInBinding
import com.example.app.ui.auth.AuthActivity
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.main.MainActivity

class SignInFragment : BaseFragment<FragmentSignInBinding>() {

    override val viewModel: SignInViewModel by fragmentViewModel()


    override fun getBinding(): FragmentSignInBinding {
        return FragmentSignInBinding.inflate(layoutInflater)
    }

    override fun setupListeners() {
        views.tvSignUp.setOnClickListener {
            SignInFragmentDirections.navigateToSignUp().let(findNavController()::navigate)
        }
    }

    override fun setupAdapters() {
        viewModel.observeViewEvents {
            when (it) {
                SignInFragmentViewEvents.NavigateToMainActivity -> handleNavigateToMainActivity()
            }
        }
    }

    private fun handleNavigateToMainActivity() {
        (requireActivity() as AuthActivity).navigateToMainActivity()
    }

}