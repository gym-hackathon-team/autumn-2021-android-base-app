package com.example.domain.entities


data class PageInfoEntity(
    val total: Int,
    val perPage: Int,
    val currentPage: Int,
    val lastPage: Int,
    val hasNextPage: Boolean
): BaseEntity