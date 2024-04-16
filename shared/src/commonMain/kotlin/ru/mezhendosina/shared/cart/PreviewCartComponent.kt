package ru.mezhendosina.shared.cart

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.entities.ItemEntity

class PreviewCartComponent : CartComponent {
    override val model: Value<CartComponent.Model> = MutableValue(
        CartComponent.Model(
            listOf(
                ItemEntity.getPreview(0),
                ItemEntity.getPreview(1),
                ItemEntity.getPreview(2),
                ItemEntity.getPreview(3),
            )
        )
    )
}