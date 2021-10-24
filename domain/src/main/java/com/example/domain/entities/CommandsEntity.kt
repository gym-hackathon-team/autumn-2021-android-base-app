package com.example.domain.entities

import java.io.Serializable

data class CommandsEntity(
    val decision: Boolean,
    val voiceCommand: Command?
): BaseEntity

enum class Command: Serializable {
    ORGANIZATION_PAYMENT,
    USER_TRANSACTION
}