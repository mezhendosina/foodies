package ru.mezhendosina.ntiteamtest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mezhendosina.ntiteamtest.R
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme

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