package com.example.app.ui.main_page.recycler_view.model

import com.example.app.ui.base.recycler_view.BaseModel

data class CardModel(
    val id: String,
    val balance: Float,
    val accountId: String,
    val number: String
): BaseModel