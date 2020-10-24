package com.acrylic.weights

import com.acrylic.math.chance
import com.acrylic.math.getRandom
import java.util.*

interface AbstractWeigher<T : WeightObject?> {
    fun weights(): Double
    fun list(): ArrayList<T>
    fun add(obj: T): AbstractWeigher<T>
    fun remove(obj: T): AbstractWeigher<T>

    /** This method will not be supported.  */
    @Deprecated("")
    fun recalculateWeights()

    /**
     * @param obj The object.
     * @return The probability of retrieving obj
     * relative to this weighter.
     */
    fun <E : WeightObject?> getProbability(obj: E): Float {
        return if (obj != null) {
            (obj.weight / weights()).toFloat()
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
        val result = getRandom(0.0, weights())
        var current = 0.0
        for (t in list()) if (t != null) {
            if (t.weight  > 0) {
                current += t.weight
                if (result < current) {
                    return t
                }
            }
        }
        return null
    }
}