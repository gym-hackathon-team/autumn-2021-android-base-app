package com.example.app.ui.main_page

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.*
import com.example.app.R
import com.example.app.databinding.FragmentMainBinding
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.main_page.recycler_view.model.CardModel
import com.example.app.ui.payment.recycler_view.CardAdapter


class MainFragment : BaseFragment<FragmentMainBinding>() {

    override val viewModel: MainFragmentViewModel by fragmentViewModel()

    private val adapter = CardAdapter()

    override fun getBinding(): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater)
    }

    override fun setupListeners() {
        viewModel.onEach(MainFragmentViewState::cards) {
            handleCardsUpdate(it)
        }
        views.swipeRefreshLayout.setOnRefreshListener {
            viewModel.handle(MainFragmentViewActions.OnSwipeToRefresh)
        }
    }

    override fun setupAdapters() {
        views.rvCards.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(requireContext(), RecyclerView.HORIZONTAL)
        val dividerDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.decoration_transfer_divider)!!
        dividerItemDecoration.setDrawable(dividerDrawable)
        views.rvCards.addItemDecoration(dividerItemDecoration)
    }

    private fun handleCardsUpdate(cards: Async<List<CardModel>>) {
        when (cards) {
            Uninitialized -> Unit
            is Loading -> toggleSwipeRefresh(true)
            is Success -> {
                toggleSwipeRefresh(false)
                adapter.applyItems(cards.invoke())
            }
            is Fail -> {
                toggleSwipeRefresh(false)
            }
        }
    }

    private fun toggleSwipeRefresh(isRefreshing: Boolean) {
        views.swipeRefreshLayout.isRefreshing = isRefreshing
    }
}
