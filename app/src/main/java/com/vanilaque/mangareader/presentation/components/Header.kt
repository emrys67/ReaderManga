package com.vanilaque.mangareader.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vanilaque.mangareader.R

@Preview
@Composable
fun Header() {
    if (true)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.mock_avatar),
                contentDescription = "Avatar",
                modifier = Modifier.size(48.dp)
            )
            Text(text = "User name", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search",
                modifier = Modifier.size(32.dp)
            )
        }
    else
        SearchField()
    //avatar -> user name                           search icon
    //when search clicked - open textfield and change icon location
}

@Composable
fun SearchField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "Search",
            modifier = Modifier
                .size(32.dp)
                .align(CenterVertically)
        )

        TextField(value = text, onValueChange = { newText ->
            text = newText
        }, modifier = Modifier
            .weight(1f)
            .align(CenterVertically), shape = RoundedCornerShape(8.dp))
    }
}