package com.vanilaque.mangareader.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.vanilaque.mangareader.data.db.InstantConverter
import com.vanilaque.mangareader.util.WEBTOON_DATABASE_TABLE
import java.time.Instant

@Entity(tableName = WEBTOON_DATABASE_TABLE)
@TypeConverters(InstantConverter::class)
data class Webtoon(
    @PrimaryKey
    val mangaSlug: String,
    val providerBaseUrl: String,
    val title: String,
    val sourceURL: String,
    val shortURL: String?,
    val coverURL: String?,
    val synopsis: String,
    val genre: List<String>?,
    val createdAt: Instant?,
    val updatedAt: Instant?,
    var chaptersDownloaded: Int = 0,
    var lastChapterRead: Int = 0,
    var lastOpenedAt: Instant?,
    var addedToFavoritesAt: Instant?,
    var isInFavorites: Boolean = false
)
