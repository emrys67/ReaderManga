package com.vanilaque.mangareader.util

import com.vanilaque.mangareader.api.webservice.Chapter

fun Chapter.toDbModel(mangaSlug: String): com.vanilaque.mangareader.data.model.Chapter {
    return com.vanilaque.mangareader.data.model.Chapter(chapterSlug = this.slug, mangaSlug = mangaSlug,
        providerSlug = this.provider, fullTitle = this.fullTitle, shortTitle = this.shortTitle,
        chapterNum = this.chapterNum, sourceURL = this.sourceURL, shortURL = this.shortURL, contentURL = this.contentURL,
    createdAt = this.createdAt, updatedAt = this.updatedAt)
}