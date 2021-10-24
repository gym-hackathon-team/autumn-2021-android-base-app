package com.example.app.ui.succes_screen

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.R
import com.example.app.databinding.FragmentSuccessBinding
import com.example.app.ui.base.BaseFragment
import com.example.app.ui.confirmation.ConfirmationFragmentArgs

class SuccessFragment : BaseFragment<FragmentSuccessBinding>()  {

    override val viewModel: SuccessViewModel by fragmentViewModel()

    private val args: SuccessFragmentArgs by navArgs()


    override fun getBinding(): FragmentSuccessBinding {
        return FragmentSuccessBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    override fun setupListeners() {
        views.bContinue.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupUI() {
        if (!args.success) {
            views.operationSuccess.setText(R.string.result_failure)
            views.cvGoodResponse.visibility= View.INVISIBLE
            views.cvBadResponse.visibility= View.VISIBLE
        } else {
            views.operationSuccess.setText(R.string.result_success)
        }
    }
}
