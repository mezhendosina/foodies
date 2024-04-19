package ru.mezhendosina.ntiteamtest.ui.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import org.koin.compose.getKoin
import ru.mezhendosina.ntiteamtest.ui.aboutItem.AboutItemScreen
import ru.mezhendosina.ntiteamtest.ui.cart.CartScreen
import ru.mezhendosina.ntiteamtest.ui.shop.ShopScreen
import ru.mezhendosina.shared.ui.root.RootComponent

@Composable
fun RootScreen(rootComponent: RootComponent) {
    Children(stack = rootComponent.childStack) {
        when (val child = it.instance) {
            is RootComponent.Child.CartChild -> CartScreen(child.component)
            is RootComponent.Child.ShopChild -> ShopScreen(child.component)
            is RootComponent.Child.AboutItemChild -> AboutItemScreen(child.component)
        }
    }
}