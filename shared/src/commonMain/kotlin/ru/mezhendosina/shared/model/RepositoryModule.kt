package ru.mezhendosina.shared.model

import org.koin.dsl.module
import ru.mezhendosina.shared.model.cart.CartRepository
import ru.mezhendosina.shared.model.cart.CartRepositoryImpl
import ru.mezhendosina.shared.model.shop.repo.ShopRepository
import ru.mezhendosina.shared.model.shop.repo.ShopRepositoryImpl
import ru.mezhendosina.shared.model.shop.repo.ShopRepositoryPreview

val repoModule = module {
    single<CartRepository> { CartRepositoryImpl() }
    single<ShopRepository> { ShopRepositoryPreview() }
}