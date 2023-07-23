package com.vanilaque.mangareader.data.repository.local.impl

import com.vanilaque.mangareader.data.db.MangaDatabase
import com.vanilaque.mangareader.data.model.FavoriteWebtoon
import com.vanilaque.mangareader.data.repository.local.LocalFavoriteWebtoonRepository
import javax.inject.Inject

class LocalFavoriteWebtoonRepositoryImpl @Inject constructor(mangaDatabase: MangaDatabase) :
    LocalFavoriteWebtoonRepository {
    private val webtoonDao = mangaDatabase.FavoriteWebtoonDao()

    override suspend fun insertWebtoon(webtoon: FavoriteWebtoon) {
        webtoonDao.insertWebtoon(webtoon)
    }

    override suspend fun getAllWebtoons(): List<FavoriteWebtoon> {
        return webtoonDao.getAllWebtoons()
    }

    override suspend fun clearPWebtoons() {
        webtoonDao.clearWebtoons()
    }

    override suspend fun deleteWebtoon(webtoon: FavoriteWebtoon) {
        webtoonDao.deleteWebtoon(webtoon)
    }
}