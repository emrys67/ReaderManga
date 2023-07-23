package com.vanilaque.mangareader.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vanilaque.mangareader.data.model.Chapter
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.presentation.components.ChooseBox
import com.vanilaque.mangareader.presentation.components.ChooseBoxSize
import com.vanilaque.mangareader.presentation.components.HorizontalRadioGroup
import com.vanilaque.mangareader.presentation.navigation.MangaScreens
import com.vanilaque.mangareader.presentation.screens.titleinfo.TitleInfoViewModel
import com.vanilaque.mangareader.service.StateManager
import com.vanilaque.mangareader.ui.theme.MangaPink
import com.vanilaque.mangareader.ui.theme.MangaPurple

@Composable
fun TitleInfoScreen(navController: NavController, viewModel: TitleInfoViewModel = hiltViewModel()) {
    val chapters by viewModel.chapters.collectAsState()
    val webtoon by viewModel.webtoon.collectAsState()
    val chosenBox by viewModel.chosenBox
    var imageLoaded = remember { mutableStateOf(false) }

    DisposableEffect(Unit) {
        StateManager.setShowBottomTopBars(false)
        onDispose {
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .then(
                if (chosenBox == ChooseBox.DESCRIPTION) Modifier.verticalScroll(rememberScrollState()) else Modifier
            )
    ) {

        webtoon?.let {
            Text(
                text = it.title,
                modifier = Modifier.align(CenterHorizontally),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        webtoon?.let {
            LazyRow(
                modifier = Modifier
                    .height(24.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                it.genre?.let { genres ->
                    items(genres) { genre ->
                        GenreBox(name = genre)
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            webtoon?.let {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(webtoon!!.coverURL)
                        .crossfade(true)
                        .build(),
                    contentDescription = "image",
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop,
                    onSuccess = {
                        imageLoaded.value = true
                    },
                    onError = {
                        imageLoaded.value = false
                    }
                )
            }
            if (!imageLoaded.value) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    CircularProgressIndicator(
                        color = MangaPurple,
                        modifier = Modifier
                            .size(32.dp)
                            .align(Alignment.Center)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            HorizontalRadioGroup(
                options = listOf(ChooseBox.DESCRIPTION, ChooseBox.CHAPTERS),
                selected = chosenBox,
                onClick = { viewModel.chosenBox.value = it },
                boxSize = ChooseBoxSize.BIG,
                selectedColor = MangaPurple,
                notSelectedColor = MangaPink,
                modifier = Modifier.align(CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (chosenBox == ChooseBox.DESCRIPTION) {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    shape = RoundedCornerShape(8.dp), backgroundColor = Color.White,
                    elevation = 6.dp,
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 16.dp, horizontal = 8.dp),
                        text = webtoon!!.synopsis,
                        textAlign = TextAlign.Start,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(32.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(chapters) {
                        ChapterItem(chapter = it, webtoon = webtoon!!, navController)
                    }
                    item {
                        Spacer(modifier = Modifier.height(100.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun GenreBox(name: String) {
    Box(
        modifier = Modifier
            .height(24.dp)
            .wrapContentWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(color = Color.LightGray)
            .padding(horizontal = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name,
            modifier = Modifier.wrapContentSize(),
            fontSize = 14.sp,
            color = Color.White
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChapterItem(chapter: Chapter, webtoon: Webtoon, navController: NavController) {
    Card(modifier = Modifier
        .height(68.dp)
        .width(68.dp),
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(8.dp),
        onClick = {

            navigateToChapter(navController, webtoon = webtoon, chapter = chapter)
//            navController.navigate(
//                MangaScreens.TitleReadScreen.passArguments(
//                    webtoon.mangaSlug,
//                    chapter.chapterSlug
//                )
//            )
        }) {
        Box(Modifier.fillMaxSize()) {
            Text(
                text = chapter.chapterNum.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Center)
            )
        }
    }
}

fun navigateToChapter(navController: NavController, webtoon: Webtoon, chapter: Chapter) {
    navController.navigate(
        MangaScreens.TitleReadScreen.passArguments(
            webtoon.mangaSlug,
            chapter.chapterSlug
        )
    )
}

fun onLikeClick(viewModel: TitleInfoViewModel, webtoon: Webtoon) {
    viewModel.onLikeWebtoonClick(webtoon)
}
