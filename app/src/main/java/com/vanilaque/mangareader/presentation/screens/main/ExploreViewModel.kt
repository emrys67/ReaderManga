package com.vanilaque.mangareader.presentation.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vanilaque.mangareader.data.model.FavoriteWebtoon
import com.vanilaque.mangareader.data.model.Provider
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.data.repository.impl.ProviderRepositoryImpl
import com.vanilaque.mangareader.data.repository.impl.WebtoonRepositoryImpl
import com.vanilaque.mangareader.data.repository.local.impl.LocalFavoriteWebtoonRepositoryImpl
import com.vanilaque.mangareader.service.PrefManager
import com.vanilaque.mangareader.service.StateManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val webtoonRepositoryImpl: WebtoonRepositoryImpl,
    private val providerRepositoryImpl: ProviderRepositoryImpl,
    private val favoriteWebtoonRepositoryImpl: LocalFavoriteWebtoonRepositoryImpl,
    private val prefManager: PrefManager
) : ViewModel() {
    lateinit var provider: Provider
    val webtoons: MutableState<MutableList<Webtoon>> = mutableStateOf(mutableListOf())

    init {
        StateManager.setShowBottomTopBars(true)
        getWebtoons()
    }

    suspend fun getProvider() {
        provider = providerRepositoryImpl.getProvidersFromServer()[1]
    }

    fun getWebtoons() {
        viewModelScope.launch {
            getProvider()
            webtoons.value = webtoonRepositoryImpl.getWebtoonsPaginatedFromServer(provider, 1, 10)
                .filter { !it.coverURL.isNullOrEmpty() }.toMutableList()
            webtoons.value.addAll(
                webtoonRepositoryImpl.getWebtoonsPaginatedFromServer(
                    provider,
                    2,
                    10
                ).filter { !it.coverURL.isNullOrEmpty() })
            webtoons.value.addAll(
                webtoonRepositoryImpl.getWebtoonsPaginatedFromServer(
                    provider,
                    3,
                    10
                ).filter { !it.coverURL.isNullOrEmpty() })
            webtoons.value.addAll(
                webtoonRepositoryImpl.getWebtoonsPaginatedFromServer(
                    provider,
                    4,
                    10
                ).filter { !it.coverURL.isNullOrEmpty() })
        }
    }

    fun onLikeWebtoonClick(webtoon: Webtoon, index: Int) {
        viewModelScope.launch {
            val currentWebtoons = webtoons.value.toMutableList()

            if (webtoon.isInFavorites) {
                favoriteWebtoonRepositoryImpl.insertWebtoon(FavoriteWebtoon(slug = webtoon.mangaSlug))
            } else {
                favoriteWebtoonRepositoryImpl.deleteWebtoon(FavoriteWebtoon(slug = webtoon.mangaSlug))
            }

            currentWebtoons[index] = webtoon.copy(isInFavorites = !webtoon.isInFavorites)
            webtoons.value = currentWebtoons
        }
    }
}