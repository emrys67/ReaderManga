package com.vanilaque.mangareader.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.util.WEBTOON_DATABASE_TABLE

@Dao
interface WebtoonDao {
    @Insert
    suspend fun insertWebtoon(webtoon: Webtoon)
    @Query("SELECT * FROM $WEBTOON_DATABASE_TABLE")
    suspend fun getAllWebtoons(): List<Webtoon>
    @Query("SELECT * FROM $WEBTOON_DATABASE_TABLE WHERE mangaSlug = :slug LIMIT 1")
    suspend fun getWebtoon(slug: String): Webtoon
    @Query("DELETE FROM $WEBTOON_DATABASE_TABLE")
    suspend fun clearWebtoons()
    @Delete
    suspend fun deleteWebtoon(webtoon: Webtoon)
}