package com.vanilaque.mangareader.di

import android.content.Context
import com.vanilaque.mangareader.service.PrefManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class PrefManagerModule {

    @Provides
    fun providePrefManager(@ApplicationContext context: Context): PrefManager {
        return PrefManager(context)
    }
}