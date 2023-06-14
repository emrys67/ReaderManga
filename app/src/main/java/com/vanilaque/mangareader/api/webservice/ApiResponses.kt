package com.vanilaque.mangareader.api.webservice

import kotlinx.serialization.Serializable

@Serializable
data class Webtoon(
    val provider: String,
    val slug: String,
    val title: String,
    val sourceURL: String,
    val shortURL: String,
    val coverURL: String,
    val synopsis: String,
    val genre: List<String>,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class Chapter(
    val provider: String,
    val slug: String,
    val fullTitle: String,
    val shortTitle: String,
    val chapterNum: Int,
    val sourceURL: String,
    val shortURL: String,
    val chapterNav: ChapterNavigation,
    val contentURL: List<String>,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class ChapterNavigation(
    val nextSlug: String,
    val nextURL: String,
    val prevSlug: String,
    val prevURL: String
)