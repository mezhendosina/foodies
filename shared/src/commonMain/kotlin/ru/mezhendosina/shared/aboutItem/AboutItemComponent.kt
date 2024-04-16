package ru.mezhendosina.shared.aboutItem

import com.arkivanov.decompose.value.Value
import ru.mezhendosina.shared.entities.AboutItemEntity

interface AboutItemComponent {
    val model: Value<Model>

    fun onCartClick()
    fun onBack()
    fun onItemCountChanges(count: Int)


    data class Model(
        val aboutItem: AboutItemEntity
    )

}