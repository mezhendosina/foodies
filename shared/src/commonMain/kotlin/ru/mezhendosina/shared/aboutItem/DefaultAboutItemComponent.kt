package ru.mezhendosina.shared.aboutItem

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value

class DefaultAboutItemComponent(
    private val id: Int,
    private val componentContext: ComponentContext
) :
    AboutItemComponent, ComponentContext by componentContext {
    override val model: Value<AboutItemComponent.Model>
        get() = TODO("Not yet implemented")

    override fun onCartClick() {
        TODO("Not yet implemented")
    }

    override fun onBack() {
        TODO("Not yet implemented")
    }

    override fun onItemCountChanges(count: Int) {
        TODO("Not yet implemented")
    }
}