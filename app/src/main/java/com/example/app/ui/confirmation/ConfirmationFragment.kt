package com.example.app.ui.confirmation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.R
import com.example.app.databinding.FragmentConfirmationBinding
import com.example.app.ui.base.BaseFragment


class ConfirmationFragment : BaseFragment<FragmentConfirmationBinding>() {

    override val viewModel: ConfirmationViewModel by fragmentViewModel()

    private val args: ConfirmationFragmentArgs by navArgs()


    override fun getBinding(): FragmentConfirmationBinding {
        return FragmentConfirmationBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    override fun setupListeners() {
        viewModel.observeViewEvents(::handle)
        views.bContinue.setOnClickListener {
            viewModel.handle(
                ConfirmationFragmentViewActions.ActionConfirm(
                    accountId = args.accountId,
                    amount = args.amount,
                    fromAccount = args.cardId
                )
            )
        }
    }

    private fun handle(event: ConfirmationFragmentViewEvents) {
        when (event) {
            is ConfirmationFragmentViewEvents.NavigateToResult -> handleNavigateToResult(event)
        }
    }

    private fun handleNavigateToResult(event: ConfirmationFragmentViewEvents.NavigateToResult) {
        ConfirmationFragmentDirections.actionConfirmationFragmentToSuccessFragment(event.status)
            .let(findNavController()::navigate)
    }

    private fun setupUi() {
        views.tvFrom.text = args.cardId
        views.tvTo.text = args.accountId
        views.tvAmount.text = requireContext().getString(R.string.balance, args.amount.toString())
    }
}
