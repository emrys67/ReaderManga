package com.vanilaque.mangareader.data.repository.local

import com.vanilaque.mangareader.data.model.Webtoon

interface LocalWebtoonRepository {
    suspend fun insertWebtoon(webtoon: Webtoon)

    suspend fun getAllWebtoons(): List<Webtoon>

    suspend fun getWebtoon(slug: String): Webtoon

    suspend fun clearWebtoons()

    suspend fun deleteWebtoon(webtoon: Webtoon)
}