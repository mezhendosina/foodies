package ru.mezhendosina.ntiteamtest.ui.shop

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.mezhendosina.ntiteamtest.R
import ru.mezhendosina.ntiteamtest.ui.components.EmptyScreen
import ru.mezhendosina.ntiteamtest.ui.components.ItemCard
import ru.mezhendosina.shared.ui.entities.ItemEntity
import ru.mezhendosina.shared.ui.entities.UiState

@Composable
fun ShopItem(
    items: List<ItemEntity>,
    state: UiState,
    paddingValues: PaddingValues,
    onItemClick: (Int) -> Unit,
    onItemCountChanges: (Int, Int) -> Unit
) {

    AnimatedContent(targetState = state) {
        if (it == UiState.LOADING) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
            return@AnimatedContent
        } else if (items.isEmpty() && state == UiState.LOADED) {
            EmptyScreen(text = stringResource(R.string.emty_catalog))
            return@AnimatedContent
        }

        LazyVerticalGrid(
            columns = GridCells.Adaptive(167.dp),
            modifier = Modifier
                .animateContentSize()
                .padding(paddingValues)
                .padding(horizontal = 8.dp),
        ) {
            items(items) { itemEntity ->
                ItemCard(
                    itemEntity = itemEntity,
                    onClick = { onItemClick(itemEntity.id) }) {
                    onItemCountChanges(itemEntity.id, it)
                }
            }
        }
    }
}