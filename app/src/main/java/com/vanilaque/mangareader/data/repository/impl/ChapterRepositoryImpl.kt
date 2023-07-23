package com.vanilaque.mangareader.data.repository.impl

import com.vanilaque.mangareader.api.webservice.MangaScraperApi
import com.vanilaque.mangareader.data.model.Chapter
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.data.model.WebtoonWithChapters
import com.vanilaque.mangareader.data.repository.ChapterRepository
import com.vanilaque.mangareader.data.repository.local.LocalChapterRepository
import com.vanilaque.mangareader.util.MANGA_SCRAPER_HOST
import com.vanilaque.mangareader.util.MANGA_SCRAPER_KEY
import com.vanilaque.mangareader.util.toDbModel
import javax.inject.Inject

class ChapterRepositoryImpl @Inject constructor(
    private val localChapterRepository: LocalChapterRepository,
    private val mangaScraperApi: MangaScraperApi
) : ChapterRepository {

    override suspend fun insertChapter(chapter: Chapter) {
        localChapterRepository.insertChapter(chapter)
    }

    override suspend fun getChaptersForWebtoon(webtoon: Webtoon): List<WebtoonWithChapters> {
        return listOf()
        //chapterDao.getChaptersForWebtoon(webtoon)
    }

    override suspend fun getChapter(slug: String): Chapter {
        return localChapterRepository.getChapter(slug)
    }

    override suspend fun clearChapters() {
        localChapterRepository.clearChapters()
    }

    override suspend fun deleteChapter(chapter: Chapter) {
        localChapterRepository.deleteChapter(chapter)
    }

    override suspend fun getChaptersPaginatedFromServer(
        provider: Provider,
        webtoon: String,
        page: Int,
        limit: Int
    ): List<Chapter> {
        return mangaScraperApi.getChaptersPaginated(
            MANGA_SCRAPER_KEY,
            MANGA_SCRAPER_HOST,
            provider.slug,
            webtoon,
            page,
            limit
        ).body()!!.map { it.toDbModel(webtoon) }
    }

    override suspend fun getChaptersFromServer(
        provider: Provider,
        webtoon: String,
    ): List<Chapter> {
        return mangaScraperApi.getChapters(
            MANGA_SCRAPER_KEY,
            MANGA_SCRAPER_HOST,
            provider.slug,
            webtoon
        ).body()!!.map { it.toDbModel(webtoon) }
    }

    override suspend fun getLastUpdatedFromServer(
        provider: Provider,
        day: Int
    ): List<Chapter> {
        return mangaScraperApi.getLastUpdated(
            MANGA_SCRAPER_KEY,
            MANGA_SCRAPER_HOST,
            provider.slug,
            day
        ).body()!!.map { it.toDbModel("") }
    }

    override suspend fun getChapterBySlugFromServer(
        provider: Provider,
        mangaSlug: String,
        chapterSlug: String
    ): Chapter {
        return mangaScraperApi.getChapterBySlug(
            MANGA_SCRAPER_KEY,
            MANGA_SCRAPER_HOST,
            chapterSlug,
            provider.slug,
            mangaSlug
        ).body()!!.toDbModel(mangaSlug)
    }
}