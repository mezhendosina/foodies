package ru.mezhendosina.shared.model.cart

import ru.mezhendosina.shared.ui.entities.ItemEntity


interface CartRepository {
    /**
     * Изменяет количество элементов в корзине.
     * @param item - элемент, который надо изменить, добавить в корзину или убрать из нее. Необходимо передавать с уже измененным количеством
     */
    suspend fun updateCount(item: ItemEntity)

    fun getSum(): Int
}
