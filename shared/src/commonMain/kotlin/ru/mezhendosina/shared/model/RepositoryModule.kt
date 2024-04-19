package ru.mezhendosina.shared.model

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module
import ru.mezhendosina.shared.model.cart.CartRepository
import ru.mezhendosina.shared.model.cart.CartRepositoryImpl
import ru.mezhendosina.shared.model.shop.KtorfitShopSource
import ru.mezhendosina.shared.model.shop.ShopSource
import ru.mezhendosina.shared.model.shop.repo.ShopRepository
import ru.mezhendosina.shared.model.shop.repo.ShopRepositoryImpl
import ru.mezhendosina.shared.model.shop.repo.ShopRepositoryPreview

val ktorfitModule = module {
    single<Ktorfit> {

        val ktorClient = HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }

        Ktorfit.Builder()
            .baseUrl("https://anika1d.github.io/")
            .httpClient(ktorClient)
            .build()

    }
}

val sourcesModule = module {
    single<ShopSource> { KtorfitShopSource(get()) }
}

val repoModule = module {
    includes(sourcesModule)
    single<CartRepository> { CartRepositoryImpl() }
    single<ShopRepository> { ShopRepositoryImpl(get()) }
}
