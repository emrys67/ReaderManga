package com.vanilaque.mangareader

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.vanilaque.mangareader.api.webservice.MangaScraperApi
import com.vanilaque.mangareader.data.repository.WebtoonRepository
import com.vanilaque.mangareader.data.repository.impl.WebtoonRepositoryImpl
import com.vanilaque.mangareader.ui.theme.MangaReaderTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity () : ComponentActivity() {
    @Inject
    lateinit var api: MangaScraperApi
    @Inject
    lateinit var repo: WebtoonRepositoryImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MangaReaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                    runBlocking {
                        val response = api.getProviders("e9f4549693msh52493ff0760e9c0p1b12c3jsn19a165f30e41", "manga-scrapper.p.rapidapi.com").body()
                        Log.e("response", response.toString())


                        val webtoon = repo.getWebtoonByQueryFromServer(response!![1],"shingeki no kyojin", 10)
                        Log.e("webtoon", webtoon.toString())

                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MangaReaderTheme {
        Greeting("Android")
    }
}