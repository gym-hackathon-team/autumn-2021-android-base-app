package com.example.app.ui.payment

import com.example.app.ui.base.BaseViewEvents

sealed class PaymentFragmentViewEvents : BaseViewEvents {
    class NavigateToConfirmation(
        val accountId: String,
        val amount: Float,
        val fromAccount: String
    ) : PaymentFragmentViewEvents()
}