package com.example.domain.gateway.anime

import com.example.domain.entities.MediaEntity
import com.example.domain.entities.PaginationEntity
import io.reactivex.Observable

interface CardGateway {

    fun fetchAnime(): Observable<PaginationEntity<MediaEntity>>
}