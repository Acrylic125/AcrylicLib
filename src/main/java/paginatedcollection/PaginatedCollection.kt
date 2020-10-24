package com.acrylic.paginatedcollection

import java.util.*
import java.util.function.Consumer

interface PaginatedCollection<T> : MutableCollection<T> {

    val maxElementsPerPage: Int
    fun iterate(page: Int, action: Consumer<T>)
    fun getPageList(page: Int): ArrayList<T>? {
        val list = ArrayList<T>()
        iterate(page) { e: T -> list.add(e) }
        return list
    }

    fun getPage(page: Int): Int {
        return if (page < 0) 1 else Math.min(page, maxPage)
    }

    val maxPage: Int
        get() = Math.ceil(size.toFloat() / maxElementsPerPage.toDouble()).toInt()

    fun getElementsFrom(page: Int): Int {
        return (getPage(page) - 1) * maxElementsPerPage
    }

    fun getElementsTo(page: Int): Int {
        return Math.min(getPage(page) * maxElementsPerPage, size)
    }
}