package com.example.app.ui.main_page

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.R
import com.example.app.databinding.FragmentMainBinding
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.main_page.recycler_view.CardAdapter
import com.example.app.ui.main_page.recycler_view.model.CardModel


class MainFragment : BaseFragment<FragmentMainBinding>() {
    private lateinit var token: String
    override val viewModel: MainFragmentViewModel by fragmentViewModel()

    private val adapter = CardAdapter()

    override fun getBinding(): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater)
    }

    override fun setupAdapters() {
        views.rvCards.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(requireContext(), RecyclerView.HORIZONTAL)
        val dividerDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.decoration_transfer_divider)!!
        dividerItemDecoration.setDrawable(dividerDrawable)
        views.rvCards.addItemDecoration(dividerItemDecoration)
    }
}
