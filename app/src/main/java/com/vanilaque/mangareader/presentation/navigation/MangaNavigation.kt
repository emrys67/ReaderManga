package com.vanilaque.mangareader.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vanilaque.mangareader.presentation.screens.ExploreScreen
import com.vanilaque.mangareader.presentation.screens.TitleInfoScreen
import com.vanilaque.mangareader.presentation.screens.TitleReadScreen
import com.vanilaque.mangareader.util.READ_TITLE_CHAPTER_ARGUMENT_KEY
import com.vanilaque.mangareader.util.READ_TITLE_WEBTOON_ARGUMENT_KEY
import com.vanilaque.mangareader.util.TITLE_INFO_WEBTOON_ARGUMENT_KEY

@SuppressLint("SuspiciousIndentation")
@Composable
fun MangaNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MangaScreens.MainScreen.route
    ) {
        composable(MangaScreens.MainScreen.route) {
            ExploreScreen(navController = navController)
        }
        composable(route = MangaScreens.TitleReadScreen.route, arguments = listOf(
            navArgument(READ_TITLE_WEBTOON_ARGUMENT_KEY) {
                type = NavType.StringType
            }, navArgument(READ_TITLE_CHAPTER_ARGUMENT_KEY) {
                type = NavType.StringType
            }
        )) {
            TitleReadScreen(navController)
        }
        composable(route = MangaScreens.TitleInfoScreen.route, arguments = listOf(
            navArgument(TITLE_INFO_WEBTOON_ARGUMENT_KEY) {
                type = NavType.StringType
            }
        )) {
            TitleInfoScreen(navController)
        }
    }
}