package com.vanilaque.mangareader.di

import android.content.Context
import androidx.room.Room
import com.vanilaque.mangareader.api.webservice.MangaScraperApi
import com.vanilaque.mangareader.data.db.MangaDatabase
import com.vanilaque.mangareader.data.repository.ChapterRepository
import com.vanilaque.mangareader.data.repository.ProviderRepository
import com.vanilaque.mangareader.data.repository.WebtoonRepository
import com.vanilaque.mangareader.data.repository.impl.ChapterRepositoryImpl
import com.vanilaque.mangareader.data.repository.impl.ProviderRepositoryImpl
import com.vanilaque.mangareader.data.repository.impl.WebtoonRepositoryImpl
import com.vanilaque.mangareader.data.repository.local.LocalChapterRepository
import com.vanilaque.mangareader.data.repository.local.LocalProviderRepository
import com.vanilaque.mangareader.data.repository.local.LocalWebtoonRepository
import com.vanilaque.mangareader.data.repository.local.impl.LocalChapterRepositoryImpl
import com.vanilaque.mangareader.data.repository.local.impl.LocalProviderRepositoryImpl
import com.vanilaque.mangareader.data.repository.local.impl.LocalWebtoonRepositoryImpl
import com.vanilaque.mangareader.util.MANGA_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): MangaDatabase {
        return Room.databaseBuilder(
            context,
            MangaDatabase::class.java,
            MANGA_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideChapterRepository(
        database: MangaDatabase
    ): LocalChapterRepository {
        return LocalChapterRepositoryImpl(
            mangaDatabase = database
        )
    }

    @Provides
    @Singleton
    fun provideProviderRepository(
        database: MangaDatabase
    ): LocalProviderRepository {
        return LocalProviderRepositoryImpl(
            mangaDatabase = database
        )
    }

    @Provides
    @Singleton
    fun provideWebtoonRepository(
        database: MangaDatabase
    ): LocalWebtoonRepository {
        return LocalWebtoonRepositoryImpl(
            mangaDatabase = database
        )
    }
}