package com.vanilaque.mangareader.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.presentation.components.SmallTitle
import com.vanilaque.mangareader.presentation.navigation.MangaScreens
import com.vanilaque.mangareader.presentation.screens.main.ExploreViewModel
import com.vanilaque.mangareader.service.StateManager

@Composable
fun ExploreScreen(
    navController: NavController,
    viewModel: ExploreViewModel = hiltViewModel<ExploreViewModel>()
) {
    DisposableEffect(Unit) {
        StateManager.setShowBottomTopBars(true)
        onDispose {}
    }

    LaunchedEffect(viewModel.webtoons) {
        // This block will be executed whenever viewModel.webtoons changes
    }

    val webtoons by rememberSaveable { viewModel.webtoons }
    Column(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp), modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(webtoons.size) { webtoon ->
                SmallTitle(
                    webtoon = webtoons[webtoon],
                    onClick = { navigateToTitleInfo(navController, webtoons[webtoon]) },
                    onLikeClick = { onLikeClick(viewModel, webtoons[webtoon], webtoon) },
                    isLiked = webtoons[webtoon].isInFavorites
                )
            }
            item {
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}

fun navigateToTitleInfo(navController: NavController, webtoon: Webtoon) {
    navController.navigate(MangaScreens.TitleInfoScreen.passArg(webtoon.mangaSlug))
}

fun onLikeClick(viewModel: ExploreViewModel, webtoon: Webtoon, index: Int) {
    viewModel.onLikeWebtoonClick(webtoon, index)
}