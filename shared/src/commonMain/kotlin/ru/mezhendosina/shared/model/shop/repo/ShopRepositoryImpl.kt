package ru.mezhendosina.shared.model.shop.repo

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.mezhendosina.shared.model.shop.ShopSource
import ru.mezhendosina.shared.ui.entities.CategoryEntity
import ru.mezhendosina.shared.ui.entities.ItemEntity

class ShopRepositoryImpl(
    private val shopSource: ShopSource
) : ShopRepository {

    private val _items: MutableValue<List<ItemEntity>> = MutableValue(emptyList())
    override val items: Value<List<ItemEntity>> = _items

    private val _categories: MutableValue<List<CategoryEntity>> = MutableValue(emptyList())
    override val categories: Value<List<CategoryEntity>> = _categories
    override suspend fun updateCount(item: ItemEntity) {
        if (item.count == 0) item.deleteFromCart()
        else if (item.count > 0 && !item.inCart) item.addToCart()
        else if (item.count > 0) item.updateCart()
    }

    private fun ItemEntity.updateCart() {
        _items.value = _items.value.map { if (it.id == this.id) this else it }
    }

    private fun ItemEntity.addToCart() {
        _items.value = _items.value.map {
            if (it.id == this.id) this.inCart(true) else it
        }
    }

    private fun ItemEntity.deleteFromCart() {
        _items.value = _items.value.map { if (it.id == this.id) this.inCart(false) else it }
    }

    override fun getSum(): Double = _items.value.sumOf { if (it.inCart) it.price * it.count else 0.0 }

    override suspend fun getItems(categoryId: Int) {
        if (_items.value.isNotEmpty()) return
        val resp = shopSource.getProducts()
        withContext(Dispatchers.Main) {
            _items.update { resp }
        }

    }
}