package com.acrylic.time

import com.acrylic.text.TextBuilder

class TimeString(private val timeConverter: TimeConverter, ref: Long, referenceUnit: Time) {
    private val ref: Long = referenceUnit.toNano(ref)

    /** Modifiable  */
    private var startingTimeUnitOrdinal: Int
    private var endingTimeUnitOrdinal: Int
    private var shouldIncludeZeroTime = false
    private var zero: String

    /** Temporary  */
    private var current: Long = 0
    private var hasPassedInitial = false
    fun setShouldIncludeZeroTime(shouldIncludeZeroTime: Boolean): TimeString {
        this.shouldIncludeZeroTime = shouldIncludeZeroTime
        return this
    }

    fun setStartingTimeUnit(startingTimeUnit: Time): TimeString {
        startingTimeUnitOrdinal = startingTimeUnit.ordinal
        return this
    }

    fun setEndingTimeUnit(endingTimeUnit: Time): TimeString {
        endingTimeUnitOrdinal = endingTimeUnit.ordinal
        return this
    }

    fun setZero(zero: String): TimeString {
        this.zero = zero
        return this
    }

    private fun getSuffix(timeUnit: Time): String {
        return when (timeUnit) {
            Time.DAYS -> timeConverter.daysSuffix
            Time.HOURS -> timeConverter.hoursSuffix
            Time.MINUTES -> timeConverter.minsSuffix
            Time.SECONDS -> timeConverter.secondsSuffix
            Time.MILLISECONDS -> timeConverter.millisecondsSuffix
            Time.MICROSECONDS -> timeConverter.microsecondsSuffix
            Time.NANOSECONDS -> timeConverter.nanoSecondsSuffix
        }
        return ""
    }

    private fun appendHelper(textBuilder: TextBuilder, timeUnit: Time): Boolean {
        val ordinal = timeUnit.ordinal
        if (ordinal >= startingTimeUnitOrdinal) {
            val scale = timeUnit.nanoScale
            val count = Math.floor(current / scale.toDouble()).toLong()
            current -= count * scale
            if (shouldIncludeZeroTime || count > 0) {
                textBuilder.appendThenClear(if (hasPassedInitial) timeConverter.spacing else "")
                        .appendThenClear(count, *timeConverter.getValueTextFormats())
                        .appendThenClear(getSuffix(timeUnit), *timeConverter.getSuffixTextFormats())
                if (!hasPassedInitial) hasPassedInitial = true
            }
        }
        return ordinal >= endingTimeUnitOrdinal
    }

    override fun toString(): String {
        if (ref == 0L) return TextBuilder().appendThenClear(zero, *timeConverter.getValueTextFormats()).toString()
        val textBuilder = TextBuilder()
        current = ref
        for (unit in units) {
            if (appendHelper(textBuilder, unit)) break
        }
        return textBuilder.toString()
    }

    companion object {
        private val units = Time.values()
    }

    init {
        startingTimeUnitOrdinal = timeConverter.startingTimeUnitOrdinal
        endingTimeUnitOrdinal = timeConverter.endingTimeUnitOrdinal
        zero = timeConverter.zero
    }
}