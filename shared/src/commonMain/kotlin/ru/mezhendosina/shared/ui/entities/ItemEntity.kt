package ru.mezhendosina.shared.ui.entities


/**
 * @param weight: вес продукта вместе с единицей измерения
 * Остальные параметры состава указаны на 100г
 */
data class ItemEntity(
    val id: Int,
    val name: String,
    val description: String,
    val weight: String,
    val energy: Float,
    val proteins: Float,
    val fats: Float,
    val carbohydrates: Float,
    val price: Int,
    val oldPrice: Int? = null,
    val count: Int = 0,
    val tag: Tag = Tag.NONE
) {

    fun updateCount(newCount: Int): ItemEntity = ItemEntity(
        id,
        name,
        description,
        weight,
        energy,
        proteins,
        fats,
        carbohydrates,
        price,
        oldPrice,
        newCount,
        tag
    )

    companion object {
        fun getPreview(count: Int): ItemEntity =
            ItemEntity(
                0,
                "test",
                "123",
                "123",
                123f,
                123f,
                123f,
                123f,
                123,
                123,
                count,
                Tag.HOT
            )
    }
}