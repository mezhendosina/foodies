package ru.mezhendosina.shared.ui.cart

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.ui.entities.ItemEntity

class PreviewCartComponent : CartComponent {
    override val model: Value<CartComponent.Model> = MutableValue(
        CartComponent.Model(
            listOf(
                ItemEntity.getPreview(0),
                ItemEntity.getPreview(1),
                ItemEntity.getPreview(2),
                ItemEntity.getPreview(3),
            ),
            0.0
        )
    )

    override fun toAboutItem(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onItemChangeCount(id: Int, count: Int) {
        TODO("Not yet implemented")
    }

    override fun onBack() {
        TODO("Not yet implemented")
    }
}