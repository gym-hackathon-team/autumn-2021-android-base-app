package com.example.app.ui.profile

import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentProfileBinding
import com.example.app.ui.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override val viewModel: ProfileViewModel by fragmentViewModel()


    override fun getBinding(): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(layoutInflater)
    }
}