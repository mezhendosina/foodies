package ru.mezhendosina.foodies.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    verticalPadding: Dp = 14.dp,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit,
    content: @Composable (RowScope) -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        content = content,
        colors = colors,
        elevation = ButtonDefaults.buttonElevation(10.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = verticalPadding),
    )
}