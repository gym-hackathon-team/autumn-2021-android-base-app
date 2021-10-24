package com.example.app.ui.confirmation

import com.example.app.ui.base.BaseViewEvents


sealed class ConfirmationFragmentViewEvents: BaseViewEvents {
    data class NavigateToResult(val status: Boolean): ConfirmationFragmentViewEvents()
}