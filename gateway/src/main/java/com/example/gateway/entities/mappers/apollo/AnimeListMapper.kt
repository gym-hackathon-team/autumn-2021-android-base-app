package com.example.gateway.entities.mappers.apollo

import com.example.app.GetAnimeListQuery
import com.example.domain.entities.MediaEntity
import com.example.domain.entities.PaginationEntity
import com.example.gateway.entities.mappers.base.BaseApolloMapper

object AnimeListMapper: BaseApolloMapper<GetAnimeListQuery.Data, PaginationEntity<MediaEntity>> {

    override fun map(apolloModel: GetAnimeListQuery.Data): PaginationEntity<MediaEntity> {
        return PaginationEntity(
            pageInfo = PageInfoMapper.map(apolloModel.page.pageInfo),
            data = apolloModel.page.media.map { MediaMapper.map(it) }
        )
    }
}