package com.acrylic.weights

import math.chance
import math.getRandom
import weights.WeightObject

interface AbstractWeigher<T : WeightObject?> {
    fun totalWeights(): Double

    fun list(): List<T>

    fun add(obj: T): AbstractWeigher<T>

    fun remove(obj: T): AbstractWeigher<T>

    /** This method will not be supported.  */
    @Deprecated("")
    fun recalculateWeights()

    fun size(): Int {
        return list().size;
    }

    /**
     * @param obj The object.
     * @return The probability of retrieving obj
     * relative to this weighter.
     */
    fun <E : WeightObject?> getProbability(obj: E): Float {
        return if (obj != null) {
            (obj.weight / totalWeights()).toFloat()
        } else {
            0f
        }
    }

    /**
     *
     * @param obj The object you want to test.
     * @return Whether obj was selected.
     */
    fun test(obj: T): Boolean {
        return list().contains(obj) && chance(getProbability(obj) * 100)
    }

    fun get(): T? {
        val result = getRandom(0.0, totalWeights())
        var current = 0.0
        for (t in list()) if (t != null) {
            if (t.weight > 0) {
                current += t.weight
                if (result < current)
                    return t
            }
        }
        return null
    }
}