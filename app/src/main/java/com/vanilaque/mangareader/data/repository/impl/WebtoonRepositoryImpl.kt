package com.vanilaque.mangareader.data.repository.impl

import com.vanilaque.mangareader.api.webservice.MangaScraperApi
import com.vanilaque.mangareader.data.dao.WebtoonDao
import com.vanilaque.mangareader.data.db.MangaDatabase
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.data.repository.WebtoonRepository
import com.vanilaque.mangareader.data.repository.local.LocalWebtoonRepository
import com.vanilaque.mangareader.util.MANGA_SCRAPER_HOST
import com.vanilaque.mangareader.util.MANGA_SCRAPER_KEY
import retrofit2.Response
import javax.inject.Inject

class WebtoonRepositoryImpl @Inject constructor(
    private val mangaScraperApi: MangaScraperApi,
    private val localWebtoonRepository: LocalWebtoonRepository
) : WebtoonRepository {

    override suspend fun insertWebtoon(webtoon: Webtoon) {
        localWebtoonRepository.insertWebtoon(webtoon)
    }

    override suspend fun getAllWebtoons(): List<Webtoon> {
        return localWebtoonRepository.getAllWebtoons()
    }

    override suspend fun getWebtoon(slug: String): Webtoon {
        return localWebtoonRepository.getWebtoon(slug)
    }

    override suspend fun clearWebtoons() {
        localWebtoonRepository.clearWebtoons()
    }

    override suspend fun deleteWebtoon(webtoon: Webtoon) {
        localWebtoonRepository.deleteWebtoon(webtoon)
    }

    override suspend fun getWebtoonsPaginatedFromServer(
        provider: Provider,
        page: Int,
        limit: Int
    ): Response<List<com.vanilaque.mangareader.api.webservice.Webtoon>> {
        return mangaScraperApi.getWebtoonsPaginated(MANGA_SCRAPER_KEY, MANGA_SCRAPER_HOST, provider.slug, page, limit)
    }

    override suspend fun getWebtoonByQueryFromServer(
        provider: Provider,
        q: String,
        size: Int
    ): Response<List<com.vanilaque.mangareader.api.webservice.Webtoon>> {
        return mangaScraperApi.getWebtoonByQuery(MANGA_SCRAPER_KEY, MANGA_SCRAPER_HOST, q, size, provider.slug)
    }

    override suspend fun getWebtoonBySlugFromServer(
        provider: Provider,
        slug: String
    ): Response<com.vanilaque.mangareader.api.webservice.Webtoon> {
        return mangaScraperApi.getWebtoonBySlug(MANGA_SCRAPER_KEY, MANGA_SCRAPER_HOST, provider.slug, slug)
    }
}