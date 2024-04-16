package ru.mezhendosina.shared.shop

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value

class DefaultShopComponent(val componentContext: ComponentContext) : ShopComponent,
    ComponentContext by componentContext {
    override val model: Value<ShopComponent.Model>
        get() = TODO("Not yet implemented")

    override fun onCategoryClick(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onCartClick() {
        TODO("Not yet implemented")
    }

    override fun onItemClick(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onItemCountChanges(id: Int, count: Int) {
        TODO("Not yet implemented")
    }
}