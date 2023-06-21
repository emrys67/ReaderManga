package com.vanilaque.mangareader.data.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vanilaque.mangareader.data.model.Chapter
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.data.model.WebtoonWithChapters
import com.vanilaque.mangareader.util.CHAPTER_DATABASE_TABLE
import com.vanilaque.mangareader.util.WEBTOON_DATABASE_TABLE
import retrofit2.Response
import javax.inject.Inject

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

    suspend fun getLastUpdatedFromServer(
        provider: Provider,
        day: Int
    ): List<Chapter>
}