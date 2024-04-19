package ru.mezhendosina.shared.model.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductRepsponseEntity(
    @SerialName("carbohydrates_per_100_grams")
    val carbohydratesPer100Grams: Double,
    @SerialName("category_id")
    val categoryId: Int,
    @SerialName("description")
    val description: String,
    @SerialName("energy_per_100_grams")
    val energyPer100Grams: Double,
    @SerialName("fats_per_100_grams")
    val fatsPer100Grams: Double,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("measure")
    val measure: Int,
    @SerialName("measure_unit")
    val measureUnit: String,
    @SerialName("name")
    val name: String,
    @SerialName("price_current")
    val priceCurrent: Int,
    @SerialName("price_old")
    val priceOld: Int,
    @SerialName("proteins_per_100_grams")
    val proteinsPer100Grams: Double,
    @SerialName("tag_ids")
    val tagIds: List<Int>
)