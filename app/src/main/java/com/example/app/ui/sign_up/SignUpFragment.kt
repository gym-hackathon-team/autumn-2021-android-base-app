package com.example.app.ui.sign_up

import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentSignUpBinding
import com.example.app.ui.auth.AuthActivity
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.sign_in.SignInFragmentViewEvents
import com.readystatesoftware.chuck.internal.ui.MainActivity

class SignUpFragment : BaseFragment<FragmentSignUpBinding>() {

    override val viewModel: SignUpViewModel by fragmentViewModel()


    override fun getBinding(): FragmentSignUpBinding {
        return FragmentSignUpBinding.inflate(layoutInflater)
    }

    override fun setupListeners() {
        views.tvSignIn.setOnClickListener {
            SignUpFragmentDirections.navigateToSignIn().let(findNavController()::navigate)
        }
        views.bSignUp.setOnClickListener {
//            val username = views.etUsername.text.toString()
//            val password = views.etPassword.text.toString()
//            val passwordRepeat = views.etPasswordRepeat.text.toString()
//            val email = views.etEmail.text.toString()
//            viewModel.registerUser(username, password, passwordRepeat, email)
        }
        viewModel.observeViewEvents {
            when (it) {
                SignUpFragmentViewEvents.NavigateToMainActivity -> (requireActivity() as AuthActivity).navigateToMainActivity()
            }
        }
    }

}