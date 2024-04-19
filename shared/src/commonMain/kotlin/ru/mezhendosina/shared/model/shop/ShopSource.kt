package ru.mezhendosina.shared.model.shop

import ru.mezhendosina.shared.ui.entities.CategoryEntity
import ru.mezhendosina.shared.ui.entities.ItemEntity

interface ShopSource {

    suspend fun getCategories(): List<CategoryEntity>

    suspend fun getTags()

    suspend fun getProducts(): List<ItemEntity>
}