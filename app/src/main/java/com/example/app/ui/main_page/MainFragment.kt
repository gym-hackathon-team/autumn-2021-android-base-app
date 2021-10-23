package com.example.app.ui.main_page

import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentTemplateBinding
import com.example.app.ui.base.BaseFragment


class MainFragment : BaseFragment<FragmentTemplateBinding>()  {

    override val viewModel: MainFragmentViewModel by fragmentViewModel()


    override fun getBinding(): FragmentTemplateBinding {
        return FragmentTemplateBinding.inflate(layoutInflater)
    }
}
