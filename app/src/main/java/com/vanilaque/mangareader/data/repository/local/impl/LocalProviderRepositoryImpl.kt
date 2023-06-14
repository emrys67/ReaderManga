package com.vanilaque.mangareader.data.repository.local.impl

import com.vanilaque.mangareader.data.db.MangaDatabase
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.data.repository.local.LocalProviderRepository

class LocalProviderRepositoryImpl(mangaDatabase: MangaDatabase): LocalProviderRepository {
    private val providerDao = mangaDatabase.providerDao()

    override suspend fun insertProvider(provider: Provider) {
        providerDao.insertProvider(provider)
    }

    override suspend fun getAllProviders(): List<Provider> {
        return providerDao.getAllProviders()
    }

    override suspend fun clearProviders() {
        providerDao.clearProviders()
    }

    override suspend fun deleteProvider(provider: Provider) {
        providerDao.deleteProvider(provider)
    }
}