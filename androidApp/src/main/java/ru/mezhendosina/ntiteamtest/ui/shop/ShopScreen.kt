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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.mezhendosina.ntiteamtest.R
import ru.mezhendosina.shared.entities.CategoryEntity
import ru.mezhendosina.shared.entities.ItemEntity
import ru.mezhendosina.ntiteamtest.ui.components.Category
import ru.mezhendosina.ntiteamtest.ui.components.FixedButton
import ru.mezhendosina.ntiteamtest.ui.components.ItemCard
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme
import ru.mezhendosina.shared.shop.PreviewShopComponent
import ru.mezhendosina.shared.shop.ShopComponent

@Composable
fun ShopScreen(component: ShopComponent) {
    val model by component.model.subscribeAsState()

    Scaffold(topBar = {
        LazyRow {
            items(model.category) {
                Category(name = it.name, enabled = it.id == model.selectedCategoryId) {
                    component.onCategoryClick(it.id)
                }
            }
        }
    }, bottomBar = {
        FixedButton(
            text = stringResource(R.string.rubs, model.cartSum),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            onCLick = component::onCartClick
        )
    }) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(167.dp),
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 8.dp),
        ) {
            items(model.items) { itemEntity ->
                ItemCard(
                    itemEntity = itemEntity,
                    onClick = { component.onItemClick(itemEntity.id) }) {
                    component.onItemCountChanges(itemEntity.id, it)
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
            PreviewShopComponent()
        )
    }
}


@Preview(device = "id:small_phone")
@Composable
private fun PreviewSmallShopScreen() {
    NtiTeamTestTheme {
        ShopScreen(
            PreviewShopComponent()
        )
    }
}