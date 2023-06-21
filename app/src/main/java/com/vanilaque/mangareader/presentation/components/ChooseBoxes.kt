package com.vanilaque.mangareader.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vanilaque.mangareader.ui.theme.Purple500

@Composable
fun <T> HorizontalRadioGroup(
    options: List<T>,
    getLabel: @Composable (T) -> String,
    selected: T?,
    onClick: (T) -> Unit,
    boxSize: ChooseBoxSize
) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(options) { option ->
            val isSelected = option == selected
            Button(
                onClick = { onClick(option) },
                modifier = Modifier
                    .width(boxSize.width.dp)
                    .height(boxSize.height.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = if (isSelected) Purple500 else Color.Magenta,
                ),
                content = {
                    Text(
                        text = getLabel(option),
                        color = if (isSelected) Purple500 else Color.Magenta,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.sp,
                    )
                },
            )
        }
    }
}

enum class ChooseBox {
    DOWNLOADED,
    FAVORITES,
    DESCRIPTION,
    CHAPTERS,
    NEWEST,
    PREVIOUS,
    TOP
}

enum class ChooseBoxSize(
    val width: Int,
    val height: Int = CHOOSE_BOX_HEIGHT,
    val fontSize: Int = CHOOSE_BOX_FONT
) {
    SMALL(CHOOSE_BOX_WIDTH_SMALL),
    MEDIUM(CHOOSE_BOX_WIDTH_MEDIUM),
    BIG(CHOOSE_BOX_WIDTH_BIG)
}

const val CHOOSE_BOX_HEIGHT = 48

const val CHOOSE_BOX_WIDTH_SMALL = 100
const val CHOOSE_BOX_WIDTH_MEDIUM = 140
const val CHOOSE_BOX_WIDTH_BIG = 170

const val CHOOSE_BOX_FONT = 16
