package math.vectors

class VectorInt2D(x: Int, y: Int)
    : AbstractVector2D<VectorInt2D, Int>(x, y) {

    override fun add(x: Int, y: Int): VectorInt2D {
        this.x += x
        this.y += y
        return this
    }

    override fun subtract(x: Int, y: Int): VectorInt2D {
        return add(-x, -y)
    }

    override fun multiply(x: Int, y: Int): VectorInt2D {
        this.x *= x
        this.y *= y
        return this
    }

    override fun divide(x: Int, y: Int): VectorInt2D {
        return multiply(1 / x, 1/ y)
    }

    override fun getMagnitudeSquared(): Double {
        return (x*x + y*y).toDouble()
    }

    override fun getDotProduct(vector: VectorInt2D): Double {
        return (x * vector.x) + (y * vector.y).toDouble()
    }

    override fun toArray(): Array<Int> {
        return arrayOf(x,y)
    }

    override fun clone(): VectorInt2D {
        return VectorInt2D(x, y)
    }

}