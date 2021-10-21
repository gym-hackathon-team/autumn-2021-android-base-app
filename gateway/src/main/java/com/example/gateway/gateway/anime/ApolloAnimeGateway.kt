package com.example.gateway.gateway.anime

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.rx3.rxQuery
import com.example.app.GetAnimeListQuery
import com.example.domain.gateway.anime.AnimeGateway
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ApolloAnimeGateway @Inject constructor(
    private val apolloClient: ApolloClient
): AnimeGateway {

    override fun fetchAnime() {
        val result = apolloClient.rxQuery(GetAnimeListQuery(Input.optional(0)))
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                Timber.e(it.data.toString())
            }, {
                it.printStackTrace()
            })
    }

}