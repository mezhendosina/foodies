package ru.mezhendosina.shared.ui.cart

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.subscribe
import com.arkivanov.decompose.value.update
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mezhendosina.shared.model.shop.repo.ShopRepository

class DefaultCartComponent(
    private val shopRepository: ShopRepository,
    private val componentContext: ComponentContext,
    private val onItemClick: (id: Int) -> Unit,
    private val onBack: () -> Unit
) : CartComponent, ComponentContext by componentContext {
    private val _model: MutableValue<CartComponent.Model> = MutableValue(
        CartComponent.Model(
            shopRepository.items.value.filter { it.inCart },
            shopRepository.getSum()
        )
    )
    override val model: Value<CartComponent.Model> = _model

    init {
        shopRepository.items.subscribe(lifecycle) { itemEntities ->
            val newItems = CartComponent.Model(
                itemEntities.filter { it.inCart },
                shopRepository.getSum()
            )
            _model.update { newItems }
        }
    }

    override fun toAboutItem(id: Int) {
        onItemClick(id)
    }

    override fun onItemChangeCount(id: Int, count: Int) {
        val item = _model.value.items.firstOrNull { id == it.id } ?: return
        CoroutineScope(Dispatchers.IO).launch {
            shopRepository.updateCount(item.updateCount(count))
        }
    }

    override fun onBack() = onBack.invoke()
}