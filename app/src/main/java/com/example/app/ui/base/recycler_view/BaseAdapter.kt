@file:SuppressLint("NotifyDataSetChanged")
package com.example.app.ui.base.recycler_view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.app.ui.payments_list.recycler_view.payments.model.PaymentType

abstract class BaseAdapter<
        VB: ViewBinding,
        T: BaseModel,
        VH: BaseAdapter.BaseViewHolder<VB, T>
>: RecyclerView.Adapter<VH>() {

    interface Callback<T> {
        fun onItemClicked(item: T)
    }

    var callback: Callback<T>? = null
    protected var items: List<T> = listOf()

    fun applyItems(newItems: List<T>) {
        this.items = newItems
        notifyDataSetChanged()
    }

    abstract fun getViewHolder(layoutInflater: LayoutInflater): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return getViewHolder(
            layoutInflater = LayoutInflater.from(parent.context)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    abstract class BaseViewHolder<VB: ViewBinding, T: BaseModel>(
        protected val views: VB
    ) : RecyclerView.ViewHolder(views.root) {

        protected lateinit var context: Context
        protected lateinit var item: T

        @CallSuper
        open fun bind(item: T) {
            this.item = item
            this.context = itemView.context
        }
    }
}