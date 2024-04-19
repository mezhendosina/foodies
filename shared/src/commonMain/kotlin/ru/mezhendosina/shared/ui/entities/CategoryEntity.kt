package ru.mezhendosina.shared.ui.entities

data class CategoryEntity(
    val id: Int,
    val name: String
){
    companion object{
        fun getPreview(): CategoryEntity =
            CategoryEntity(
                0,
                "Ролы"
            )
    }
}
