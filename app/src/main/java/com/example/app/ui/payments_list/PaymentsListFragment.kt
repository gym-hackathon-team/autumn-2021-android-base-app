package com.example.app.ui.payments_list

import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.R
import com.example.app.databinding.FragmentPaymentListBinding
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.payments_list.recycler_view.payments.PaymentsAdapter
import com.example.app.ui.payments_list.recycler_view.payments.model.PaymentType
import com.example.app.ui.payments_list.recycler_view.transfers.TransfersAdapter
import com.example.app.ui.payments_list.recycler_view.transfers.model.TransferType
import com.example.app.utils.TypesOperation


class PaymentsListFragment : BaseFragment<FragmentPaymentListBinding>()  {

    override val viewModel: PaymentsListViewModel by fragmentViewModel()

    private val paymentsAdapter = PaymentsAdapter()
    private val transfersAdapter = TransfersAdapter()

    override fun getBinding(): FragmentPaymentListBinding {
        return FragmentPaymentListBinding.inflate(layoutInflater)
    }

    override fun setupAdapters() {
        views.rvPayments.layoutManager = GridLayoutManager(requireContext(), 3, GridLayoutManager.HORIZONTAL, false)
        views.rvPayments.adapter = paymentsAdapter
        paymentsAdapter.callback = object: PaymentsAdapter.Callback {
            override fun onItemClicked(item: PaymentType) {
               val arg = bundleOf("OPERATION" to TypesOperation.Payment)
               findNavController().navigate(R.id.navigate_to_payment,arg)
//                PaymentsListFragmentDirections.navigateToPayment().let(findNavController()::navigate)
            }
        }

        views.rvTransfer.adapter = transfersAdapter
        val dividerItemDecoration = DividerItemDecoration(requireContext(), RecyclerView.HORIZONTAL)
        val dividerDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.decoration_transfer_divider)!!
        dividerItemDecoration.setDrawable(dividerDrawable)
        views.rvTransfer.addItemDecoration(dividerItemDecoration)
        transfersAdapter.callback = object: TransfersAdapter.Callback {
            override fun onItemClicked(item: TransferType) {
                val arg = bundleOf("OPERATION" to TypesOperation.Transfer)
                findNavController().navigate(R.id.navigate_to_payment,arg)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


}
