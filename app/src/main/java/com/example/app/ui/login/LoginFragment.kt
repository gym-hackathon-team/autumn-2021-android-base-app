package com.example.app.ui.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentAuthBinding
import com.example.app.ui.base.BaseFragment
import com.readystatesoftware.chuck.internal.ui.MainActivity
import android.content.Context.MODE_PRIVATE
import android.widget.Toast


class LoginFragment : BaseFragment<FragmentAuthBinding>()  {

    override val viewModel: LoginViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setupListeners() {
        super.setupListeners()
        views.actionButton.setOnClickListener{
            viewModel.authUser(views.inputLogin.toString(),views.inputPassword.toString())
        }
        viewModel.tokenSLE.observe(viewLifecycleOwner,{
            handle(it)
        })
        viewModel.errorSLE.observe(viewLifecycleOwner,{
            Toast.makeText(requireContext(), "Неправильный логин или пароль", Toast.LENGTH_LONG).show()
        })
    }
        private fun handle(token: String) {
            makeSPWithToken(token)
            Intent(context, com.example.app.ui.main.MainActivity::class.java).let(::startActivity)
                activity?.finish()
            }

   private fun makeSPWithToken(token: String){
       val  settings:SharedPreferences  = requireContext().getSharedPreferences("TOKENSP", Context.MODE_PRIVATE)
       val editor :SharedPreferences.Editor= settings.edit()
       editor.putString( "TOKEN", token )
       editor.apply()
   }
    override fun getBinding(): FragmentAuthBinding {
        return FragmentAuthBinding.inflate(layoutInflater)

    }

}
