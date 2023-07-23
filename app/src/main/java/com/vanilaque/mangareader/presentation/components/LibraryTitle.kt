package com.vanilaque.mangareader.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vanilaque.mangareader.R
import com.vanilaque.mangareader.data.model.Webtoon
import com.vanilaque.mangareader.ui.theme.MangaPurple

@Composable
fun LibraryMangaTitle(
    webtoon: Webtoon,
    inFavorites: Boolean = false,
    onLikeClick: () -> Unit,
    isLiked: Boolean
) {
    Row(
        modifier = Modifier
            .height(IMAGE_HEIGHT_MEDIUM.dp)
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TitlePictureFromServer(
            TitlePictureSize.Medium,
            imageUrl = webtoon.coverURL!!,
            onLikeClick = onLikeClick,
            isLiked = isLiked
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = webtoon.title, fontSize = 22.sp, textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.SemiBold
                )

                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.downloaded),
                        contentDescription = "downloaded",
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp)
                            .align(Alignment.CenterVertically),
                        colorFilter = ColorFilter.tint(color = Color.Black)
                    )
                    Text(
                        text = "15 chapters",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically)
                            .padding(start = 8.dp)
                    )
                }

                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = "downloaded",
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp)
                            .align(Alignment.CenterVertically),
                        colorFilter = ColorFilter.tint(color = Color.Black)
                    )
                    Text(
                        text = "11 chapters", fontSize = 16.sp, textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp)
                            .align(Alignment.CenterVertically)
                    )
                }

                Text(
                    text = "21.11.2022 14:11 last opening",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp),
                    color = Color.Gray
                )

                if (inFavorites) {
                    Text(
                        text = "21.11.2022 14:11 was added",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                        color = Color.Gray
                    )
                }

            }

            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp), elevation = ButtonDefaults.elevation(4.dp)
            ) {
                Text(text = "Read now", fontSize = 22.sp)
            }
        }
    }
}

@Composable
fun SmallTitle(
    webtoon: Webtoon,
    onClick: (Webtoon) -> Unit,
    onLikeClick: () -> Unit,
    isLiked: Boolean
) {
    Column(modifier = Modifier
        .width(IMAGE_WIDTH_SMALL.dp)
        .clickable { onClick(webtoon) }) {
        TitlePictureFromServer(
            TitlePictureSize.SMALL,
            imageUrl = webtoon.coverURL!!,
            onLikeClick,
            isLiked = isLiked
        )
        Text(
            text = webtoon.title, fontSize = 14.sp, textAlign = TextAlign.Start,
            modifier = Modifier
                .width(IMAGE_WIDTH_SMALL.dp)
                .padding(top = 4.dp, start = 4.dp, end = 4.dp), fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun SearchedTitle(
    webtoon: Webtoon,
    onSearchClick: () -> Unit,
    onLikeClick: () -> Unit,
    isLiked: Boolean
) {
    Row(
        modifier = Modifier
            .height(IMAGE_HEIGHT_MEDIUM.dp)
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TitlePictureFromServer(
            TitlePictureSize.Medium,
            imageUrl = webtoon.coverURL!!,
            onLikeClick = onLikeClick,
            isLiked = isLiked
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = webtoon.title, fontSize = 22.sp, textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = webtoon.synopsis.substring(0, 465),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Color.Gray
                )
            }

            Button(
                onClick = onSearchClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MangaPurple),
                elevation = ButtonDefaults.elevation(4.dp)
            ) {
                Text(text = "Read now", fontSize = 22.sp, color = Color.White)
            }
        }
    }
}