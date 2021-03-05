package paginatedcollection

import java.util.function.Consumer

interface PaginatedList<T> : MutableList<T>, PaginatedCollection<T> {

    override fun iterate(page: Int, action: Consumer<T>) {
        if (isEmpty())
            return
        iterateList(page, this, action)
    }

}