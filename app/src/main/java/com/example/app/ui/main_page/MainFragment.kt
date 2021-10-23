package com.example.app.ui.main_page

import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.*
import com.example.app.R
import com.example.app.databinding.FragmentMainBinding
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.main_page.recycler_view.CardAdapter
import com.example.app.ui.main_page.recycler_view.model.CardModel


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
            is Loading -> toggleProgressBarVisibility(true)
            is Success -> {
                toggleProgressBarVisibility(false)
                adapter.applyItems(cards.invoke())
            }
            is Fail -> {
                toggleProgressBarVisibility(false)
            }
        }
    }

    private fun toggleProgressBarVisibility(isVisible: Boolean) {
        views.progress.isVisible = isVisible
    }

}
