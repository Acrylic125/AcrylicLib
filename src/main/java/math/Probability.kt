package com.acrylic.math

import kotlin.math.abs
import kotlin.math.min
import kotlin.math.round
import kotlin.random.Random

private fun getRandom() : Float {
    return Random.nextFloat()
}

fun chance(chance : Float) : Boolean {
    return getRandom() <= (chance / 100)
}

fun getRandom(a : Int, b : Int) : Int {
    val r = abs(a - b) * getRandom()
    return round(min(a,b) + r).toInt()
}

fun getRandom(a : Long, b : Long) : Long {
    val r = abs(a - b) * getRandom()
    return round(min(a,b) + r).toLong()
}

fun getRandom(a : Float, b : Float) : Float {
    val r = abs(a - b) * getRandom()
    return min(a,b) + r
}

fun getRandom(a : Double, b : Double) : Double {
    val r = abs(a - b) * getRandom()
    return min(a,b) + r
}

fun getPositiveOrNegative(a: Int) : Int {
    return getPositiveOrNegative() * a
}

fun getPositiveOrNegative(a: Long) : Long {
    return getPositiveOrNegative() * a
}

fun getPositiveOrNegative(a: Float) : Float {
    return getPositiveOrNegative() * a
}

fun getPositiveOrNegative(a: Double) : Double {
    return getPositiveOrNegative() * a
}

fun getPositiveOrNegative() : Byte {
    return if (chance(50f)) -1 else 1
}

fun getPositiveNegativeRandom(a : Int, b : Int) : Int {
    return getPositiveOrNegative(getRandom(abs(a), abs(b)))
}

fun getPositiveNegativeRandom(a : Long, b : Long) : Long {
    return getPositiveOrNegative(getRandom(abs(a), abs(b)))
}

fun getPositiveNegativeRandom(a : Float, b : Float) : Float {
    return getPositiveOrNegative(getRandom(abs(a), abs(b)))
}

fun getPositiveNegativeRandom(a : Double, b : Double) : Double {
    return getPositiveOrNegative(getRandom(abs(a), abs(b)))
}