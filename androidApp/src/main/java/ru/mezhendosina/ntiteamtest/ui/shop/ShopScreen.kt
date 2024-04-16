package ru.mezhendosina.ntiteamtest.ui.shop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mezhendosina.ntiteamtest.model.entities.CategoryEntity
import ru.mezhendosina.ntiteamtest.model.entities.ItemEntity
import ru.mezhendosina.ntiteamtest.ui.components.Category
import ru.mezhendosina.ntiteamtest.ui.components.FixedButton
import ru.mezhendosina.ntiteamtest.ui.components.ItemCard
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme

@Composable
fun ShopScreen(category: List<CategoryEntity>, items: List<ItemEntity>) {
    var selectedCategoryId by remember {
        mutableIntStateOf(category.firstOrNull()?.id ?: -1)
    }

    Scaffold(topBar = {
        LazyRow {
            items(category) {
                Category(name = it.name, enabled = it.id == selectedCategoryId) {
                    selectedCategoryId = it.id
                }
            }
        }
    }, bottomBar = {
        FixedButton(
            text = "123",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            TODO()
        }
    }) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(167.dp),
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 8.dp),
        ) {
            items(items) {
                ItemCard(itemEntity = it, onClick = { /*TODO*/ }) {

                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewShopScreen() {
    NtiTeamTestTheme {
        ShopScreen(
            category = listOf(CategoryEntity.getPreview(), CategoryEntity.getPreview()),
            items = listOf(
                ItemEntity.getPreview(0),
                ItemEntity.getPreview(1),
                ItemEntity.getPreview(0)
            )
        )
    }
}


@Preview(device = "id:small_phone")
@Composable
private fun PreviewSmallShopScreen() {
    NtiTeamTestTheme {
        ShopScreen(
            category = listOf(CategoryEntity.getPreview(), CategoryEntity.getPreview()),
            items = listOf(
                ItemEntity.getPreview(0),
                ItemEntity.getPreview(1),
                ItemEntity.getPreview(0)
            )
        )
    }
}