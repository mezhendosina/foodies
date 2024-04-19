package ru.mezhendosina.shared.ui.cart

import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.ui.entities.ItemEntity

interface CartComponent {
    val model: Value<Model>

    data class Model(
        val items: List<ItemEntity>
    )
}