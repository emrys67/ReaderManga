package com.vanilaque.mangareader.presentation.screens.titleinfo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vanilaque.mangareader.data.model.Chapter
import com.vanilaque.mangareader.data.model.FavoriteWebtoon
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.data.repository.impl.ChapterRepositoryImpl
import com.vanilaque.mangareader.data.repository.impl.WebtoonRepositoryImpl
import com.vanilaque.mangareader.data.repository.local.impl.LocalFavoriteWebtoonRepositoryImpl
import com.vanilaque.mangareader.presentation.components.ChooseBox
import com.vanilaque.mangareader.service.PrefManager
import com.vanilaque.mangareader.util.READ_TITLE_WEBTOON_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TitleInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val chapterRepositoryImpl: ChapterRepositoryImpl,
    private val webtoonRepositoryImpl: WebtoonRepositoryImpl,
    private val favoriteWebtoonRepositoryImpl: LocalFavoriteWebtoonRepositoryImpl,
    private val prefManager: PrefManager,
) : ViewModel() {

    val chosenBox = mutableStateOf(ChooseBox.DESCRIPTION)
    val _chapters: MutableStateFlow<List<Chapter>> = MutableStateFlow(listOf())
    val chapters: StateFlow<List<Chapter>> = _chapters

    val _webtoon: MutableStateFlow<Webtoon?> = MutableStateFlow(null)
    val webtoon: StateFlow<Webtoon?> = _webtoon

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val mangaSlug = savedStateHandle.get<String>(READ_TITLE_WEBTOON_ARGUMENT_KEY)


            _webtoon.value = mangaSlug?.let {
                webtoonRepositoryImpl.getWebtoonBySlugFromServer(
                    prefManager.chosenProvider!!,
                    mangaSlug
                )
            }
            _chapters.value = chapterRepositoryImpl.getChaptersFromServer(
                prefManager.chosenProvider!!,
                mangaSlug!!
            ).sortedBy { it.chapterNum }
        }
    }

    fun onLikeWebtoonClick(webtoon: Webtoon) {
        viewModelScope.launch {
            favoriteWebtoonRepositoryImpl.insertWebtoon(FavoriteWebtoon(slug = webtoon.mangaSlug))
            webtoon.isInFavorites = true
        }
    }
}