package ru.mezhendosina.ntiteamtest.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme

@Composable
fun MeasurementsItem(name: String, value: String) {
    Column {
        HorizontalDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = name)
            Text(text = value)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMeasurementsItem() {
    NtiTeamTestTheme {
        Column {
            MeasurementsItem(name = "123", value = "123г")
            MeasurementsItem(name = "123", value = "123г")
            MeasurementsItem(name = "123", value = "123г")

        }
    }
}