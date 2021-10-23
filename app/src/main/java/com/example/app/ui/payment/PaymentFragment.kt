package com.example.app.ui.payment

import android.os.Bundle
import android.text.Editable
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentPaymentBinding
import com.example.app.ui.base.BaseFragment
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.ui.main_page.recycler_view.CardAdapter
import com.example.app.ui.main_page.recycler_view.model.CardModel
import com.example.app.ui.payments_list.PaymentsListFragmentDirections
import com.example.app.ui.payments_list.recycler_view.payments.PaymentsAdapter
import com.example.app.ui.payments_list.recycler_view.payments.model.PaymentType


class PaymentFragment : BaseFragment<FragmentPaymentBinding>()  {
    private val adapter = CardAdapter()
    override val viewModel: PaymentViewModel by fragmentViewModel()
    override fun setupListeners() {
        super.setupListeners()
        setupIvAmountListener()
        views.actionButton.setOnClickListener {
            PaymentFragmentDirections.navigateToConfirm().let(findNavController()::navigate)
        }
        adapter.onCardClickListener = object : CardAdapter.OnCardClickListener {
            override fun onCardClick(item: CardModel) {
                Toast.makeText(requireContext(), "Выбрана карта заканчивающаяся на ${item.cardNumbers}", Toast.LENGTH_SHORT).show()
            }
    }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.rvCards.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(requireContext(), RecyclerView.HORIZONTAL)
        val dividerDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.decoration_transfer_divider)!!
        dividerItemDecoration.setDrawable(dividerDrawable)
        views.rvCards.addItemDecoration(dividerItemDecoration)

        adapter.items = arrayListOf(
            CardModel("1234123412341234", "1"),
            CardModel("1234123412341234", "23300"),
            CardModel("1234123412341234", "2200"),
            CardModel("1234123412341234", "200"),
            CardModel("1234123412341234", "200"),
            CardModel("1234123412341234", "200")
        )
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