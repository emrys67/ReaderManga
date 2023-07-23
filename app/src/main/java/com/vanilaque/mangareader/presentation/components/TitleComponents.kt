package com.vanilaque.mangareader.presentation.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vanilaque.mangareader.R
import com.vanilaque.mangareader.ui.theme.FieldColor
import com.vanilaque.mangareader.ui.theme.LikeColor
import com.vanilaque.mangareader.ui.theme.LikeColorChosen

@Composable
fun LikeField(
    modifier: Modifier,
    likeSize: Dp,
    fieldWidth: Dp,
    fieldHeight: Dp,
    isLiked: Boolean,
    onLikeClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(fieldWidth)
            .height(fieldHeight)
            .background(color = FieldColor)
            .clickable {}
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
                .size(likeSize)
                .clickable { onLikeClick() },
            colorFilter = ColorFilter.tint(color = if (isLiked) LikeColorChosen else LikeColor)
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
fun TitleImageFromDb(bitmap: Bitmap) {
    //Image(bitmap = bitmap, contentDescription = "cover image")
}