package com.vanilaque.mangareader.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.vanilaque.mangareader.data.db.InstantConverter
import com.vanilaque.mangareader.util.CHAPTER_DATABASE_TABLE
import java.time.Instant

@Entity(tableName = CHAPTER_DATABASE_TABLE)
@TypeConverters(InstantConverter::class)
data class Chapter(
    @PrimaryKey
    val chapterSlug: String,
    val providerSlug: String,
    val mangaSlug: String,
    val fullTitle: String,
    val shortTitle: String,
    val chapterNum: Int,
    val sourceURL: String,
    val shortURL: String,
    val contentURL: List<String>,
    val createdAt: Instant,
    val updatedAt: Instant
)
