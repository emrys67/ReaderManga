package com.vanilaque.mangareader.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vanilaque.mangareader.data.model.*
import com.vanilaque.mangareader.util.CHAPTER_DATABASE_TABLE
import com.vanilaque.mangareader.util.PROVIDER_DATABASE_TABLE
import com.vanilaque.mangareader.util.WEBTOON_DATABASE_TABLE

@Dao
interface ChapterDao {
    @Insert
    suspend fun insertChapter(chapter: Chapter)
    @Query("SELECT * FROM $CHAPTER_DATABASE_TABLE WHERE mangaSlug = :mangaSlug")
    suspend fun getChaptersForWebtoon(mangaSlug: String): List<Chapter>
    @Query("SELECT * FROM $CHAPTER_DATABASE_TABLE WHERE providerSlug = :sourceUrl")
    suspend fun getChaptersForProvider(sourceUrl: String): List<Chapter>
    @Query("SELECT * FROM $CHAPTER_DATABASE_TABLE WHERE chapterSlug = :slug LIMIT 1")
    suspend fun getChapter(slug: String): Chapter
    @Query("DELETE FROM $CHAPTER_DATABASE_TABLE")
    suspend fun clearChapters()
    @Delete
    suspend fun deleteChapter(chapter: Chapter)
}