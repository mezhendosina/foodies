package ru.mezhendosina.foodies.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mezhendosina.foodies.ui.theme.NtiTeamTestTheme

@Composable
fun Category(name: String, enabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) MaterialTheme.colorScheme.primary else Color.Transparent,
            contentColor = if (enabled) MaterialTheme.colorScheme.onPrimary else Color.Black
        ),
        modifier = Modifier.padding(horizontal = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(name, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
    }
}

@Preview
@Composable
private fun PreviewDisabledCategory() {
    NtiTeamTestTheme {
        Category("Label", false) {

        }

    }
}

@Preview
@Composable
private fun PreviewEnabledCategory() {
    NtiTeamTestTheme {
        Category("Label", true) {

        }

    }
}