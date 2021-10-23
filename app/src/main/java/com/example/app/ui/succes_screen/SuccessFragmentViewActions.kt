package com.example.app.ui.succes_screen

import com.example.app.ui.base.BaseViewActions

sealed class SuccessFragmentViewActions: BaseViewActions{
    object HandleResponse : SuccessFragmentViewActions()
}