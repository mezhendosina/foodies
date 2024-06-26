package ru.mezhendosina.foodies.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.mezhendosina.foodies.R
import ru.mezhendosina.foodies.ui.components.CartItem
import ru.mezhendosina.foodies.ui.components.CartTopBar
import ru.mezhendosina.foodies.ui.components.EmptyScreen
import ru.mezhendosina.foodies.ui.components.FixedButton
import ru.mezhendosina.foodies.ui.theme.NtiTeamTestTheme
import ru.mezhendosina.shared.ui.cart.CartComponent
import ru.mezhendosina.shared.ui.cart.PreviewCartComponent

@Composable
fun CartScreen(cartComponent: CartComponent) {
    val model by cartComponent.model.subscribeAsState()
    Scaffold(
        topBar = {
            CartTopBar(title = stringResource(R.string.cart), cartComponent::onBack)
        },
        bottomBar = {
            if (model.cartSum > 0)
            Box(
                modifier = Modifier
                    .shadow(10.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                FixedButton(
                    text = stringResource(R.string.buy_for, model.cartSum),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                        .navigationBarsPadding()
                ) { }
            }
        },
    ) { paddingValues ->
        if (model.items.isNotEmpty()) {
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(model.items) { itemEntity ->
                    CartItem(
                        itemEntity = itemEntity,
                        onClick = { cartComponent.toAboutItem(itemEntity.id) }
                    ) {
                        cartComponent.onItemChangeCount(itemEntity.id, it)
                    }
                }
            }
        } else {
            EmptyScreen(text = stringResource(R.string.empty_cart))
        }
    }
}

@Preview
@Composable
private fun PreviewCartScreen() {
    NtiTeamTestTheme {
        CartScreen(PreviewCartComponent())
    }
}