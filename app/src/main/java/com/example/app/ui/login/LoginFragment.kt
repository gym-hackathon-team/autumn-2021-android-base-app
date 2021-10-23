package com.example.app.ui.login

import android.os.Bundle
import android.view.View
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentAuthBinding
import com.example.app.ui.base.BaseFragment


class LoginFragment : BaseFragment<FragmentAuthBinding>()  {

    override val viewModel: LoginViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.authUser()
    }

    override fun getBinding(): FragmentAuthBinding {
        return FragmentAuthBinding.inflate(layoutInflater)
    }
}
