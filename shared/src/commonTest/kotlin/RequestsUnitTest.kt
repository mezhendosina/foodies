import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import ru.mezhendosina.shared.model.shop.KtorfitShopSource
import kotlin.test.Test

class RequestsUnitTest {

    companion object {

        private val ktorClient = HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }


        val ktor = Ktorfit.Builder()
            .baseUrl("https://anika1d.github.io/")
            .httpClient(ktorClient)
            .build()

        val shopSource = KtorfitShopSource(ktor)

    }

    @Test
    fun getProductsTest() {
        runBlocking {
            val products = shopSource.getProducts()
            assert(products.isNotEmpty())
        }
    }

    @Test
    fun getCategoriesTest() {
        runBlocking {
            val categories = shopSource.getCategories()
            assert(categories.isNotEmpty())
        }
    }

    @Test
    fun getTags() {
        runBlocking {
            val tags = shopSource.getTags()
            assert(tags.isNotEmpty())
        }
    }
}