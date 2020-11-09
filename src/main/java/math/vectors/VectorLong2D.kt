package math.vectors

class VectorLong2D(x: Long, y: Long)
    : AbstractVector2D<VectorLong2D, Long>(x, y) {

    override fun add(x: Long, y: Long): VectorLong2D {
        this.x += x
        this.y += y
        return this
    }

    override fun subtract(x: Long, y: Long): VectorLong2D {
        return add(-x, -y)
    }

    override fun multiply(x: Long, y: Long): VectorLong2D {
        this.x *= x
        this.y *= y
        return this
    }

    override fun divide(x: Long, y: Long): VectorLong2D {
        return multiply(1 / x, 1/ y)
    }

    override fun getMagnitudeSquared(): Double {
        return (x*x + y*y).toDouble()
    }

    override fun getDotProduct(vector: VectorLong2D): Double {
        return (x * vector.x) + (y * vector.y).toDouble()
    }

    override fun toArray(): Array<Long> {
        return arrayOf(x,y)
    }

    override fun clone(): VectorLong2D {
        return VectorLong2D(x, y)
    }

}