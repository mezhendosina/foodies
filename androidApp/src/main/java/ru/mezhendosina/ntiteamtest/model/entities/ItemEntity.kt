package ru.mezhendosina.ntiteamtest.model.entities

import androidx.compose.ui.graphics.painter.Painter
import ru.mezhendosina.ntiteamtest.model.Tag

data class ItemEntity(
    val id: Int,
    val name: String,
//    val preview: Painter,
    val price: Int,
    val weight: String,
    val oldPrice: Int? = null,
    val tag: Tag = Tag.NONE,
    val count: Int = 0,
) {
    companion object {
        fun getPreview(count: Int): ItemEntity =
            ItemEntity(
                0,
                "test",
                123,
                "123",
                123,
                Tag.HOT,
                count
            )
    }
}