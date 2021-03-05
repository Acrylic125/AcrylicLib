package paginatedcollection

import java.util.*

class PaginatedArrayList<T>(override var maxElementsPerPage: Int) : ArrayList<T>(), PaginatedList<T>