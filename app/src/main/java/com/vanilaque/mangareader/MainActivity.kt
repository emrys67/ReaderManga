package com.vanilaque.mangareader

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.vanilaque.mangareader.presentation.components.Footer
import com.vanilaque.mangareader.presentation.components.Header
import com.vanilaque.mangareader.presentation.navigation.MangaNavigation
import com.vanilaque.mangareader.service.StateManager
import com.vanilaque.mangareader.ui.theme.MangaReaderTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity() : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    //private val prefManager = PrefManager(this)

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isFocused by viewModel.isSearchFieldFocused
            val searchQuery by viewModel.searchText
            val footerPath by viewModel.footerPath
            val showBottomTopBars by StateManager.showBottomTopbars.collectAsState()

            MangaReaderTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    if (showBottomTopBars)
                        Header(
                            text = searchQuery,
                            onTextChange = { viewModel.searchText.value = it },
                            onSearchTitle = {
                                viewModel.searchQuerryForWebtoon()
                            },
                            onSearchButtonClicked = {
                                viewModel.isSearchFieldFocused.value =
                                    !viewModel.isSearchFieldFocused.value
                            }, onCloseSearchClicked = {
                                viewModel.isSearchFieldFocused.value =
                                    !viewModel.isSearchFieldFocused.value
                            },
                            isStateFocused = isFocused
                        )
                },
                    bottomBar = {
                        if (showBottomTopBars)
                            Footer({ viewModel.footerPath.value = it }, footerPath)
                    }) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        MangaNavigation()
                    }
                }
            }
        }
    }
}