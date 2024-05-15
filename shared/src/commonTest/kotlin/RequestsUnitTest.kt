import android.util.Log
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.koin.java.KoinJavaComponent.inject
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import ru.mezhendosina.shared.model.ktorfitModule
import ru.mezhendosina.shared.model.shop.KtorfitShopSource
import ru.mezhendosina.shared.model.shop.ShopSource
import ru.mezhendosina.shared.model.sourcesModule
import kotlin.test.Test

class RequestsUnitTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(sourcesModule)
        modules(ktorfitModule)
    }

    val shopSource by inject<ShopSource>(ShopSource::class.java)

    @Test
    fun getProductsTest() {
        runBlocking {
            val products = shopSource.getProducts()
            println(products)
            assert(products.isNotEmpty())
        }
    }

    @Test
    fun getCategoriesTest() {
        runBlocking {
            val categories = shopSource.getCategories()
            println(categories)
            assert(categories.isNotEmpty())
        }
    }

    @Test
    fun getTags() {
        runBlocking {
            val tags = shopSource.getTags()
            println(tags)
            assert(tags.isNotEmpty())
        }
    }
}