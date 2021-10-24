package com.example.gateway.entities.mappers.retrofit

import com.example.domain.entities.Command
import com.example.domain.entities.CommandsEntity
import com.example.gateway.entities.mappers.base.BaseRetrofitMapper
import com.example.gateway.entities.retrofit.response.CommandsResponse

object RetrofitCommandMapper : BaseRetrofitMapper<CommandsResponse, CommandsEntity> {
    override fun map(retrofitModel: CommandsResponse): CommandsEntity {
        return CommandsEntity(
            decision = retrofitModel.decision,
            voiceCommand = when (retrofitModel.voiceCommand) {
                "ORGANIZATION_PAYMENT" -> Command.ORGANIZATION_PAYMENT
                "USER_TRANSACTION" -> Command.USER_TRANSACTION
                else -> null
            }
        )
    }

    override fun map(entity: CommandsEntity): CommandsResponse {
        TODO("Not yet implemented")
    }
}