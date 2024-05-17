package ru.mezhendosina.foodies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import ru.mezhendosina.foodies.R
import ru.mezhendosina.shared.ui.entities.Tag

@Composable
fun TagImage(tag: Int, modifier: Modifier =Modifier) {
    val tagToPainter: Painter = painterResource(
        id = when (tag) {
            Tag.HOT -> R.drawable.ic_hot
            Tag.ECO -> R.drawable.ic_eco
            Tag.NEW, Tag.EXPRESS_MENU, Tag.HIT -> R.drawable.ic_discount
            else -> return
        }
    )
    Image(painter = tagToPainter, contentDescription = null)
}