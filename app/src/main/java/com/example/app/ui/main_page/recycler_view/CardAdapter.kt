package com.example.app.ui.main_page.recycler_view

import android.view.LayoutInflater
import com.example.app.databinding.ItemCardBinding
import com.example.app.ui.base.recycler_view.BaseAdapter
import com.example.app.ui.main_page.recycler_view.model.CardModel

class CardAdapter: BaseAdapter<ItemCardBinding, CardModel, CardAdapter.CardViewHolder>() {
    var onCardClickListener: OnCardClickListener? = null
    override fun getViewHolder(layoutInflater: LayoutInflater): CardViewHolder {
        return CardViewHolder(
            ItemCardBinding.inflate(layoutInflater),onCardClickListener
        )
    }

    inner class CardViewHolder(views: ItemCardBinding, private val onCardClickListener: CardAdapter.OnCardClickListener?) : BaseAdapter.BaseViewHolder<ItemCardBinding, CardModel>(views) {

        override fun bind(item: CardModel) {
            super.bind(item)
            views.tvBalance.text="${item.balance} ₽"
            views.tvCardNumber.text=item.cardNumbers.substring(item.cardNumbers.lastIndex-4,item.cardNumbers.lastIndex)
            itemView.setOnClickListener {
                callback?.onItemClicked(item)
            }
            itemView.setOnClickListener {
                item.let { it1 -> onCardClickListener?.onCardClick(it1) }
            }
        }
    }
    interface OnCardClickListener {
        fun onCardClick(item: CardModel)
    }
}