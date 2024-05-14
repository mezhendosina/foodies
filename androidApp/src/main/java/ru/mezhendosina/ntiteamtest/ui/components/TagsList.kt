package ru.mezhendosina.ntiteamtest.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.mezhendosina.shared.ui.entities.Tag

@Composable
fun TagsList(tags: List<Int>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        tags.forEach {
            TagImage(tag = it)
        }
    }
}