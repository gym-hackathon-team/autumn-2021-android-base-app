package com.example.domain.gateway.commands

import com.example.domain.entities.CommandsEntity
import io.reactivex.Completable
import io.reactivex.Single
import java.io.File

interface CommandsGateway {

    fun postCommand(file: File): Single<CommandsEntity>
    fun registerVoice(file: File): Completable
}