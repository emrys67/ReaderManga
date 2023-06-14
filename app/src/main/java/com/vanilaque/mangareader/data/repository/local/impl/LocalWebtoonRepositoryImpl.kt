package com.vanilaque.mangareader.data.repository.local.impl

import com.vanilaque.mangareader.data.db.MangaDatabase
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.data.repository.local.LocalWebtoonRepository

class LocalWebtoonRepositoryImpl(mangaDatabase: MangaDatabase): LocalWebtoonRepository {
    private val webtoonDao = mangaDatabase.WebtoonDao()

    override suspend fun insertWebtoon(webtoon: Webtoon) {
        webtoonDao.insertWebtoon(webtoon)
    }

    override suspend fun getAllWebtoons(): List<Webtoon> {
        return webtoonDao.getAllWebtoons()
    }

    override suspend fun getWebtoon(slug: String): Webtoon {
        return webtoonDao.getWebtoon(slug)
    }

    override suspend fun clearWebtoons() {
        webtoonDao.clearWebtoons()
    }

    override suspend fun deleteWebtoon(webtoon: Webtoon) {
        webtoonDao.deleteWebtoon(webtoon)
    }
}