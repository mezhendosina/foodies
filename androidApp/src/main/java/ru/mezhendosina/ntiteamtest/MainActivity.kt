package ru.mezhendosina.ntiteamtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import ru.mezhendosina.ntiteamtest.ui.root.RootScreen
import ru.mezhendosina.ntiteamtest.ui.theme.NtiTeamTestTheme
import ru.mezhendosina.shared.model.repoModule
import ru.mezhendosina.shared.ui.root.DefaultRootComponent

class MainActivity : ComponentActivity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootComponent = DefaultRootComponent(defaultComponentContext(), get(), get())
        setContent {
            NtiTeamTestTheme {
                RootScreen(rootComponent)
            }
        }
    }
}