package com.example.app.ui.payment

import com.example.app.ui.base.BaseViewActions
import com.example.app.ui.main_page.recycler_view.model.CardModel

sealed class PaymentFragmentViewActions: BaseViewActions {
    data class OnCardSelected(val cardModel: CardModel): PaymentFragmentViewActions()
    data class OnProceedClicked(val accountId: String, val amount: Float): PaymentFragmentViewActions()
}