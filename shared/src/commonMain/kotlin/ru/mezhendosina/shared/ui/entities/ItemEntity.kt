package ru.mezhendosina.shared.ui.entities


/**
 * @param weight: вес продукта вместе с единицей измерения
 * Остальные параметры состава указаны на 100г
 */
data class ItemEntity(
    val id: Int,
    val name: String,
    val description: String,
    val categoryId: Int,
    val weight: String,
    val energy: Double,
    val proteins: Double,
    val fats: Double,
    val carbohydrates: Double,
    val price: Double,
    val oldPrice: Double? = null,
    val count: Int = 0,
    val tag: Tag = Tag.NONE,
    val inCart: Boolean = false
) {

    fun inCart(boolean: Boolean): ItemEntity = ItemEntity(
        id,
        name,
        description,
        categoryId,
        weight,
        energy,
        proteins,
        fats,
        carbohydrates,
        price,
        oldPrice,
        count,
        tag,
        boolean
    )

    fun updateCount(newCount: Int): ItemEntity = ItemEntity(
        id,
        name,
        description,
        categoryId,
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
                0,
                "123",
                123.0,
                123.0,
                123.0,
                123.0,
                123.0,
                123.0,
                count,
                Tag.HOT
            )
    }
}