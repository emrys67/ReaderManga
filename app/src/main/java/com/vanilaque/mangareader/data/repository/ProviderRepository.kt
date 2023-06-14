package com.vanilaque.mangareader.data.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.util.PROVIDER_DATABASE_TABLE
import retrofit2.Response

interface ProviderRepository {
    suspend fun insertProvider(provider: Provider)

    suspend fun getAllProviders(): List<Provider>

    suspend fun clearProviders()

    suspend fun deleteProvider(provider: Provider)

    suspend fun getProvidersFromServer(): Response<List<Provider>>
}