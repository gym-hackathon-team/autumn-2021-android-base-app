package com.example.app.ui.blank

import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentTemplateBinding
import com.example.app.ui.base.BaseFragment


class TemplateFragment : BaseFragment<FragmentTemplateBinding>()  {

    override val viewModel: TemplateViewModel by fragmentViewModel()


    override fun getBinding(): FragmentTemplateBinding {
        return FragmentTemplateBinding.inflate(layoutInflater)
    }
}
