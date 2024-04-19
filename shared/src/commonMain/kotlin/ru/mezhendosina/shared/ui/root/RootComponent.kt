package ru.mezhendosina.shared.ui.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.ui.aboutItem.AboutItemComponent
import ru.mezhendosina.shared.ui.cart.CartComponent
import ru.mezhendosina.shared.ui.shop.ShopComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>


    sealed class Child {
        class ShopChild(val component: ShopComponent) : Child()
        class AboutItemChild(val component: AboutItemComponent) : Child()
        class CartChild(val component: CartComponent) : Child()
    }
}