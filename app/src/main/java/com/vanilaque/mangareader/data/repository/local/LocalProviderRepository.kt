package com.vanilaque.mangareader.data.repository.local

import com.vanilaque.mangareader.data.model.Provider

interface LocalProviderRepository {
    suspend fun insertProvider(provider: Provider)

    suspend fun getAllProviders(): List<Provider>

    suspend fun clearProviders()

    suspend fun deleteProvider(provider: Provider)
}