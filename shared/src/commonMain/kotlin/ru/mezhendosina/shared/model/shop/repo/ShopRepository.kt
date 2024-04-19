package ru.mezhendosina.shared.model.shop.repo

import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.ui.entities.CategoryEntity
import ru.mezhendosina.shared.ui.entities.ItemEntity

interface ShopRepository {
    val items: Value<List<ItemEntity>>
    val categories: Value<List<CategoryEntity>>

    fun getItems(categoryId: Int)
}