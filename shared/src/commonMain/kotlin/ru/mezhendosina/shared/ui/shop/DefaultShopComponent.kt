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
import ru.mezhendosina.shared.model.shop.repo.ShopRepository
import ru.mezhendosina.shared.ui.entities.ItemEntity
import ru.mezhendosina.shared.ui.entities.UiState

class DefaultShopComponent(
    private val shopRepository: ShopRepository,
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
            UiState.LOADED,
            shopRepository.getSum()
        )
    )
    override val model: Value<ShopComponent.Model> = _model

    init {
        CoroutineScope(Dispatchers.IO).launch {
            stateLoading()
            shopRepository.getItems(_model.value.selectedCategoryId)
        }
        shopRepository.categories.subscribe(lifecycle) { list ->
            _model.update {
                ShopComponent.Model(
                    list,
                    it.items,
                    if (it.selectedCategoryId == -1) list.firstOrNull()?.id
                        ?: -1 else it.selectedCategoryId,
                    it.state,
                    it.cartSum
                )
            }
        }
        shopRepository.items.subscribe(lifecycle) { list ->
            CoroutineScope(Dispatchers.IO).launch {
                _model.update {
                    ShopComponent.Model(
                        it.category,
                        list,
                        it.selectedCategoryId,
                        UiState.LOADED,
                        shopRepository.getSum()
                    )
                }
            }
        }
    }


    override fun onCategoryClick(id: Int) {
        _model.update { modelUpdate ->
            ShopComponent.Model(
                modelUpdate.category,
                shopRepository.items.value.filter { it.categoryId == id },
                id,
                modelUpdate.state,
                modelUpdate.cartSum
            )
        }
    }

    override fun onCartClick() = onCartClick.invoke()

    override fun onItemClick(id: Int) = onItemClick.invoke(id)
    override fun onItemCountChanges(id: Int, count: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val getItem = _model.value.items.first { it.id == id }.updateCount(count)
            shopRepository.updateCount(getItem)

        }
    }

    private suspend fun stateLoading() {
        withContext(Dispatchers.Main) {
            _model.update {
                ShopComponent.Model(
                    it.category,
                    it.items,
                    it.selectedCategoryId,
                    UiState.LOADING,
                    it.cartSum
                )
            }
        }
    }

}