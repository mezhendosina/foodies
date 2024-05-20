package ru.mezhendosina.foodies.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ru.mezhendosina.foodies.R
import ru.mezhendosina.foodies.ui.theme.NtiTeamTestTheme

@Composable
fun FilterButton(icon: Painter, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(icon, null)
    }

}

@Preview
@Composable
private fun PreviewFilterButton() {
    NtiTeamTestTheme {
        FilterButton(icon = painterResource(id = R.drawable.ic_filter)) {

        }
    }
}