package com.vanilaque.mangareader.presentation.navigation

//enum class MangaScreens {
//    LibraryScreen,
//    LoginScreen,
//    MainScreen,
//    TitleInfoScreen,
//    TitleReadScreen
//}

sealed class MangaScreens(val route: String) {
    //    object Splash : Screen("splash_screen")
    object LibraryScreen : MangaScreens("welcome_screen")

    object MainScreen : MangaScreens("main_screen")
    object HomeLoginScreene : MangaScreens("home_screen")
    object TitleReadScreen : MangaScreens("title_read/{mangaSlug}/{chapterSlug}") {
        fun passArguments(mangaSlug: String, chapterSlug: String): String {
            return "title_read/$mangaSlug/$chapterSlug"
        }
    }

    object TitleInfoScreen : MangaScreens("title_info/{mangaSlug}") {
        fun passArg(mangaSlug: String): String {
            return "title_info/$mangaSlug"
        }
    }

    object Search : MangaScreens("search_screen")
}