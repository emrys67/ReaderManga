package com.vanilaque.mangareader.api.webservice

import com.vanilaque.mangareader.data.model.Provider
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaScraperApi {
    @GET("/webtoons")
    suspend fun getWebtoonsPaginated(
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String,
        @Query("provider") provider: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<Webtoon>>

    @GET("/chapters")
    suspend fun getChaptersPaginated(
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String,
        @Query("provider") provider: String,
        @Query("webtoon") webtoon: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<Chapter>>

    @GET("/chapters/all")
    suspend fun getChapters(
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String,
        @Query("provider") provider: String,
        @Query("webtoon") webtoon: String,
    ): Response<List<Chapter>>

    @GET("/updates")
    suspend fun getLastUpdated(
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String,
        @Query("provider") provider: String,
        @Query("day") day: Int
    ): Response<List<Chapter>>

    @GET("/search")
    suspend fun getWebtoonByQuery(
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String,
        @Query("q") q: String,
        @Query("size") size: Int,
        @Query("provider") provider: String,
    ): Response<List<Webtoon>>

    @GET("/webtoons/{slug}")
    suspend fun getWebtoonBySlug(
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String,
        @Path("slug") slug: String,
        @Query("provider") provider: String,
    ): Response<Webtoon>

    @GET("/chapters/{slug}")
    suspend fun getChapterBySlug(
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String,
        @Path("slug") slug: String,
        @Query("provider") provider: String,
        @Query("webtoon") webtoon: String,
    ): Response<Chapter>

    @GET("/providers")
    suspend fun getProviders(
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String
    ): Response<List<Provider>>
}