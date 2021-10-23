package com.example.app.ui.payments_list.recycler_view.transfers.model

import com.example.app.R
import com.example.app.ui.base.recycler_view.BaseModel

enum class TransferType: BaseModel {
    PHONE_NUMBER,
    BETWEEN_ACCOUNTS,
    ANOTHER_COUNTRY,
    ANOTHER_CARD,
    REQUISITES
}

fun TransferType.getDrawable(): Int {
    return when (this) {
        TransferType.PHONE_NUMBER -> R.drawable.ic_phone_number
        TransferType.BETWEEN_ACCOUNTS -> R.drawable.ic_account
        TransferType.ANOTHER_COUNTRY -> R.drawable.ic_other_country
        TransferType.ANOTHER_CARD -> R.drawable.ic_other_card
        TransferType.REQUISITES -> R.drawable.ic_requisites
    }
}

fun TransferType.getTitle(): Int {
    return when (this) {
        TransferType.PHONE_NUMBER -> R.string.transfer_mobile
        TransferType.BETWEEN_ACCOUNTS -> R.string.transfer_account
        TransferType.ANOTHER_COUNTRY -> R.string.transfer_other_country
        TransferType.ANOTHER_CARD -> R.string.transfer_other_card
        TransferType.REQUISITES -> R.string.transfer_requisites
    }
}