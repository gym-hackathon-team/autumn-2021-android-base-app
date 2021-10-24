package com.example.app.ui.blank

import com.example.app.ui.base.BaseViewEvents


sealed class TemplateFragmentViewEvents: BaseViewEvents {
    object ShowToast : TemplateFragmentViewEvents()
}
