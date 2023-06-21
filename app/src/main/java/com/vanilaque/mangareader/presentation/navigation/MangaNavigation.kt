package com.vanilaque.mangareader.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vanilaque.mangareader.presentation.screens.MainScreen

@Composable
fun MangaNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = MangaScreens.MainScreen.name ) {
        composable(MangaScreens.MainScreen.name) {
            MainScreen(navController = navController)
        }
    }
}