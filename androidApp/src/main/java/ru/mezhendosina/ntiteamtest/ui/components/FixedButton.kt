package ru.mezhendosina.ntiteamtest.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme

@Composable
fun FixedButton(text: String, modifier: Modifier, show: Boolean = true, onCLick: () -> Unit) {
    AnimatedVisibility(
        visible = show,
        enter = fadeIn() + slideInVertically(
            initialOffsetY = { it / 2 }
        ),
        exit = fadeOut() + slideOutVertically(
            targetOffsetY = { it /2 }
        )
    ) {
        Button(
            onClick = onCLick,
            modifier = modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 16.dp),
            shape = RoundedCornerShape(8.dp)
        ) {

            Text(
                text,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
private fun PreviewFixedButton() {
    NtiTeamTestTheme {
        FixedButton(text = "Label", Modifier.padding(horizontal = 16.dp)) {}
    }
}