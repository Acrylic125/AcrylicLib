package com.acrylic.paginatedcollection

import java.util.*

class PaginatedHashSet<T>(override val maxElementsPerPage: Int) : HashSet<T>(), PaginatedSet<T>