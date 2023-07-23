package com.vanilaque.mangareader.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val MangaPurple = Color(color = 0xFF915FC4)
val MangaPink = Color(color = 0xFFE2ADDA)
val FieldColor = MangaPurple.copy(alpha = 0.2f)
val LikeColor = Color(color = 0xFFFFFFFF).copy(alpha = 0.8f)
val LikeColorChosen = Color(color = 0xFFF090D5)

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,

    )

private val LightColorPalette = lightColors(
    primary = MangaPurple,
    primaryVariant = FieldColor,
    secondary = MangaPink,
)


