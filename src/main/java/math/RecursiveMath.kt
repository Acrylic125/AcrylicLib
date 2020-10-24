package com.acrylic.math

import com.acrylic.text.send
import com.google.common.util.concurrent.AtomicDouble
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.BiConsumer

/**
 * This is a simple implementation for recursive math.
 *
 * @param function<n, v>
 *     n = The nth term of the recursion.
 *     v = The current value.
 *
 * This uses the Atomic classes of the JDK and
 * google guava.
 *
 * For example,
 *
 * The summation of f(x) = x^n, where n is the index,
 * and x = 3.
 * This can be represented by the following biconsumer.
 *   {index, value ->
 *      value.set(3.0.pow(index.get())
 *   }
 *
 * IMPORTANT NOTE!
 * This is purely for fun and experimental and should not be
 * used for applications. There will be a better implementation
 * in the future.
 */
@Deprecated("Experimental")
open class RecursiveMath(private val function: BiConsumer<AtomicInteger, AtomicDouble>) {

    private var startingIndex: Int = 1
    private var maxIndex: Int = 1
    private var initialValue: Double = 0.0
    private var printBuilder: StringBuilder? = null

    fun setShouldPrint(shouldPrint: Boolean) : RecursiveMath {
        this.printBuilder = if (shouldPrint) StringBuilder() else null
        return this
    }

    fun setStartingIndex(startingIndex: Int) : RecursiveMath {
        this.startingIndex = startingIndex
        return this
    }

    fun setMaxIndex(maxIndex: Int) : RecursiveMath {
        this.maxIndex = maxIndex
        return this
    }

    fun setInitialValue(initialValue: Double) : RecursiveMath {
        this.initialValue = initialValue
        return this
    }

    fun evaluate() : Double {
        return series(AtomicInteger(startingIndex), maxIndex, AtomicDouble(initialValue))
    }

    private fun series(index: AtomicInteger, maxIndex: Int, value: AtomicDouble) : Double {
        val i = index.get()
        if (i > maxIndex) {
            if (printBuilder != null) send(printBuilder.toString())
            return value.get()
        }
        function.accept(index,value)
        index.addAndGet(1)
        printBuilder?.append("${value.get()} ")
        return series(index, maxIndex, value)
    }
}

@Deprecated("Experimental")
fun factorial(v: Int, shouldPrint: Boolean) : Double? {
    if (v <= 0) return null
    return RecursiveMath { index, value ->
        value.set(value.get() * index.get())
    }.setMaxIndex(v).setInitialValue(1.0).setShouldPrint(shouldPrint).evaluate()
}

