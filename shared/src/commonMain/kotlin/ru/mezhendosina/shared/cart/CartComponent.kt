package ru.mezhendosina.shared.cart

import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.entities.ItemEntity

interface CartComponent {
    val model: Value<Model>

    data class Model(
        val items: List<ItemEntity>
    )
}