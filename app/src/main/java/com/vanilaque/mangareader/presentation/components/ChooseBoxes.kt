package com.vanilaque.mangareader.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vanilaque.mangareader.ui.theme.Purple500

@Preview
@Composable
fun ChooseBox(
    boxText: String = "Newest",
    boxSize: ChooseBoxSize = ChooseBoxSize.SMALL,
    isChosen: Boolean = true,
    onClick: () -> Unit = {}
) {
    val color = remember { mutableStateOf(if (isChosen) Purple500 else Color.Magenta) }
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(boxSize.width.dp)
            .height(boxSize.height.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = color.value)
    ) {
        Text(text = boxText, fontSize = boxSize.fontSize.sp)
    }
}

@Composable
fun ChooseBoxes(
    modifier: Modifier,
    boxes: List<ChooseBox>,
    boxSize: ChooseBoxSize,
    boxOnClick: (ChooseBox, ChooseBoxSize) -> Unit
) {
    var selectedButtonIndex by remember { mutableStateOf(0)}
    Row() {
        boxes.forEach { boxOnClick(it, boxSize) }
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
