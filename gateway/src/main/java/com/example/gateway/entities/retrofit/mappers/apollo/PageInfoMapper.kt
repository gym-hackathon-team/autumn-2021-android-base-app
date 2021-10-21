package com.example.gateway.entities.retrofit.mappers.apollo

import com.example.app.GetAnimeListQuery
import com.example.domain.entities.PageInfoEntity
import com.example.gateway.entities.retrofit.base.BaseApolloMapper

object PageInfoMapper: BaseApolloMapper<GetAnimeListQuery.PageInfo, PageInfoEntity> {

    override fun map(apolloModel: GetAnimeListQuery.PageInfo): PageInfoEntity {
        return PageInfoEntity(
            total = apolloModel.total,
            perPage = apolloModel.perPage,
            currentPage = apolloModel.currentPage,
            lastPage = apolloModel.lastPage,
            hasNextPage = apolloModel.hasNextPage
        )
    }
}