package ru.mezhendosina.ntiteamtest.ui.aboutItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.mezhendosina.ntiteamtest.R
import ru.mezhendosina.shared.entities.AboutItemEntity
import ru.mezhendosina.ntiteamtest.ui.components.FixedButton
import ru.mezhendosina.ntiteamtest.ui.components.MeasurementsItem
import ru.mezhendosina.ntiteamtest.ui.components.OutlinedItemCounter
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme
import ru.mezhendosina.shared.aboutItem.AboutItemComponent
import ru.mezhendosina.shared.aboutItem.PreviewAboutItemComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutItemScreen(component: AboutItemComponent) {
    val model by component.model.subscribeAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {}, navigationIcon = {
                IconButton(onClick = component::onBack, modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_left),
                        stringResource(R.string.back),
                    )
                }
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            )
            )
        },
        bottomBar = {
            if (model.aboutItem.count == 0) {
                FixedButton(
                    text = stringResource(R.string.to_cart, model.aboutItem.price),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 12.dp
                        ),
                    onCLick = component::onCartClick
                )
            } else {
                OutlinedItemCounter(
                    count = model.aboutItem.count,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    Color.Transparent,
                    onCountChange = { component.onItemCountChanges(it) }
                )
            }
        },
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = it.calculateBottomPadding())
                .verticalScroll(rememberScrollState())
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.ic_hot),
                    contentDescription = model.aboutItem.name,
                    modifier = Modifier.size(375.dp)
                )
            }
            Spacer(Modifier.size(24.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    model.aboutItem.name,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = model.aboutItem.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.size(24.dp))
            MeasurementsItem(name = stringResource(R.string.weight), value = model.aboutItem.weight)
            MeasurementsItem(
                name = stringResource(R.string.energy), value = stringResource(
                    R.string.gramms,
                    model.aboutItem.energy
                )
            )

            MeasurementsItem(
                name = stringResource(R.string.proteins), value = stringResource(
                    R.string.gramms,
                    model.aboutItem.proteins
                )
            )


            MeasurementsItem(
                name = stringResource(R.string.fats), value = stringResource(
                    R.string.gramms,
                    model.aboutItem.fats
                )
            )
            HorizontalDivider()
        }
    }
}

@Preview
@Composable
private fun PreviewAboutItemScreen() {
    NtiTeamTestTheme {
        AboutItemScreen(PreviewAboutItemComponent())
    }
}