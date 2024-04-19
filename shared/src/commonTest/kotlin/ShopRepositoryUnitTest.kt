import ru.mezhendosina.shared.model.shop.repo.ShopRepositoryImpl
import kotlin.test.Test

class ShopRepositoryUnitTest {

    val shopSource = RequestsUnitTest.ktor

    val shopRepository = ShopRepositoryImpl(
        RequestsUnitTest.shopSource
    )

    @Test
    fun testGetItems(){}


}