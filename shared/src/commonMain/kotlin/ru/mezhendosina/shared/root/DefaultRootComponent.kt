package ru.mezhendosina.shared.root

import android.os.Parcelable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import ru.mezhendosina.shared.aboutItem.AboutItemComponent
import ru.mezhendosina.shared.aboutItem.DefaultAboutItemComponent
import ru.mezhendosina.shared.cart.CartComponent
import ru.mezhendosina.shared.cart.DefaultCartComponent
import ru.mezhendosina.shared.root.RootComponent.*
import ru.mezhendosina.shared.root.RootComponent.Child.*
import ru.mezhendosina.shared.shop.DefaultShopComponent
import ru.mezhendosina.shared.shop.ShopComponent

class DefaultRootComponent(
    private val componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()


    override val childStack: Value<ChildStack<*, Child>> = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Shop,
        handleBackButton = true,
        childFactory = ::child,
    )

    private fun child(config: Config, componentContext: ComponentContext): Child =
        when (config) {
            is Config.Shop -> ShopChild(itemShop(componentContext))
            is Config.Cart -> CartChild(itemCart(componentContext))
            is Config.AboutItem -> AboutItemChild(
                itemAboutItem(config.id, componentContext)
            )
        }

    private fun itemShop(componentContext: ComponentContext): ShopComponent = DefaultShopComponent(
        componentContext
    )

    private fun itemCart(componentContext: ComponentContext): CartComponent = DefaultCartComponent(
        componentContext
    )

    private fun itemAboutItem(id: Int, componentContext: ComponentContext): AboutItemComponent =
        DefaultAboutItemComponent(
            id,
            componentContext
        )

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Cart : Config

        @Serializable
        data class AboutItem(val id: Int) : Config

        @Serializable
        data object Shop : Config

    }
}