package com.vanilaque.mangareader.data.repository.local.impl

import com.vanilaque.mangareader.data.db.MangaDatabase
import com.vanilaque.mangareader.data.model.Chapter
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.data.model.WebtoonWithChapters
import com.vanilaque.mangareader.data.repository.local.LocalChapterRepository

class LocalChapterRepositoryImpl(mangaDatabase: MangaDatabase) : LocalChapterRepository{
    private val chapterDao = mangaDatabase.chapterDao()

    override suspend fun insertChapter(chapter: Chapter) {
        chapterDao.insertChapter(chapter)
    }

    override suspend fun getChaptersForWebtoon(webtoon: Webtoon): List<WebtoonWithChapters> {
        return listOf()
        //chapterDao.getChaptersForWebtoon(webtoon)
    }

    override suspend fun getChapter(slug: String): Chapter {
        return chapterDao.getChapter(slug)
    }

    override suspend fun clearChapters() {
        chapterDao.clearChapters()
    }

    override suspend fun deleteChapter(chapter: Chapter) {
        chapterDao.deleteChapter(chapter)
    }
}