package ru.mezhendosina.shared.model.shop.repo

import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.ui.entities.CategoryEntity
import ru.mezhendosina.shared.ui.entities.ItemEntity

interface ShopRepository {
    val items: Value<List<ItemEntity>>
    val categories: Value<List<CategoryEntity>>


    /**
     * Изменяет количество элементов в корзине.
     * @param item элемент, который надо изменить, добавить в корзину или убрать из нее. Необходимо передавать с уже измененным количеством
     */
    suspend fun updateCount(item: ItemEntity)

    fun getSum(): Double


    suspend fun getItems(categoryId: Int)
}