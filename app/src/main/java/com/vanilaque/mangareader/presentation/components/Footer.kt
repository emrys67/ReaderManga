package com.vanilaque.mangareader.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vanilaque.mangareader.R

@Preview
@Composable
fun Footer(onClick: (FooterPath)-> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.shopping), contentDescription = "Catalog",
            colorFilter = ColorFilter.tint(color = Color.Magenta), modifier = Modifier.size(30.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.book_open), contentDescription = "Catalog",
            colorFilter = ColorFilter.tint(color = Color.Magenta), modifier = Modifier.size(32.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.account_settings),
            contentDescription = "Catalog",
            colorFilter = ColorFilter.tint(color = Color.Magenta),
            modifier = Modifier.size(34.dp).padding(top = 4.dp)
        ) // keep in sharedPreferences
    }
}

enum class FooterPath{
    CATALOG,
    LIBRARY,
    ACCOUNT
}