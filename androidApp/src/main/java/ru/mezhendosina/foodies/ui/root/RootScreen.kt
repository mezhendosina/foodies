package ru.mezhendosina.foodies.ui.root

import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.androidPredictiveBackAnimatable
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.predictiveBackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import ru.mezhendosina.foodies.ui.aboutItem.AboutItemScreen
import ru.mezhendosina.foodies.ui.cart.CartScreen
import ru.mezhendosina.foodies.ui.shop.ShopScreen
import ru.mezhendosina.shared.ui.root.RootComponent

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun RootScreen(rootComponent: RootComponent) {
    Children(
        stack = rootComponent.childStack,
        animation = predictiveBackAnimation(
            backHandler = rootComponent.backHandler,
            selector = { backEvent, _, _ -> androidPredictiveBackAnimatable(backEvent) },
            fallbackAnimation = stackAnimation { child ->
                when (child.instance) {
                    is RootComponent.Child.CartChild -> fade() + slide()
                    is RootComponent.Child.AboutItemChild -> fade() + scale()
                    is RootComponent.Child.ShopChild -> fade()
                }

            },
            onBack = rootComponent::onBack,
        ),
    ) {

        when (val child = it.instance) {
            is RootComponent.Child.CartChild -> CartScreen(child.component)
            is RootComponent.Child.ShopChild -> ShopScreen(child.component)
            is RootComponent.Child.AboutItemChild -> AboutItemScreen(child.component)
        }
    }
}