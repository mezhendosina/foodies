package ru.mezhendosina.foodies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import ru.mezhendosina.foodies.ui.root.RootScreen
import ru.mezhendosina.foodies.ui.theme.NtiTeamTestTheme
import ru.mezhendosina.shared.ui.root.DefaultRootComponent

class MainActivity : ComponentActivity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootComponent = DefaultRootComponent(defaultComponentContext(), get(), get())
        enableEdgeToEdge()
        setContent {
            NtiTeamTestTheme {
                RootScreen(rootComponent)
            }
        }
    }
}