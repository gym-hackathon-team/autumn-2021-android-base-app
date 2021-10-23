package com.example.app.ui.main_page.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
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
            itemView.setOnClickListener {
                callback?.onItemClicked(item)
            }
            views.tvBalance.text = context.getString(R.string.balance, item.balance.toString())
            views.tvCardNumber.text = item.number.substring(item.number.length/4 * 3)
        }
    }
    interface OnCardClickListener {
        fun onCardClick(item: CardModel)
    }
}