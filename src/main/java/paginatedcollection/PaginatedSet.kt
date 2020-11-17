package com.acrylic.paginatedcollection

import paginatedcollection.PaginatedCollection
import java.util.function.Consumer

interface PaginatedSet<T> : MutableSet<T>, PaginatedCollection<T> {

    override fun iterate(page: Int, action: Consumer<T>) {
        val collection = toList()
        val starting = getElementsFrom(page)
        val ending = getElementsTo(page)
        for (i in starting until ending) {
            action.accept(collection[i])
        }
    }
}