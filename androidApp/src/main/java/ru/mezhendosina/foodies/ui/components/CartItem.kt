package ru.mezhendosina.foodies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mezhendosina.foodies.R
import ru.mezhendosina.foodies.ui.theme.NtiTeamTestTheme
import ru.mezhendosina.shared.ui.entities.ItemEntity

@Composable
fun CartItem(
    itemEntity: ItemEntity,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onCountChanges: (count: Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick.invoke() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_photo),
            contentDescription = itemEntity.name,
            modifier = Modifier.size(96.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Column(verticalArrangement = Arrangement.SpaceAround) {
            Text(text = itemEntity.name)
            Spacer(modifier = Modifier.size(12.dp))
            Row(verticalAlignment = Alignment.Bottom) {
                ElevatedItemCounter(
                    count = itemEntity.count,
                    surfaceBackground = true
                ) {
                    onCountChanges(it)
                }
                PriceItem(
                    price = itemEntity.price,
                    oldPrice = itemEntity.oldPrice,
                    verticalPrice = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Bottom)
                )
            }
        }

    }
    HorizontalDivider()
}

@Preview(showBackground = true)
@Composable
private fun PreviewCartItem() {
    NtiTeamTestTheme {
        CartItem(ItemEntity.getPreview(1), onClick = {}) {

        }
    }
}