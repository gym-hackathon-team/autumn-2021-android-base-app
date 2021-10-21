package com.example.gateway.gateway.anime

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.rx2.rxQuery
import com.example.app.GetAnimeListQuery
import com.example.domain.entities.MediaEntity
import com.example.domain.entities.PaginationEntity
import com.example.domain.gateway.anime.AnimeGateway
import com.example.gateway.entities.retrofit.mappers.apollo.AnimeListMapper
import com.example.gateway.gateway.base.BaseApolloGateway
import io.reactivex.Observable
import javax.inject.Inject

class ApolloAnimeGateway @Inject constructor(
    private val apolloClient: ApolloClient
): BaseApolloGateway<GetAnimeListQuery.Data, PaginationEntity<MediaEntity>>(AnimeListMapper), AnimeGateway {

    override fun fetchAnime(): Observable<PaginationEntity<MediaEntity>> = withMapper {
        apolloClient.rxQuery(GetAnimeListQuery(Input.optional(0)))
    }
}