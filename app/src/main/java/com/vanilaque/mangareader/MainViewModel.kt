package com.vanilaque.mangareader

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vanilaque.mangareader.data.repository.impl.ProviderRepositoryImpl
import com.vanilaque.mangareader.presentation.components.FooterPath
import com.vanilaque.mangareader.service.PrefManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val prefManager: PrefManager,
    val providerRepositoryImpl: ProviderRepositoryImpl
) : ViewModel() {
    val searchText: MutableState<String> = mutableStateOf("")
    val isSearchFieldFocused: MutableState<Boolean> = mutableStateOf(false)
    val footerPath: MutableState<FooterPath> = mutableStateOf(FooterPath.CATALOG)

    init {
        viewModelScope.launch {
            prefManager.chosenProvider = providerRepositoryImpl.getProvidersFromServer()[1]
        }
    }

    fun searchQuerryForWebtoon() {

    }
}