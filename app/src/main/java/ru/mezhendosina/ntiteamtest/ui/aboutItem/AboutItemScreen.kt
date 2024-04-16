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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mezhendosina.ntiteamtest.R
import ru.mezhendosina.ntiteamtest.model.entities.AboutItemEntity
import ru.mezhendosina.ntiteamtest.ui.components.FixedButton
import ru.mezhendosina.ntiteamtest.ui.components.MeasurementsItem
import ru.mezhendosina.ntiteamtest.ui.components.OutlinedItemCounter
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutItemScreen(aboutItemEntity: AboutItemEntity) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { }, navigationIcon = {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(16.dp)) {
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
            if (aboutItemEntity.count == 0) {
                FixedButton(
                    text = stringResource(R.string.to_cart, aboutItemEntity.price),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 12.dp
                        )
                ) {

                }
            } else {
                OutlinedItemCounter(
                    count = aboutItemEntity.count,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    Color.Transparent
                ) {

                }
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
                    contentDescription = aboutItemEntity.name,
                    modifier = Modifier.size(375.dp)
                )
            }
            Spacer(Modifier.size(24.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    aboutItemEntity.name,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = aboutItemEntity.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.size(24.dp))
            MeasurementsItem(name = stringResource(R.string.weight), value = aboutItemEntity.weight)
            MeasurementsItem(
                name = stringResource(R.string.energy), value = stringResource(
                    R.string.gramms,
                    aboutItemEntity.energy
                )
            )

            MeasurementsItem(
                name = stringResource(R.string.proteins), value = stringResource(
                    R.string.gramms,
                    aboutItemEntity.proteins
                )
            )


            MeasurementsItem(
                name = stringResource(R.string.fats), value = stringResource(
                    R.string.gramms,
                    aboutItemEntity.fats
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
        AboutItemScreen(
            aboutItemEntity = AboutItemEntity(
                0,
                0,
                "test",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent pellentesque felis vulputate sodales vestibulum. Mauris vel ipsum nec velit hendrerit egestas vel at ex. Phasellus at suscipit quam. Suspendisse pulvinar ante a nulla porttitor, quis maximus augue fermentum. Maecenas sit amet purus posuere, ultrices mi a, cursus justo. Maecenas tempor metus odio, ac condimentum eros luctus ac. Pellentesque scelerisque massa magna, ac sagittis elit placerat et. Nulla vehicula tortor sit amet nulla semper, in porttitor purus maximus. Nam leo est, dignissim eget feugiat id, hendrerit sit amet felis. Nulla ornare volutpat enim at venenatis. Nulla pellentesque finibus varius. Ut rhoncus vitae lorem et tempus. Donec accumsan dignissim commodo. Maecenas pellentesque ac metus quis faucibus. Duis id mi convallis magna venenatis varius.",
                "123",
                123f,
                123f,
                123f,
                123f,
                720,
                1
            )
        )
    }
}