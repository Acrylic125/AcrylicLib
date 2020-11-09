package math.vectors

import kotlin.math.sqrt

interface Vector<T : Vector<T, N>, N : Number> : Cloneable {

    fun add(vector: T) : T

    fun subtract(vector: T) : T

    fun addEach(value: N) : T

    fun subtractEach(value: N) : T

    fun multiplyEach(value: N) : T

    fun divideEach(value: N) : T

    fun getMagnitudeSquared() : Double

    fun getMagnitude() : Double {
        return sqrt(getMagnitudeSquared())
    }

    fun getDotProduct(vector: T) : Double

    fun getAngleBetween(vector: T) : Double

    fun toArray() : Array<N>

}