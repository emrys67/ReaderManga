package com.vanilaque.mangareader.util

import com.vanilaque.mangareader.api.webservice.Chapter
import com.vanilaque.mangareader.api.webservice.Webtoon
import java.time.Instant

fun Chapter.toDbModel(mangaSlug: String): com.vanilaque.mangareader.data.model.Chapter {
    return com.vanilaque.mangareader.data.model.Chapter(
        chapterSlug = this.slug,
        mangaSlug = mangaSlug,
        providerSlug = this.provider,
        fullTitle = this.fullTitle,
        shortTitle = this.shortTitle,
        chapterNum = this.chapterNum,
        sourceURL = this.sourceURL,
        shortURL = this.shortURL,
        contentURL = this.contentURL,
        createdAt = Instant.parse(this.createdAt),
        updatedAt = Instant.parse(this.updatedAt)
    )
}

fun Webtoon.toDbModel(): com.vanilaque.mangareader.data.model.Webtoon {
    return com.vanilaque.mangareader.data.model.Webtoon(
        mangaSlug = this.slug,
        providerBaseUrl = this.provider,
        title = this.title,
        sourceURL = this.sourceURL,
        shortURL = this.shortURL,
        coverURL = this.coverURL,
        synopsis = this.synopsis,
        genre = this.genre,
        createdAt = Instant.parse(this.createdAt),
        updatedAt = Instant.parse(this.updatedAt)
    )
}