package ru.mezhendosina.ntiteamtest.ui.shop

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.koin.compose.getKoin
import org.koin.core.context.GlobalContext.get
import ru.mezhendosina.ntiteamtest.R
import ru.mezhendosina.ntiteamtest.ui.components.Category
import ru.mezhendosina.ntiteamtest.ui.components.EmptyScreen
import ru.mezhendosina.ntiteamtest.ui.components.FixedButton
import ru.mezhendosina.ntiteamtest.ui.components.ItemCard
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme
import ru.mezhendosina.shared.ui.entities.UiState
import ru.mezhendosina.shared.ui.shop.PreviewShopComponent
import ru.mezhendosina.shared.ui.shop.ShopComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopScreen(component: ShopComponent) {
    val model by component.model.subscribeAsState()

    Scaffold(topBar = {
        Column {
            CenterAlignedTopAppBar(
                title = {
                    Image(
                        painterResource(id = R.drawable.ic_logo),
                        null
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
            AnimatedVisibility(
                visible = model.category.isNotEmpty(),
                enter = slideInVertically() + fadeIn(),

                ) {
                LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
                    items(model.category) {
                        Category(name = it.name, enabled = it.id == model.selectedCategoryId) {
                            component.onCategoryClick(it.id)
                        }
                    }
                }
            }
        }

    }, bottomBar = {
        FixedButton(
            text = stringResource(R.string.rubs, model.cartSum),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            model.cartSum > 0,
            onCLick = component::onCartClick
        )
    }) { paddingValues ->
        AnimatedContent(targetState = model.state) {
            if (it == UiState.LOADING) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
                return@AnimatedContent
            } else if (model.items.isEmpty() && model.state == UiState.LOADED) {
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