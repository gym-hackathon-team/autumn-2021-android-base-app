package com.example.app.ui.payment

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.*
import com.example.app.R
import com.example.app.databinding.FragmentPaymentBinding
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.main_page.recycler_view.model.CardModel
import com.example.app.ui.payment.recycler_view.CardAdapter
import com.example.app.utils.TypesOperation


class PaymentFragment : BaseFragment<FragmentPaymentBinding>() {

    override val viewModel: PaymentViewModel by fragmentViewModel()

    private val adapter = CardAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val argument= arguments
        if (argument?.get("OPERATION")==TypesOperation.Payment){
            views.tvAccount.text="Карта зачилсения"
        } else  if (argument?.get("OPERATION")==TypesOperation.Transfer){
            views.tvAccount.text="Счет организации"
        }
    }

    override fun getBinding(): FragmentPaymentBinding {
        return FragmentPaymentBinding.inflate(layoutInflater)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setupListeners() {
        super.setupListeners()
        setupIvAmountListener()
        viewModel.onEach(PaymentFragmentViewState::cards) {
            handleCardsUpdate(it)
        }
        viewModel.onEach(PaymentFragmentViewState::selectedCard) {
            it?.let {
                adapter.selectedCardId = it.id
                adapter.notifyDataSetChanged()
            }
            views.bContinue.isEnabled = it != null
        }
        viewModel.observeViewEvents(::handle)
        views.bContinue.setOnClickListener {
            val action = PaymentFragmentViewActions.OnProceedClicked(
                accountId = views.etOrganizationAccount.text.toString(),
                amount = views.etAmount.text.toString().toFloatOrNull() ?: 0f
            )
            viewModel.handle(action)
        }
        adapter.callback = object : CardAdapter.OnCardClickListener {

            override fun onItemClicked(item: CardModel) {
                viewModel.handle(PaymentFragmentViewActions.OnCardSelected(item))
            }
        }
    }

    override fun setupAdapters() {
        views.rvCards.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(requireContext(), RecyclerView.HORIZONTAL)
        val dividerDrawable =
            ContextCompat.getDrawable(requireContext(), R.drawable.decoration_transfer_divider)!!
        dividerItemDecoration.setDrawable(dividerDrawable)
        views.rvCards.addItemDecoration(dividerItemDecoration)
    }


    private fun handle(event: PaymentFragmentViewEvents) {
        when (event) {
            is PaymentFragmentViewEvents.NavigateToConfirmation -> {
//                val arguments=bundleOf("ACCOUNT_ID" to event.fromAccount,"AMOUNT" to event.amount,"CARD_ID" to event.accountId)
//                findNavController()
//                    .navigate(R.id.navigateToConfirm,arguments)
                PaymentFragmentDirections.navigateToConfirm(
                    event.fromAccount,
                    event.amount,
                    event.accountId
                ).let(findNavController()::navigate)
            }
        }
    }

    private fun handleCardsUpdate(cards: Async<List<CardModel>>) {
        when (cards) {
            Uninitialized -> Unit
            is Loading -> Unit
            is Success -> adapter.applyItems(cards.invoke())
            is Fail -> Unit
        }
    }

    private fun setupIvAmountListener() {
        views.etAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun afterTextChanged(p0: Editable?) = Unit

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val text = views.etAmount.text.toString()
                if (text.isEmpty()) {
                    return
                }
                if (text[0] == '.') {
                    views.etAmount.setText("")
                    return
                }
            }
        })
    }
}