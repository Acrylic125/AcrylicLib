package math.vectors

import kotlin.math.acos

abstract class AbstractVector2D<T : AbstractVector2D<T, N>, N : Number>(var x: N, var y: N)
    : Vector<T, N> {

    abstract fun add(x: N, y: N) : T

    abstract fun subtract(x: N, y: N) : T

    abstract fun multiply(x: N, y: N) : T

    abstract fun divide(x: N, y: N) : T

    override fun add(vector: T): T {
        return add(vector.x, vector.y)
    }

    override fun subtract(vector: T): T {
        return subtract(vector.x, vector.y)
    }

    override fun addEach(value: N): T {
        return add(value, value)
    }

    override fun subtractEach(value: N): T {
        return subtract(value, value)
    }

    override fun multiplyEach(value: N): T {
        return multiply(value, value)
    }

    override fun divideEach(value: N): T {
        return divide(value, value)
    }

    override fun getAngleBetween(vector: T): Double {
        return acos(getDotProduct(vector) / (vector.getMagnitude() * getMagnitude())) * 180
    }

    fun toVectorInt() : VectorInt2D {
        return VectorInt2D(x.toInt(), y.toInt())
    }

    fun toVectorLong() : VectorLong2D {
        return VectorLong2D(x.toLong(), y.toLong())
    }

    fun toVectorFloat() : VectorFloat2D {
        return VectorFloat2D(x.toFloat(), y.toFloat())
    }

    fun toVectorDouble() : VectorDouble2D {
        return VectorDouble2D(x.toDouble(), y.toDouble())
    }

    override fun toString(): String {
        return "Vector2D(x=$x, y=$y)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AbstractVector2D<*, *>) return false

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }


}