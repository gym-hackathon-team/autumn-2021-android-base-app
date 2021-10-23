package com.example.app.ui.payments_list.recycler_view.transfers

import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import com.example.app.databinding.ItemTransferBinding
import com.example.app.ui.base.recycler_view.BaseAdapter
import com.example.app.ui.payments_list.recycler_view.payments.model.PaymentType
import com.example.app.ui.payments_list.recycler_view.transfers.model.TransferType
import com.example.app.ui.payments_list.recycler_view.transfers.model.getDrawable
import com.example.app.ui.payments_list.recycler_view.transfers.model.getTitle

class TransfersAdapter : BaseAdapter<ItemTransferBinding, TransferType, TransfersAdapter.TransferViewHolder>() {

    interface Callback: BaseAdapter.Callback<TransferType>

    init {
        val items = TransferType.values().toList()
        applyItems(items)
    }

    override fun getViewHolder(layoutInflater: LayoutInflater): TransferViewHolder {
        return TransferViewHolder(
            ItemTransferBinding.inflate(layoutInflater)
        )
    }

    inner class TransferViewHolder(
        views: ItemTransferBinding
    ): BaseAdapter.BaseViewHolder<ItemTransferBinding, TransferType>(views) {

        override fun bind(item: TransferType) {
            super.bind(item)
            views.ivTransfer.setImageDrawable(ContextCompat.getDrawable(context, item.getDrawable()))
            views.tvTransfer.setText(item.getTitle())
            itemView.setOnClickListener {
                callback?.onItemClicked(item)
            }
        }
    }
}