package weights

import com.acrylic.weights.AbstractWeigher
import com.acrylic.weights.WeightObject
import java.util.*

class Weigher<T : WeightObject?> : AbstractWeigher<T> {
    private val list = ArrayList<T>()
    private var weights = 0.0

    constructor() {}
    constructor(list: List<T>) {
        for (t in list) add(t)
    }

    override fun weights(): Double {
        return weights
    }

    override fun list(): ArrayList<T> {
        return list
    }

    override fun add(obj: T): AbstractWeigher<T> {
        if (obj != null) {
            weights += obj.weight
            list.add(obj)
        }
        return this
    }

    override fun remove(obj: T): AbstractWeigher<T> {
        if (obj != null) {
            weights -= obj.weight
            list.add(obj)
        }
        return this
    }

    override fun recalculateWeights() {
        var newWeight = 0.0
        for (t in list) if (t != null) newWeight += t.weight
        weights = newWeight
    }
}