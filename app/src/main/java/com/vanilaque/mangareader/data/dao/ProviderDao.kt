package com.vanilaque.mangareader.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.util.PROVIDER_DATABASE_TABLE

@Dao
interface ProviderDao {
    @Insert
    suspend fun insertProvider(provider: Provider)
    @Query("SELECT * FROM $PROVIDER_DATABASE_TABLE")
    suspend fun getAllProviders(): List<Provider>
    @Query("DELETE FROM $PROVIDER_DATABASE_TABLE")
    suspend fun clearProviders()
    @Delete
    suspend fun deleteProvider(provider: Provider)
}