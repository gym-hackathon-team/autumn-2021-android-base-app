package com.example.domain.entities

class PaginationEntity<T>(
    val pageInfo: PageInfoEntity,
    val data: List<T>
): BaseEntity