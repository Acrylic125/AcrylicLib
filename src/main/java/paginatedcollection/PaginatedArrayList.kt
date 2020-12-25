package com.acrylic.paginatedcollection

import paginatedcollection.PaginatedList
import java.util.*

class PaginatedArrayList<T>(override val maxElementsPerPage: Int) : ArrayList<T>(), PaginatedList<T>