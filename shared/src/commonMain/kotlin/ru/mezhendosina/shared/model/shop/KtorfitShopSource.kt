package ru.mezhendosina.shared.model.shop

import de.jensklingenberg.ktorfit.Ktorfit
import ru.mezhendosina.shared.model.entities.ProductRepsponseEntity
import ru.mezhendosina.shared.ui.entities.CategoryEntity
import ru.mezhendosina.shared.ui.entities.ItemEntity

class KtorfitShopSource(private val ktorfit: Ktorfit) : ShopSource {
    val shopApi = ktorfit.create<ShopApi>()
    override suspend fun getCategories(): List<CategoryEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getTags() {
        TODO("Not yet implemented")
    }

    override suspend fun getProducts(): List<ItemEntity> {
        return shopApi.getProducts().toItemList()
    }

    private fun List<ProductRepsponseEntity>.toItemList(): List<ItemEntity> = this.map {
        ItemEntity(
            it.id,
            it.name,
            it.description,
            "${it.measure} ${it.measureUnit}",
            it.energyPer100Grams,
            it.proteinsPer100Grams,
            it.fatsPer100Grams,
            it.carbohydratesPer100Grams,
            (it.priceCurrent / 100).toDouble(),
            (it.priceOld?.div(100))?.toDouble(),
//            tag = it.tagIds.firstOrNull() ?: Tag.NONE
        )
    }
}