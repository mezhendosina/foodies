package ru.mezhendosina.shared.model.shop.repo

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.ui.entities.CategoryEntity
import ru.mezhendosina.shared.ui.entities.ItemEntity

class ShopRepositoryPreview: ShopRepository {
    override val items: Value<List<ItemEntity>>
        get() = MutableValue(
            listOf(
                ItemEntity.getPreview(0),
                ItemEntity.getPreview(0),
                ItemEntity.getPreview(0),
                ItemEntity.getPreview(0),
                ItemEntity.getPreview(0),
                ItemEntity.getPreview(0),
            )
        )
    override val categories: Value<List<CategoryEntity>>
        get() = MutableValue(emptyList())

    override suspend fun updateCount(item: ItemEntity) {
        TODO("Not yet implemented")
    }

    override fun getSum(): Double {
        TODO("Not yet implemented")
    }

    override suspend fun getItems() {
    }
}