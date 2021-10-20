package com.example.app.ui.service_list

import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentServiceListBinding
import com.example.app.ui.base.BaseFragment


class ServiceListFragment : BaseFragment<FragmentServiceListBinding>() {

    override val viewModel: ServiceListViewModel by fragmentViewModel()


    override fun getBinding(): FragmentServiceListBinding {
        return FragmentServiceListBinding.inflate(layoutInflater)
    }
}