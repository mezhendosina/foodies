package ru.mezhendosina.shared.ui.shop

import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.ui.entities.CategoryEntity
import ru.mezhendosina.shared.ui.entities.ItemEntity

interface ShopComponent {
    val model: Value<Model>


    fun onCategoryClick(id: Int)
    fun onCartClick()
    fun onItemClick(id: Int)
    fun onItemCountChanges(id: Int, count: Int)
    data class Model(
        val category: List<CategoryEntity>,
        val items: List<ItemEntity>,
        val selectedCategoryId: Int,
        val cartSum: Double
    )
}