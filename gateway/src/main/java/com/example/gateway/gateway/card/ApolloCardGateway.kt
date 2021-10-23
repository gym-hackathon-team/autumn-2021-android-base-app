package com.example.gateway.gateway.card

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.rx2.rxQuery
import com.example.app.GetAnimeListQuery
import com.example.domain.entities.MediaEntity
import com.example.domain.entities.PaginationEntity
import com.example.domain.gateway.anime.CardGateway
import com.example.gateway.entities.mappers.apollo.AnimeListMapper
import com.example.gateway.gateway.base.BaseApolloGateway
import io.reactivex.Observable
import javax.inject.Inject

class ApolloCardGateway @Inject constructor(
    private val apolloClient: ApolloClient
): BaseApolloGateway<GetAnimeListQuery.Data, PaginationEntity<MediaEntity>>(AnimeListMapper), CardGateway {

    override fun fetchAnime(): Observable<PaginationEntity<MediaEntity>> = withMapper {
        apolloClient.rxQuery(GetAnimeListQuery(Input.optional(0)))
    }
}