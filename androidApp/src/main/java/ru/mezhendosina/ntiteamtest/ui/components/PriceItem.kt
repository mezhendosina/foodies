package ru.mezhendosina.ntiteamtest.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @param verticalPrice: Если true, отобразить старую цену снизу новой, иначе отобразить старую справа
 */
@Composable
fun PriceItem(
    price: Double,
    modifier: Modifier = Modifier,
    oldPrice: Double? = null,
    verticalPrice: Boolean = false
) {
    if (verticalPrice) {
        Column(
            modifier,
            horizontalAlignment = Alignment.End,
        ) { PriceContent(price, oldPrice, 2.dp) }
    } else {
        Row(verticalAlignment = Alignment.Bottom, modifier = modifier) {
            PriceContent(
                price,
                oldPrice
            )
        }
    }
}

@Composable
private fun PriceContent(price: Double, oldPrice: Double? = null, padding: Dp = 8.dp) {
    Text(
        text = "$price ₽",
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Medium
    )
    Spacer(modifier = Modifier.size(padding))
    if (oldPrice != null) {
        Text(
            text = "$oldPrice ₽",
            style = MaterialTheme.typography.bodySmall,
            textDecoration = TextDecoration.LineThrough,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}