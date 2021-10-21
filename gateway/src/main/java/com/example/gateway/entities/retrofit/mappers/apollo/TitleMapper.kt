package com.example.gateway.entities.retrofit.mappers.apollo

import com.example.app.GetAnimeListQuery
import com.example.domain.entities.TitleEntity
import com.example.gateway.entities.retrofit.base.BaseApolloMapper

object TitleMapper: BaseApolloMapper<GetAnimeListQuery.Title, TitleEntity> {

    override fun map(apolloModel: GetAnimeListQuery.Title): TitleEntity {
        return TitleEntity(
            romaji = apolloModel.romaji,
            english = apolloModel.english,
            native = apolloModel.native_,
            userPreferred = apolloModel.userPreferred
        )
    }
}