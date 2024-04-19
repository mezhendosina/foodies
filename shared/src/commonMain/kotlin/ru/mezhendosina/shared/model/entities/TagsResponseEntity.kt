package ru.mezhendosina.shared.model.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TagsResponseEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)