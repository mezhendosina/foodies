package ru.mezhendosina.foodies.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mezhendosina.foodies.R
import ru.mezhendosina.foodies.ui.theme.NtiTeamTestTheme


@Composable
fun ElevatedItemCounter(
    count: Int,
    surfaceBackground: Boolean = false,
    onCountChange: (count: Int) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .widthIn(148.dp)
            .height(40.dp)
    ) {
        ElevatedButton(
            onClick = { onCountChange(count - 1) },
            background = if (surfaceBackground) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.background,
            elevation = if (surfaceBackground) 0.dp else 10.dp
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_minus),
                contentDescription = null
            )
        }

        Text(text = count.toString(), color = MaterialTheme.colorScheme.onBackground)

        ElevatedButton(
            onClick = { onCountChange(count + 1) },
            background = if (surfaceBackground) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.background,
            elevation = if (surfaceBackground) 0.dp else 10.dp
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_plus), contentDescription = null)

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewCounter() {
    NtiTeamTestTheme {
        ElevatedItemCounter(count = 1) {

        }
    }
}