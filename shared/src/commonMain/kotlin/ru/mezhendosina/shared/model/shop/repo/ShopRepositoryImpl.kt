package ru.mezhendosina.shared.model.shop.repo

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.ui.entities.CategoryEntity
import ru.mezhendosina.shared.ui.entities.ItemEntity

class ShopRepositoryImpl : ShopRepository {

    val _items: MutableValue<List<ItemEntity>> = MutableValue(emptyList())
    override val items: Value<List<ItemEntity>> = _items


    val _categories: MutableValue<List<CategoryEntity>> = MutableValue(emptyList())
    override val categories: Value<List<CategoryEntity>> = _categories


    override fun getItems(categoryId: Int) {

    }
}