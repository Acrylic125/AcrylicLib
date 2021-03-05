package paginatedcollection

import java.util.*

class PaginatedLinkedList<T>(override var maxElementsPerPage: Int) : LinkedList<T>(), PaginatedList<T>