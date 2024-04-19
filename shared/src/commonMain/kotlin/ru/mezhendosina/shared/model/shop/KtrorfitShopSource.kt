package ru.mezhendosina.shared.model.shop

import de.jensklingenberg.ktorfit.Ktorfit
import ru.mezhendosina.shared.ui.entities.CategoryEntity
import ru.mezhendosina.shared.ui.entities.ItemEntity

class KtrorfitShopSource(private val ktorfit: Ktorfit) : ShopSource {
    val shopApi = ktorfit.create<ShopApi>()
    override suspend fun getCategories(): List<CategoryEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getTags() {
        TODO("Not yet implemented")
    }

    override suspend fun getProducts(): List<ItemEntity> {
        TODO("Not yet implemented")
    }
}