package com.example.app.ui.confirmation

import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentConfirmationBinding
import com.example.app.ui.base.BaseFragment


class ConfirmationFragment : BaseFragment<FragmentConfirmationBinding>()  {

    override val viewModel: ConfirmationViewModel by fragmentViewModel()


    override fun getBinding(): FragmentConfirmationBinding {
        return FragmentConfirmationBinding.inflate(layoutInflater)
    }
}
