package com.vanilaque.mangareader.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vanilaque.mangareader.data.model.FavoriteWebtoon
import com.vanilaque.mangareader.util.FAVORITE_WEBTOON_DATABASE_TABLE

@Dao
interface FavoriteWebtoonDao {
    @Insert
    suspend fun insertWebtoon(webtoon: FavoriteWebtoon)

    @Query("SELECT * FROM $FAVORITE_WEBTOON_DATABASE_TABLE WHERE slug = :slug LIMIT 1")
    suspend fun getWebtoon(slug: String): FavoriteWebtoon

    @Query("SELECT * FROM $FAVORITE_WEBTOON_DATABASE_TABLE")
    suspend fun getAllWebtoons(): List<FavoriteWebtoon>

    @Query("DELETE FROM $FAVORITE_WEBTOON_DATABASE_TABLE")
    suspend fun clearWebtoons()

    @Delete
    suspend fun deleteWebtoon(webtoon: FavoriteWebtoon)
}