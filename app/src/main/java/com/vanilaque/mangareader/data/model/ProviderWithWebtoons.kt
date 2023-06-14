package com.vanilaque.mangareader.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class ProviderWithWebtoons (
    @Embedded
    val provider: Provider,
    @Relation(
        parentColumn = "base_url",
        entityColumn = "slug"
    )
    val webtoons: List<Webtoon>
)