package com.vanilaque.mangareader.presentation.screens.titleread

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vanilaque.mangareader.data.model.Chapter
import com.vanilaque.mangareader.data.repository.impl.ChapterRepositoryImpl
import com.vanilaque.mangareader.data.repository.impl.WebtoonRepositoryImpl
import com.vanilaque.mangareader.service.PrefManager
import com.vanilaque.mangareader.util.READ_TITLE_CHAPTER_ARGUMENT_KEY
import com.vanilaque.mangareader.util.READ_TITLE_WEBTOON_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TitleReadViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle, val webtoonRepositoryImpl: WebtoonRepositoryImpl,
    val chapterRepositoryImpl: ChapterRepositoryImpl, val prefManager: PrefManager
) : ViewModel() {

    val _chapter: MutableStateFlow<Chapter?> = MutableStateFlow(null)
    val chapter: StateFlow<Chapter?> = _chapter

    val _webtoonSlug: MutableStateFlow<String?> = MutableStateFlow(null)
    val webtoonSlug: StateFlow<String?> = _webtoonSlug

    init {

        viewModelScope.launch(Dispatchers.IO) {
            _webtoonSlug.value = savedStateHandle.get<String>(READ_TITLE_WEBTOON_ARGUMENT_KEY)
            val chapterSlug = savedStateHandle.get<String>(READ_TITLE_CHAPTER_ARGUMENT_KEY)

            //_webtoon.value = mangaSlug?.let { webtoonRepositoryImpl.getWebtoonBySlugFromServer(prefManager.chosenProvider!!, mangaSlug) }
            _chapter.value = chapterRepositoryImpl.getChapterBySlugFromServer(
                prefManager.chosenProvider!!,
                webtoonSlug.value!!,
                chapterSlug!!
            )
        }
    }

    fun getNextChapterSlug(): String? {
        return chapter.value!!.nextChapterSlug
    }

    fun getPrivChapterSlug(): String? {
        return chapter.value!!.privChapterSlug
    }

    //if this chapter is in db - fetch it from db
    //if not - fetch from the server

}