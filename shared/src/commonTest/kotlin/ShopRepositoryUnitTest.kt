import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.koin.java.KoinJavaComponent.inject
import org.koin.test.KoinTestRule
import ru.mezhendosina.shared.model.ktorfitModule
import ru.mezhendosina.shared.model.repoModule
import ru.mezhendosina.shared.model.shop.repo.ShopRepository
import ru.mezhendosina.shared.model.sourcesModule
import kotlin.test.Test

class ShopRepositoryUnitTest {
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(sourcesModule)
        modules(ktorfitModule)
        modules(repoModule)
    }

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val shopRepository: ShopRepository by inject(ShopRepository::class.java)

    @Test
    fun testGetItems() {
        runBlocking {
            shopRepository.getItems()
            assert(shopRepository.items.value.isNotEmpty())
        }
    }

    @Test
    fun testUpdateCount() {
        runBlocking {
            shopRepository.getItems()

        }
    }

}