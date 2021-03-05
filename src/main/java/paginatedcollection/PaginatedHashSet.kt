package paginatedcollection

import java.util.*

class PaginatedHashSet<T>(override var maxElementsPerPage: Int) : HashSet<T>(), PaginatedSet<T>