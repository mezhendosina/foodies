package ru.mezhendosina.ntiteamtest.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.mezhendosina.ntiteamtest.R

@Composable
fun ElevatedButton(
    onClick: () -> Unit,
    background: Color = MaterialTheme.colorScheme.background,
    elevation: Dp = 10.dp,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = background,
            contentColor = MaterialTheme.colorScheme.primary
        ),
        elevation = ButtonDefaults.buttonElevation(elevation),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(40.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        content.invoke()

    }
}