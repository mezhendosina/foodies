package ru.mezhendosina.ntiteamtest.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mezhendosina.ntiteamtest.R
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme

@Composable
fun OutlinedItemCounter(
    count: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    onCountChange: (count: Int) -> Unit
) {
    val iconColors = IconButtonDefaults.iconButtonColors(
        contentColor = MaterialTheme.colorScheme.primary,
        containerColor = backgroundColor
    )
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.widthIn(135.dp)
    ) {
        IconButton(
            onClick = { onCountChange(count - 1) },
            colors = iconColors,
            
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_minus),
                contentDescription = null
            )
        }

        Text(text = count.toString(), color = MaterialTheme.colorScheme.onBackground)

        IconButton(onClick = { onCountChange(count + 1) }, colors = iconColors) {
            Icon(painter = painterResource(id = R.drawable.ic_plus), contentDescription = null)
        }
    }

}

@Preview
@Composable
private fun PreviewOutlinedItemCounter() {
    NtiTeamTestTheme {
        var count by remember {
            mutableIntStateOf(0)
        }

        OutlinedItemCounter(count = count, backgroundColor = Color.Transparent) {
            count = it
        }
    }
}