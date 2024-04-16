package ru.mezhendosina.ntiteamtest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import ru.mezhendosina.ntiteamtest.R
import ru.mezhendosina.shared.ui.entities.Tag

@Composable
fun TagImage(tag: Tag, modifier: Modifier =Modifier) {
    val tagToPainter: Painter = painterResource(
        id = when (tag) {
            Tag.HOT -> R.drawable.ic_hot
            Tag.ECO -> R.drawable.ic_eco
            Tag.DISCOUNT -> R.drawable.ic_discount
            else -> return
        }
    )
    Image(painter = tagToPainter, contentDescription = null, modifier=modifier)
}