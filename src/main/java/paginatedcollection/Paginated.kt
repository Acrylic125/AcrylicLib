package paginatedcollection

import java.util.ArrayList
import java.util.function.Consumer
import kotlin.math.ceil

interface Paginated<T> {

    val maxElementsPerPage: Int

    fun iterate(page: Int, action: Consumer<T>)

    fun getCollection() : Collection<T>

    fun setCollection(collection: Collection<T>)

    fun getPageList(page: Int): ArrayList<T>? {
        val list = ArrayList<T>()
        iterate(page) { e: T -> list.add(e) }
        return list
    }

    fun getPage(page: Int): Int {
        return if (page < 0) 1 else page.coerceAtMost(maxPage)
    }

    val maxPage: Int
        get() = ceil(getCollection().size.toFloat() / maxElementsPerPage.toDouble()).toInt()

    fun getElementsFrom(page: Int): Int {
        return (getPage(page) - 1) * maxElementsPerPage
    }

    fun getElementsTo(page: Int): Int {
        return (getPage(page) * maxElementsPerPage).coerceAtMost(getCollection().size)
    }

}