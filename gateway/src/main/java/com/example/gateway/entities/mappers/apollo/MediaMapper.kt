package com.example.gateway.entities.mappers.apollo

import com.example.app.GetAnimeListQuery
import com.example.domain.entities.MediaEntity
import com.example.gateway.entities.mappers.base.BaseApolloMapper

object MediaMapper: BaseApolloMapper<GetAnimeListQuery.Medium, MediaEntity> {

    override fun map(apolloModel: GetAnimeListQuery.Medium): MediaEntity {
        return MediaEntity(
            id = apolloModel.id,
            title = TitleMapper.map(apolloModel.title)
        )
    }
}