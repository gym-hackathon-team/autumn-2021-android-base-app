package com.example.gateway.gateway.commands

import com.example.domain.entities.CommandsEntity
import com.example.domain.gateway.commands.CommandsGateway
import com.example.gateway.entities.mappers.retrofit.RetrofitCommandMapper
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject

class RetrofitCommandsGateway @Inject constructor(
    private val commandsApi: CommandsApi
): CommandsGateway {

    override fun postCommand(file: File): Single<CommandsEntity> {
        val requestFile: RequestBody = RequestBody.create(
            MediaType.parse("audio/mp4"),
            file
        )
        val body: MultipartBody.Part =
            MultipartBody.Part.createFormData("files[0]", file.name, requestFile)
        val call = commandsApi.uploadFile(body)
        return call.flatMap {
            Single.just(RetrofitCommandMapper.map(it))
        }
    }
}