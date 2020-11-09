package math.vectors

interface Vector<T : Vector<T, N>, N : Number> {

    fun add(vector: T) : T

    fun subtract(vector: T) : T

    fun addEach(value: N) : T

    fun subtractEach(value: N) : T

    fun multiplyEach(value: N) : T

    fun divideEach(value: N) : T

    fun getMagnitude() : Double

    fun getDotProduct() : Double

    fun getAngleBetween(vector: T) : Double

}