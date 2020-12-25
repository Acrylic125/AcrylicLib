package paginatedcollection

import java.util.*

class PaginatedLinkedList<T>(override val maxElementsPerPage: Int) : LinkedList<T>(), PaginatedList<T>