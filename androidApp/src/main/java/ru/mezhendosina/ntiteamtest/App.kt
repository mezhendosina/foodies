package ru.mezhendosina.ntiteamtest

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.mezhendosina.shared.model.ktorfitModule
import ru.mezhendosina.shared.model.repoModule
import ru.mezhendosina.shared.model.sourcesModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(
                listOf(
                    ktorfitModule,
                    sourcesModule,
                    repoModule,
                )
            )
        }

    }
}