package com.vanilaque.mangareader.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class WebtoonWithChapters(
    @Embedded
    val webtoon: Webtoon,
    @Relation(
        parentColumn = "mangaSlug",
        entityColumn = "chapterSlug"
    )
    val chapters: List<Chapter>
)
