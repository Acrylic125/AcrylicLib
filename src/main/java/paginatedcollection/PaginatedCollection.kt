package paginatedcollection

interface PaginatedCollection<T> : MutableCollection<T>, Paginated<T> {

    override fun getCollection(): Collection<T> {
        return this
    }

    override fun setCollection(collection: Collection<T>) {
        clear()
        addAll(collection)
    }

}