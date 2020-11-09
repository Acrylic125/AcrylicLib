package math.vectors

class VectorFloat2D(x: Float, y: Float)
    : AbstractVector2D<VectorFloat2D, Float>(x, y) {

    override fun add(x: Float, y: Float): VectorFloat2D {
        this.x += x
        this.y += y
        return this
    }

    override fun subtract(x: Float, y: Float): VectorFloat2D {
        return add(-x, -y)
    }

    override fun multiply(x: Float, y: Float): VectorFloat2D {
        this.x *= x
        this.y *= y
        return this
    }

    override fun divide(x: Float, y: Float): VectorFloat2D {
        return multiply(1 / x, 1/ y)
    }

    override fun getMagnitudeSquared(): Double {
        return (x*x + y*y).toDouble()
    }

    override fun getDotProduct(vector: VectorFloat2D): Double {
        return (x * vector.x) + (y * vector.y).toDouble()
    }

    override fun toArray(): Array<Float> {
        return arrayOf(x,y)
    }

    override fun clone(): VectorFloat2D {
        return VectorFloat2D(x, y)
    }

}