package ru.mezhendosina.shared.ui.aboutItem

import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.ui.entities.ItemEntity

interface AboutItemComponent {
    val model: Value<Model>


    suspend fun onCartClick()

    fun onBack()

    fun onItemCountChanges(count: Int)

    data class Model(
        val aboutItem: ItemEntity,
    )
}
