package ru.mezhendosina.ntiteamtest.model.entities

import java.util.ArrayList


/**
 * @param weight: вес продукта вместе с единицей измерения
 * Остальные параметры состава указаны на 100г
 */
data class AboutItemEntity(
    val id: Int,
    val imageId: Int,
    val name: String,
    val description: String,
    val weight: String,
    val energy: Float,
    val proteins: Float,
    val fats: Float,
    val carbohydrates: Float,
    val price: Int,
    val count: Int
)