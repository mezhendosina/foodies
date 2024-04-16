package ru.mezhendosina.ntiteamtest.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.mezhendosina.ntiteamtest.R
import ru.mezhendosina.shared.entities.ItemEntity
import ru.mezhendosina.ntiteamtest.ui.components.CartItem
import ru.mezhendosina.ntiteamtest.ui.components.CartTopBar
import ru.mezhendosina.ntiteamtest.ui.components.EmptyScreen
import ru.mezhendosina.ntiteamtest.ui.components.FixedButton
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme
import ru.mezhendosina.shared.cart.CartComponent
import ru.mezhendosina.shared.cart.PreviewCartComponent

@Composable
fun CartScreen(cartComponent: CartComponent) {
    val model by cartComponent.model.subscribeAsState()
    Scaffold(
        topBar = {
            CartTopBar(title = stringResource(R.string.cart))
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .shadow(10.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                FixedButton(
                    text = stringResource(R.string.buy_for, model.items.size),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) { }
            }
        },
    ) { paddingValues ->
        if (model.items.isNotEmpty()) {
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(model.items) {
                    CartItem(itemEntity = it) {

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