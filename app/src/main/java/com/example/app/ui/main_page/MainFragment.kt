package com.example.app.ui.main_page

import android.os.Bundle
import android.view.View
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentMainBinding
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.main_page.recycler_view.CardAdapter
import com.example.app.ui.main_page.recycler_view.model.CardModel


class MainFragment : BaseFragment<FragmentMainBinding>() {

    override val viewModel: MainFragmentViewModel by fragmentViewModel()


    override fun getBinding(): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=CardAdapter()
        views.rvTransfer.adapter = adapter
        adapter.items= arrayListOf(CardModel("1234","200"),CardModel("12324","200"),CardModel("1234","200"))
    }
}
