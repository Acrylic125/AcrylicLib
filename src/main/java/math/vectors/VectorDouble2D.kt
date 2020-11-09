package math.vectors

class VectorDouble2D(x: Double, y: Double)
    : AbstractVector2D<VectorDouble2D, Double>(x, y) {

    override fun add(x: Double, y: Double): VectorDouble2D {
        this.x += x
        this.y += y
        return this
    }

    override fun subtract(x: Double, y: Double): VectorDouble2D {
        return add(-x, -y)
    }

    override fun multiply(x: Double, y: Double): VectorDouble2D {
        this.x *= x
        this.y *= y
        return this
    }

    override fun divide(x: Double, y: Double): VectorDouble2D {
        return multiply(1 / x, 1/ y)
    }

    override fun getMagnitudeSquared(): Double {
        return (x*x + y*y)
    }

    override fun getDotProduct(vector: VectorDouble2D): Double {
        return (x * vector.x) + (y * vector.y).toDouble()
    }

    override fun toArray(): Array<Double> {
        return arrayOf(x,y)
    }

    override fun clone(): VectorDouble2D {
        return VectorDouble2D(x, y)
    }

}