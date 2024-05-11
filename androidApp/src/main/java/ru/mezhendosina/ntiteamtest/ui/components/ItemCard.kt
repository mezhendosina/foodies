package ru.mezhendosina.ntiteamtest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mezhendosina.ntiteamtest.R
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme
import ru.mezhendosina.shared.ui.entities.ItemEntity

@Composable
fun ItemCard(
    itemEntity: ItemEntity,
    onClick: () -> Unit,
    onCountChanges: (count: Int) -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .width(167.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .height(170.dp)
                .fillMaxWidth()
        ) {
            TagsList(itemEntity.tags, modifier = Modifier.padding(8.dp))
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.ic_photo),
                contentDescription = itemEntity.name
            )
        }

        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = itemEntity.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(text = itemEntity.weight, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.size(12.dp))
            if (itemEntity.count <= 0) {
                AddToCartButton(
                    price = itemEntity.price,
                    modifier = Modifier.fillMaxWidth(),
                    oldPrice = itemEntity.oldPrice
                ) {
                    onCountChanges(1)
                }
            } else {
                ElevatedItemCounter(count = itemEntity.count) {
                    onCountChanges(it)
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewItemCard() {
    NtiTeamTestTheme {
        var count by remember { mutableIntStateOf(0) }

        ItemCard(
            ItemEntity.getPreview(count), {}
        ) {
            count = it
        }
    }
}