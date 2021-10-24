package com.example.app.ui.payment.recycler_view

import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.example.app.R
import com.example.app.databinding.ItemCardBinding
import com.example.app.ui.base.recycler_view.BaseAdapter
import com.example.app.ui.main_page.recycler_view.model.CardModel

class CardAdapter : BaseAdapter<ItemCardBinding, CardModel, CardAdapter.CardViewHolder>() {

    interface OnCardClickListener : Callback<CardModel>

    var selectedCardId: String? = null

    override fun getViewHolder(layoutInflater: LayoutInflater): CardViewHolder {
        return CardViewHolder(
            ItemCardBinding.inflate(layoutInflater)
        )
    }

    inner class CardViewHolder(
        views: ItemCardBinding
    ) : BaseAdapter.BaseViewHolder<ItemCardBinding, CardModel>(views) {

        override fun bind(item: CardModel) {
            super.bind(item)
            itemView.setOnClickListener {
                callback?.onItemClicked(item)
            }
            views.ivCheck.isVisible = item.id == selectedCardId
            views.tvBalance.text = context.getString(R.string.balance, item.balance.toString())
            views.tvCardNumber.text = item.number.substring(item.number.length / 4 * 3)
        }
    }
}