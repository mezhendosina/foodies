package ru.mezhendosina.shared.ui.shop

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.ui.entities.CategoryEntity
import ru.mezhendosina.shared.ui.entities.ItemEntity

class PreviewShopComponent : ShopComponent {
    override val model: Value<ShopComponent.Model>
        get() = MutableValue(
            ShopComponent.Model(
                category = listOf(CategoryEntity.getPreview(), CategoryEntity.getPreview()),
                items = listOf(
                    ItemEntity.getPreview(0),
                    ItemEntity.getPreview(1),
                    ItemEntity.getPreview(0)
                ),
                0,
                123.0
            )
        )

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