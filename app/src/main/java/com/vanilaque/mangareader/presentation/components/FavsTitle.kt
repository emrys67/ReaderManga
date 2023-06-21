package com.vanilaque.mangareader.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vanilaque.mangareader.R

@Preview
@Composable
fun FavoritesTitleFromServer(onReadClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .height(IMAGE_HEIGHT_MEDIUM.dp)
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TitlePictureFromServer(TitlePictureSize.Medium)

        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Shinjeki no kyjoin", fontSize = 22.sp, textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.SemiBold
                )

                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.downloaded),
                        contentDescription = "downloaded",
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp)
                            .align(CenterVertically),
                        colorFilter = ColorFilter.tint(color = Color.Black)
                    )
                    Text(
                        text = "15 chapters",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(CenterVertically)
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
                            .align(CenterVertically),
                        colorFilter = ColorFilter.tint(color = Color.Black)
                    )
                    Text(
                        text = "11 chapters", fontSize = 16.sp, textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp)
                            .align(CenterVertically)
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

            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(text = "Read now", fontSize = 22.sp)
            }
        }
    }
}