package ru.mezhendosina.foodies.ui.shop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import kotlinx.coroutines.launch
import ru.mezhendosina.foodies.R
import ru.mezhendosina.foodies.ui.components.Category
import ru.mezhendosina.foodies.ui.components.FixedButton
import ru.mezhendosina.foodies.ui.theme.NtiTeamTestTheme
import ru.mezhendosina.shared.ui.shop.PreviewShopComponent
import ru.mezhendosina.shared.ui.shop.ShopComponent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ShopScreen(component: ShopComponent) {
    val model by component.model.subscribeAsState()

    val pagerState = rememberPagerState {
        model.category.size
    }

    LaunchedEffect(pagerState.currentPage) {
        if (model.category.size > 0) {
            component.onCategoryClick(model.category[pagerState.currentPage].id)
        }
    }

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Image(
                            painterResource(id = R.drawable.ic_logo), null
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
                )
                AnimatedVisibility(
                    visible = model.category.isNotEmpty(),
                    enter = slideInVertically() + fadeIn(),
                ) {
                    ScrollableTabRow(
                        selectedTabIndex = pagerState.currentPage,
                        indicator = {},
                        containerColor = MaterialTheme.colorScheme.background,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        divider = {}
                    ) {
                        model.category.forEachIndexed { index, categoryEntity ->
                            Category(
                                name = categoryEntity.name,
                                enabled = categoryEntity.id == model.category[pagerState.currentPage].id
                            ) {
                                component.onCategoryClick(categoryEntity.id)
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }
                        }
                    }
                }
            }
        },
        bottomBar = {
            FixedButton(
                text = stringResource(R.string.rubs, model.cartSum),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                model.cartSum > 0,
                onCLick = component::onCartClick
            )
        }
    ) { paddingValues ->
        HorizontalPager(state = pagerState) {
            ShopItem(
                model.items,
                model.state,
                paddingValues,
                component::onItemClick,
                component::onItemCountChanges
            )
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