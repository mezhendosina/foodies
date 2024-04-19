package ru.mezhendosina.shared.ui.shop

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.subscribe
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mezhendosina.shared.model.cart.CartRepository
import ru.mezhendosina.shared.model.shop.repo.ShopRepository

class DefaultShopComponent(
    private val shopRepository: ShopRepository,
    private val cartRepository: CartRepository,
    private val onCartClick: () -> Unit,
    private val onItemClick: (id: Int) -> Unit,
    componentContext: ComponentContext
) : ShopComponent,
    ComponentContext by componentContext {
    private val _model = MutableValue(
        ShopComponent.Model(
            shopRepository.categories.value,
            shopRepository.items.value,
            shopRepository.categories.value.firstOrNull()?.id ?: -1,
            0
        )
    )
    override val model: Value<ShopComponent.Model> = _model

    init {
        shopRepository.categories.subscribe(lifecycle) { list ->
            _model.update {
                ShopComponent.Model(
                    list,
                    it.items,
                    it.selectedCategoryId,
                    it.cartSum
                )
            }
        }
        shopRepository.items.subscribe(lifecycle) { list ->
            _model.update {
                ShopComponent.Model(
                    it.category,
                    list,
                    it.selectedCategoryId,
                    it.cartSum
                )
            }
        }
    }


    override fun onCategoryClick(id: Int) {
        _model.update {
            ShopComponent.Model(
                it.category,
                it.items,
                id,
                it.cartSum
            )
        }
    }

    override fun onCartClick() = onCartClick.invoke()

    override fun onItemClick(id: Int) = onItemClick.invoke(id)
    override fun onItemCountChanges(id: Int, count: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val getItem = _model.value.items.first { it.id == id }.updateCount(count)
            cartRepository.updateCount(getItem)
            val updateShop =
                shopRepository.items.value.map { if (it.id == getItem.id) getItem else it }
            val model = ShopComponent.Model(
                _model.value.category,
                updateShop,
                _model.value.selectedCategoryId,
                cartRepository.getSum()
            )

            withContext(Dispatchers.Main) {
                _model.update { model }
            }
        }
    }
}