package com.example.app.ui.payment

import android.os.Bundle
import android.text.Editable
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentPaymentBinding
import com.example.app.ui.base.BaseFragment
import android.text.TextWatcher
import android.view.View


class PaymentFragment : BaseFragment<FragmentPaymentBinding>()  {

    override val viewModel: PaymentViewModel by fragmentViewModel()
    override fun setupListeners() {
        super.setupListeners()
        setupIvAmountListener()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        views.ivOrganizationAccount.action
    }

    private fun setupIvAmountListener() {
        views.ivAmount.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val text=views.ivAmount.text.toString()
                if (text.isEmpty()){
                    return
                }
                if (text[0] == '.'){
                    views.ivAmount.setText("")
                    return
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    override fun getBinding(): FragmentPaymentBinding {
        return FragmentPaymentBinding.inflate(layoutInflater)
    }
}