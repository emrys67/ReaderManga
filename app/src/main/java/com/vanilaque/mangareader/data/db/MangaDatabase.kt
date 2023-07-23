package com.vanilaque.mangareader.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vanilaque.mangareader.data.dao.ChapterDao
import com.vanilaque.mangareader.data.dao.FavoriteWebtoonDao
import com.vanilaque.mangareader.data.dao.ProviderDao
import com.vanilaque.mangareader.data.dao.WebtoonDao
import com.vanilaque.mangareader.data.model.Chapter
import com.vanilaque.mangareader.data.model.FavoriteWebtoon
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.data.model.Webtoon

@Database(
    entities = [Chapter::class, Provider::class, Webtoon::class, FavoriteWebtoon::class],
    version = 1,
)
@TypeConverters(DatabaseConverter::class)
abstract class MangaDatabase : RoomDatabase() {
    abstract fun chapterDao(): ChapterDao
    abstract fun providerDao(): ProviderDao
    abstract fun WebtoonDao(): WebtoonDao
    abstract fun FavoriteWebtoonDao(): FavoriteWebtoonDao
}