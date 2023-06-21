package com.vanilaque.mangareader.data.repository.impl

import com.vanilaque.mangareader.api.webservice.MangaScraperApi
import com.vanilaque.mangareader.data.dao.ProviderDao
import com.vanilaque.mangareader.data.db.MangaDatabase
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.data.repository.ProviderRepository
import com.vanilaque.mangareader.data.repository.local.LocalProviderRepository
import com.vanilaque.mangareader.util.MANGA_SCRAPER_HOST
import com.vanilaque.mangareader.util.MANGA_SCRAPER_KEY
import retrofit2.Response
import javax.inject.Inject

class ProviderRepositoryImpl @Inject constructor(
    private val localProviderRepository: LocalProviderRepository,
    private val mangaScraperApi: MangaScraperApi
) : ProviderRepository {

    override suspend fun insertProvider(provider: Provider) {
        localProviderRepository.insertProvider(provider)
    }

    override suspend fun getAllProviders(): List<Provider> {
        return localProviderRepository.getAllProviders()
    }

    override suspend fun clearProviders() {
        localProviderRepository.clearProviders()
    }

    override suspend fun deleteProvider(provider: Provider) {
        localProviderRepository.deleteProvider(provider)
    }

    override suspend fun getProvidersFromServer(): List<Provider> {
        return mangaScraperApi.getProviders(MANGA_SCRAPER_KEY, MANGA_SCRAPER_HOST).body()!!
    }
}