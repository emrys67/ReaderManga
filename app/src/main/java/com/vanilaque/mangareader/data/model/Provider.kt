package com.vanilaque.mangareader.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vanilaque.mangareader.util.PROVIDER_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = PROVIDER_DATABASE_TABLE)
data class Provider(
    val baseURL: String,
    @PrimaryKey
    val slug: String,
    val name: String,
)
