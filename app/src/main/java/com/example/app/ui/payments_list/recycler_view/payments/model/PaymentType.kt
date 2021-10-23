package com.example.app.ui.payments_list.recycler_view.payments.model

import com.example.app.R
import com.example.app.ui.base.recycler_view.BaseModel

enum class PaymentType: BaseModel {
    QR,
    MOBILE,
    SERVICES,
    TV,
    PENALTIES,
    TAXES
}

fun PaymentType.getDrawable(): Int {
    return when (this) {
        PaymentType.QR -> R.drawable.ic_barcode
        PaymentType.MOBILE -> R.drawable.ic_phone
        PaymentType.SERVICES -> R.drawable.ic_services
        PaymentType.TV -> R.drawable.ic_tv
        PaymentType.PENALTIES -> R.drawable.ic_car
        PaymentType.TAXES -> R.drawable.ic_gov
    }
}

fun PaymentType.getTitle(): Int {
    return when (this) {
        PaymentType.QR -> R.string.transfer_qr
        PaymentType.MOBILE -> R.string.payment_mobile
        PaymentType.SERVICES -> R.string.payment_services
        PaymentType.TV -> R.string.payment_tv
        PaymentType.PENALTIES -> R.string.payment_penalties
        PaymentType.TAXES -> R.string.payment_taxes
    }
}