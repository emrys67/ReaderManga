package com.vanilaque.mangareader.util

import android.os.Build
import androidx.annotation.RequiresApi
import com.vanilaque.mangareader.api.webservice.Chapter
import com.vanilaque.mangareader.api.webservice.Webtoon
import java.time.Instant

@RequiresApi(Build.VERSION_CODES.O)
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
        createdAt = if (!this.createdAt.isNullOrEmpty()) Instant.parse(this.createdAt) else null,
        updatedAt = if (!this.updatedAt.isNullOrEmpty()) Instant.parse(this.updatedAt) else null,
        nextChapterSlug = this.chapterNav?.nextSlug,
        privChapterSlug = this.chapterNav?.prevSlug

    )
}

@RequiresApi(Build.VERSION_CODES.O)
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
        createdAt = if (this.createdAt != null) Instant.parse(this.createdAt) else null,
        updatedAt = if (this.createdAt != null) Instant.parse(this.updatedAt) else null,
        lastOpenedAt = null,
        addedToFavoritesAt = null
    )
}