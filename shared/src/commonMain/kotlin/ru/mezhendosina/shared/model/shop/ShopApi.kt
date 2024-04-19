package ru.mezhendosina.shared.model.shop

import de.jensklingenberg.ktorfit.http.GET
import ru.mezhendosina.shared.model.entities.CategoriesResponseEntity
import ru.mezhendosina.shared.model.entities.ProductRepsponseEntity
import ru.mezhendosina.shared.model.entities.TagsResponseEntity

interface ShopApi {

    @GET("WorkTestServer/Categories.json")
    suspend fun getCategories(): List<CategoriesResponseEntity>

    @GET("WorkTestServer/Tags.json")
    suspend fun getTags(): List<TagsResponseEntity>

    @GET("WorkTestServer/Products.json")
    suspend fun getProducts(): List<ProductRepsponseEntity>

}