package math

import kotlin.math.max
import kotlin.math.min

fun clamp(v: Double, min: Double, max: Double): Double {
    return min(max, max(v, min))
}

fun clamp(v: Float, min: Float, max: Float): Float {
    return min(max, max(v, min))
}

fun clamp(v: Long, min: Long, max: Long): Long {
    return min(max, max(v, min))
}

fun clamp(v: Int, min: Int, max: Int): Int {
    return min(max, max(v, min))
}
