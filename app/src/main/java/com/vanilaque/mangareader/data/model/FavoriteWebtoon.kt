package com.vanilaque.mangareader.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vanilaque.mangareader.util.FAVORITE_WEBTOON_DATABASE_TABLE

@Entity(tableName = FAVORITE_WEBTOON_DATABASE_TABLE)
data class FavoriteWebtoon(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val slug: String
)
