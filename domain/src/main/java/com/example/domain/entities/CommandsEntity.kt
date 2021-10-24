package com.example.domain.entities

data class CommandsEntity(
    val decision: Boolean,
    val voiceCommand: Command?
): BaseEntity

enum class Command {
    ORGANIZATION_PAYMENT,
    USER_TRANSACTION
}