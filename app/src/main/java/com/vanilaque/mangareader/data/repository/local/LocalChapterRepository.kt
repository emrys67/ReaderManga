package com.vanilaque.mangareader.data.repository.local

import com.vanilaque.mangareader.data.model.Chapter
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.data.model.WebtoonWithChapters

interface LocalChapterRepository {
    suspend fun insertChapter(chapter: Chapter)

    suspend fun getChaptersForWebtoon(webtoon: Webtoon): List<WebtoonWithChapters>

    suspend fun getChapter(slug: String): Chapter

    suspend fun clearChapters()

    suspend fun deleteChapter(chapter: Chapter)
}