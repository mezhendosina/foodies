package ru.mezhendosina.shared.root

import com.arkivanov.decompose.Child
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.aboutItem.AboutItemComponent
import ru.mezhendosina.shared.cart.CartComponent
import ru.mezhendosina.shared.shop.ShopComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>


    sealed class Child {
        class ShopChild(val component: ShopComponent) : Child()
        class AboutItemChild(val component: AboutItemComponent) : Child()
        class CartChild(val component: CartComponent) : Child()
    }
}