package com.vanilaque.mangareader.data.repository.local

import com.vanilaque.mangareader.data.model.FavoriteWebtoon

interface LocalFavoriteWebtoonRepository {
    suspend fun insertWebtoon(webtoon: FavoriteWebtoon)

    suspend fun getAllWebtoons(): List<FavoriteWebtoon>

    suspend fun clearPWebtoons()

    suspend fun deleteWebtoon(webtoon: FavoriteWebtoon)
}