package ru.mezhendosina.shared.model.cart

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.mezhendosina.shared.ui.entities.ItemEntity

class CartRepositoryImpl : CartRepository {
    private val _cart: MutableValue<List<ItemEntity>> = MutableValue(emptyList())
    val cart: Value<List<ItemEntity>> = _cart

    private suspend fun addToCart(item: ItemEntity) {
        val add = _cart.value.plus(item)
        withContext(Dispatchers.Main) {
            _cart.update { add }
        }
    }

    private suspend fun updateCart(item: ItemEntity) {
        val update = _cart.value.map { if (it.id == item.id) item else it }
        withContext(Dispatchers.Main) {
            _cart.update { update }
        }
    }


    private suspend fun deleteFromCart(item: ItemEntity) {
        val delete = _cart.value.filter { it.id != item.id }
        withContext(Dispatchers.Main) {
            _cart.update { delete }
        }
    }

    override suspend fun updateCount(item: ItemEntity) {
        if (item.count == 0) deleteFromCart(item)
        else if (item.count > 0 && item.inCart()) updateCart(item)
        else if (item.count > 0 && !item.inCart()) addToCart(item)

    }

    override fun getSum(): Double = _cart.value.sumOf { it.price * it.count }

    private fun ItemEntity.inCart(): Boolean = _cart.value.find { it.id == this.id } != null
}