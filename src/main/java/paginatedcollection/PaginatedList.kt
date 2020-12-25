package paginatedcollection

import java.util.function.Consumer

interface PaginatedList<T> : MutableList<T>, PaginatedCollection<T> {

    override fun iterate(page: Int, action: Consumer<T>) {
        val starting = getElementsFrom(page)
        val ending = getElementsTo(page)
        for (i in starting until ending) {
            action.accept(get(i))
        }
    }

}