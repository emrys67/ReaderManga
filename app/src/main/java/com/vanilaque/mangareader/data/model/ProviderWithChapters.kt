package com.vanilaque.mangareader.data.model

import androidx.room.Embedded
import androidx.room.Relation

class ProviderWithChapters(
    @Embedded
    val provider: Provider,
    @Relation(
        parentColumn = "baseUrl",
        entityColumn = "slug"
    )
    val chapters: List<Chapter>
)