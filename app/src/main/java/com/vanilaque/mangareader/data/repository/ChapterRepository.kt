package com.vanilaque.mangareader.data.repository

import com.vanilaque.mangareader.data.model.Chapter
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.data.model.WebtoonWithChapters

interface ChapterRepository {
    suspend fun insertChapter(chapter: Chapter)

    suspend fun getChaptersForWebtoon(webtoon: Webtoon): List<WebtoonWithChapters>

    suspend fun getChapter(slug: String): Chapter

    suspend fun clearChapters()

    suspend fun deleteChapter(chapter: Chapter)

    suspend fun getChaptersPaginatedFromServer(
        provider: Provider,
        webtoon: String,
        page: Int,
        limit: Int
    ): List<Chapter>

    suspend fun getChaptersFromServer(
        provider: Provider,
        webtoon: String,
    ): List<Chapter>

    suspend fun getLastUpdatedFromServer(
        provider: Provider,
        day: Int
    ): List<Chapter>

    suspend fun getChapterBySlugFromServer(
        provider: Provider,
        mangaSlug: String,
        chapterSlug: String
    ): Chapter
}