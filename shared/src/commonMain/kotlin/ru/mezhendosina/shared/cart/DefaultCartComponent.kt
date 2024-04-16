package ru.mezhendosina.shared.cart

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value

class DefaultCartComponent(private val componentContext: ComponentContext) : CartComponent,
    ComponentContext by componentContext {
    override val model: Value<CartComponent.Model>
        get() = TODO("Not yet implemented")
}