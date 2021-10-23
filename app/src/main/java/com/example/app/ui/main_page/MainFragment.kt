package com.example.app.ui.main_page

import android.content.Context
import android.content.Intent.getIntent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentMainBinding
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.main_page.recycler_view.CardAdapter
import com.example.app.ui.main_page.recycler_view.model.CardModel


class MainFragment : BaseFragment<FragmentMainBinding>() {
private lateinit var token:String
    override val viewModel: MainFragmentViewModel by fragmentViewModel()


    override fun getBinding(): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  settings: SharedPreferences = requireContext().getSharedPreferences("TOKENSP", Context.MODE_PRIVATE)
        val token: String? = settings.getString("TOKEN","")
        val adapter=CardAdapter()
        views.rvTransfer.adapter = adapter
        adapter.items= arrayListOf(CardModel("1234","200"),CardModel("12324","200"),CardModel("1234","200"))
    }
}
