package com.example.app.ui.confirmation

import com.example.app.ui.base.BaseViewActions


sealed class ConfirmationFragmentViewActions: BaseViewActions {
    data class ActionConfirm(
        val accountId: String,
        val amount: Float,
        val fromAccount: String,
        val isPayment: Boolean
    ): ConfirmationFragmentViewActions()
}
