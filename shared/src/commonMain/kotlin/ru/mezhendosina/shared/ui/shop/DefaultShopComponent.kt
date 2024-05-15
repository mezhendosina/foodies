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
import ru.mezhendosina.shared.ui.entities.CategoryEntity
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
            UiState.LOADING,
            shopRepository.getSum()
        )
    )
    override val model: Value<ShopComponent.Model> = _model

    init {
        CoroutineScope(Dispatchers.IO).launch {
            stateLoading()
            shopRepository.getItems()
            stateLoaded()
        }
        shopRepository.categories.subscribe(lifecycle) { list ->
            updateCategories(list)
        }
        shopRepository.items.subscribe(lifecycle) { list ->
            updateItems(list)
        }
        model.subscribe(lifecycle) {
            filterItems(it)
        }
    }

    private fun filterItems(model1: ShopComponent.Model) {
        CoroutineScope(Dispatchers.IO).launch {
            if (model1.items.find { it.categoryId == model1.selectedCategoryId } == null && model1.selectedCategoryId != -1) {
                val items =
                    shopRepository.items.value.filter { it.categoryId == model1.selectedCategoryId }
                        .sortedBy { it.name }
                withContext(Dispatchers.Main) {
                    _model.update {
                        ShopComponent.Model(
                            it.category,
                            items,
                            it.selectedCategoryId,
                            it.state,
                            it.cartSum
                        )
                    }
                }
            }
        }
    }

    private fun updateCategories(list: List<CategoryEntity>) {
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

    private fun updateItems(list: List<ItemEntity>) {
        CoroutineScope(Dispatchers.IO).launch {
            val sortList =
                list.filter { it.categoryId == model.value.selectedCategoryId }.sortedBy { it.name }
            withContext(Dispatchers.Main) {
                _model.update {
                    ShopComponent.Model(
                        it.category,
                        sortList,
                        it.selectedCategoryId,
                        it.state,
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
                modelUpdate.items,
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

    private suspend fun stateLoaded() {
        withContext(Dispatchers.Main) {
            _model.update {
                ShopComponent.Model(
                    it.category,
                    it.items,
                    it.selectedCategoryId,
                    UiState.LOADED,
                    it.cartSum
                )
            }
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