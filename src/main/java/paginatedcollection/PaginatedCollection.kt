package paginatedcollection

import java.util.function.Consumer

interface PaginatedCollection<T> : MutableCollection<T>, Paginated<T> {

    override fun getCollection(): Collection<T> {
        return this
    }

    override fun setCollection(collection: Collection<T>) {
        clear()
        addAll(collection)
    }

    fun iterateList(page: Int, list: List<T>, action: Consumer<T>) {
        val starting = getElementsFrom(page)
        val ending = getElementsTo(page)
        var i = starting
        val listIterator = list.listIterator(i)
        while (listIterator.hasNext()) {
            if (i >= ending)
                return
            val next: T = listIterator.next()
            action.accept(next)
            i++
        }
    }
}