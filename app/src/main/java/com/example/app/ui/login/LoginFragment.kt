package com.example.app.ui.login

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentAuthBinding
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.main.MainActivity


class LoginFragment : BaseFragment<FragmentAuthBinding>() {

    override val viewModel: LoginViewModel by fragmentViewModel()


    override fun getBinding(): FragmentAuthBinding {
        return FragmentAuthBinding.inflate(layoutInflater)

    }

    override fun setupListeners() {
        super.setupListeners()
        views.bSignIn.setOnClickListener {
            val email = views.inputLogin.text
            val password = views.inputPassword.text
            showProgress(false)
            viewModel.authUser(email.toString(), password.toString())
        }
        viewModel.observeViewEvents(::handle)
    }

    private fun handle(event: LoginFragmentViewEvents) {
        when (event) {
            LoginFragmentViewEvents.GoToMainFragment -> handleGoToMainFragment()
            LoginFragmentViewEvents.ShowError -> handleShowError()
        }
    }

    private fun handleShowError() {
        Toast.makeText(requireContext(), "Неправильный логин или пароль", Toast.LENGTH_LONG)
            .show()
        showProgress(true)
    }

    private fun handleGoToMainFragment() {
        Intent(context, MainActivity::class.java).let(::startActivity)
        activity?.finish()
    }

    private fun showProgress(isShow: Boolean) {
        if (isShow)
            views.progress.visibility = View.GONE
        else
            views.progress.visibility = View.VISIBLE
    }

}
