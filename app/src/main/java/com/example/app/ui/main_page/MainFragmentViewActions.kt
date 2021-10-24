package com.example.app.ui.main_page

import com.example.app.ui.base.BaseViewActions


sealed class MainFragmentViewActions: BaseViewActions {
    object OnSwipeToRefresh: MainFragmentViewActions()
}
