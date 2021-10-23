package com.example.app.ui.payments_list.recycler_view.payments

import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import com.example.app.databinding.ItemPaymentBinding
import com.example.app.ui.base.recycler_view.BaseAdapter
import com.example.app.ui.payments_list.recycler_view.payments.model.PaymentType
import com.example.app.ui.payments_list.recycler_view.payments.model.getDrawable
import com.example.app.ui.payments_list.recycler_view.payments.model.getTitle

class PaymentsAdapter : BaseAdapter<ItemPaymentBinding, PaymentType, PaymentsAdapter.PaymentViewHolder>() {

    interface Callback: BaseAdapter.Callback<PaymentType>

    init {
        val items = PaymentType.values().toList()
        applyItems(items)
    }

    override fun getViewHolder(layoutInflater: LayoutInflater): PaymentViewHolder {
        return PaymentViewHolder(
            ItemPaymentBinding.inflate(layoutInflater)
        )
    }

    inner class PaymentViewHolder(
        views: ItemPaymentBinding
    ) : BaseAdapter.BaseViewHolder<ItemPaymentBinding, PaymentType>(views) {

        override fun bind(item: PaymentType) {
            super.bind(item)
            views.ivPaymentIcon.setImageDrawable(
                ContextCompat.getDrawable(itemView.context, item.getDrawable())
            )
            views.tvPaymentTitle.setText(item.getTitle())
            itemView.setOnClickListener {
                callback?.onItemClicked(item)
            }
        }
    }
}