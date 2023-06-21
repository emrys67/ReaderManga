package com.vanilaque.mangareader.presentation.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vanilaque.mangareader.R

@Composable
fun LikeField(modifier: Modifier, likeSize: Dp, fieldWidth: Dp, fieldHeight: Dp) {
    Box(
        modifier = Modifier
            .width(fieldWidth)
            .height(fieldHeight)
            .background(color = Color.Magenta.copy(alpha = 0.2f))
            .then(modifier)
    ) {
        Image(
            painter = painterResource(id = R.drawable.like),
            contentDescription = "like",
            modifier = Modifier
                .padding(end = 4.dp)
                .align(
                    Alignment.CenterEnd
                )
                .size(likeSize), colorFilter = ColorFilter.tint(color = Color.Gray.copy(alpha = 0.8f))
        )
    }
}

@Composable
fun TitleImage(url: String = "https://www.asurascans.com/wp-content/uploads/2021/03/soloLevelingCover02.png") {
    AsyncImage(
        model = url,
        contentDescription = "cover image", modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp)), contentScale = ContentScale.Crop
    )
}

@Composable
fun TitleImageFromDb(bitmap: Bitmap){
    //Image(bitmap = bitmap, contentDescription = "cover image")
}