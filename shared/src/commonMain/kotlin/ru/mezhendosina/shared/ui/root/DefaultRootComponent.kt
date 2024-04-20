package ru.mezhendosina.shared.ui.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import kotlinx.serialization.Serializable
import ru.mezhendosina.shared.model.cart.CartRepository
import ru.mezhendosina.shared.model.shop.repo.ShopRepository
import ru.mezhendosina.shared.ui.aboutItem.AboutItemComponent
import ru.mezhendosina.shared.ui.aboutItem.DefaultAboutItemComponent
import ru.mezhendosina.shared.ui.cart.CartComponent
import ru.mezhendosina.shared.ui.cart.DefaultCartComponent
import ru.mezhendosina.shared.ui.root.RootComponent.*
import ru.mezhendosina.shared.ui.root.RootComponent.Child.*
import ru.mezhendosina.shared.ui.shop.DefaultShopComponent
import ru.mezhendosina.shared.ui.shop.ShopComponent

@OptIn(ExperimentalDecomposeApi::class)
class DefaultRootComponent(
    private val componentContext: ComponentContext,
    private val shopRepository: ShopRepository,
    private val cartRepository: CartRepository
) : RootComponent, ComponentContext by componentContext, BackHandlerOwner {
    private val navigation = StackNavigation<Config>()


    override val childStack: Value<ChildStack<*, Child>> = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Shop,
        handleBackButton = true,
        childFactory = ::child,
    )

    override fun onBack() {
        navigation.pop()
    }

    private fun child(config: Config, componentContext: ComponentContext): Child =
        when (config) {
            is Config.Shop -> ShopChild(itemShop(componentContext))
            is Config.Cart -> CartChild(itemCart(componentContext))
            is Config.AboutItem -> AboutItemChild(
                itemAboutItem(config.id, componentContext)
            )
        }

    private fun itemShop(componentContext: ComponentContext): ShopComponent =
        DefaultShopComponent(
            shopRepository,
            { navigation.push(Config.Cart) },
            { navigation.push(Config.AboutItem(it)) },
            componentContext
        )

    private fun itemCart(componentContext: ComponentContext): CartComponent =
        DefaultCartComponent(
            shopRepository,
            componentContext,
            { navigation.push(Config.AboutItem(it)) },
            navigation::pop
        )

    private fun itemAboutItem(id: Int, componentContext: ComponentContext): AboutItemComponent =
        DefaultAboutItemComponent(
            id,
            shopRepository,
            cartRepository,
            navigation::pop,
            componentContext,
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