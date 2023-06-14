package com.vanilaque.mangareader.data.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.util.WEBTOON_DATABASE_TABLE
import retrofit2.Response

interface WebtoonRepository {
    suspend fun insertWebtoon(webtoon: Webtoon)

    suspend fun getAllWebtoons(): List<Webtoon>

    suspend fun getWebtoon(slug: String): Webtoon

    suspend fun clearWebtoons()

    suspend fun deleteWebtoon(webtoon: Webtoon)

    suspend fun getWebtoonsPaginatedFromServer(
        provider: Provider,
        page: Int,
        limit: Int
    ): Response<List<com.vanilaque.mangareader.api.webservice.Webtoon>>

    suspend fun getWebtoonByQueryFromServer(
        provider: Provider,
        q: String,
        size: Int
    ): Response<List<com.vanilaque.mangareader.api.webservice.Webtoon>>

    suspend fun getWebtoonBySlugFromServer(
        provider: Provider,
        slug: String
    ): Response<com.vanilaque.mangareader.api.webservice.Webtoon>
}