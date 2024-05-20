package ru.mezhendosina.foodies.ui.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.mezhendosina.shared.ui.entities.CategoryEntity

@Composable
fun ShopTopBar(
    categories: List<CategoryEntity>,
    selectedId: Int,
    modifier: Modifier = Modifier,
    onCategoryClick: (id: Int) -> Unit
) {
    LazyRow {
        items(categories) {
            Category(name = it.name, enabled = it.id == selectedId) {
                onCategoryClick(it.id)
            }
        }
    }
}