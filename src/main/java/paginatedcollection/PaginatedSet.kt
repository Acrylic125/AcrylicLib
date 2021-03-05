package paginatedcollection

import java.util.function.Consumer

interface PaginatedSet<T> : MutableSet<T>, PaginatedCollection<T> {

    override fun iterate(page: Int, action: Consumer<T>) {
        if (isEmpty())
            return
        iterateList(page, toList(), action)
    }
}