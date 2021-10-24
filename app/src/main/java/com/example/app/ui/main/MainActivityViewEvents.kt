package com.example.app.ui.main

import com.example.app.ui.base.BaseViewEvents
import com.example.domain.entities.CommandsEntity

sealed class MainActivityViewEvents: BaseViewEvents {
    data class PerformCommand(
        val it: CommandsEntity
    ): MainActivityViewEvents()
}