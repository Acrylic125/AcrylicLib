package com.acrylic.time

import com.acrylic.text.TextFormat
import com.acrylic.text.TextTemplate

/**
 * The time converter class allows direct conversion
 * of time to a formatted form.
 *
 * This implementation encourages the user to create a single instance
 * of TimeConverter with the configuration you want to use.
 */
class TimeConverter : TextTemplate() {
    companion object {
        @JvmField
        val GLOBAL = TimeConverter()

        init {
            GLOBAL.setSuffixFormat(TextFormat.LIGHT_GRAY, TextFormat.UNDERLINE)
        }
    }

    var spacing = " "
    var daysSuffix = "d"
    var hoursSuffix = "h"
    var minsSuffix = "min"
    var secondsSuffix = "s"
    var millisecondsSuffix = "ms"
    var microsecondsSuffix = "\u03BCs"
    var nanoSecondsSuffix = "ns"
    var startingTimeUnitOrdinal = Time.DAYS.ordinal
    var endingTimeUnitOrdinal = Time.NANOSECONDS.ordinal
    var shouldIncludeZeroTime = false
    var zero = "NOW"

    /**
     * The spacing between each time unit.
     *
     * For example,
     * if you are converting 100 seconds from a lowest degree of
     * Time.MINUTES to a highest degree of Time.SECONDS, and the
     * default settings are used,
     *
     * The result (1min<SPACING>40s):
     * if Spacing = " " -> 1min 40s
     * if Spacing = "" -> 1min40s
    </SPACING> */
    fun setSpacing(spacing: String): TimeConverter {
        this.spacing = spacing
        return this
    }

    /** The suffix settings.  */
    fun setDaysSuffix(daysSuffix: String): TimeConverter {
        this.daysSuffix = daysSuffix
        return this
    }

    fun setHoursSuffix(hoursSuffix: String): TimeConverter {
        this.hoursSuffix = hoursSuffix
        return this
    }

    fun setMinsSuffix(minsSuffix: String): TimeConverter {
        this.minsSuffix = minsSuffix
        return this
    }

    fun setSecondsSuffix(secondsSuffix: String): TimeConverter {
        this.secondsSuffix = secondsSuffix
        return this
    }

    fun setMillisecondsSuffix(millisecondsSuffix: String): TimeConverter {
        this.millisecondsSuffix = millisecondsSuffix
        return this
    }

    fun setMicrosecondsSuffix(microsecondsSuffix: String): TimeConverter {
        this.microsecondsSuffix = microsecondsSuffix
        return this
    }

    fun setNanoSecondsSuffix(nanoSecondsSuffix: String): TimeConverter {
        this.nanoSecondsSuffix = nanoSecondsSuffix
        return this
    }

    /** If the time you want to convert is 0, it is then replaced with this.  */
    fun setZero(zero: String): TimeConverter {
        this.zero = zero
        return this
    }

    /**
     * If this is set to true,
     * The time converted will include 0 time values. For example:
     * 1 Day -> "1d 0min 0s..."
     *
     * If it is set to false,
     * 1 Day -> "1d"
     */
    fun setShouldIncludeZeroTime(shouldIncludeZeroTime: Boolean): TimeConverter {
        this.shouldIncludeZeroTime = shouldIncludeZeroTime
        return this
    }

    /**
     * The starting time unit is the LOWEST degree used in
     * the time conversion.
     *
     * If you want to have a day to second conversion, set
     * this to Time.DAYS.
     */
    fun setStartingTimeUnit(startingTimeUnit: Time): TimeConverter {
        startingTimeUnitOrdinal = startingTimeUnit.ordinal
        return this
    }

    /**
     * The starting time unit is the HIGHEST degree used in
     * the time conversion.
     *
     * If you want to have a day to second conversion, set
     * this to Time.SECONDS.
     */
    fun setEndingTimeUnit(endingTimeUnit: Time): TimeConverter {
        endingTimeUnitOrdinal = endingTimeUnit.ordinal
        return this
    }

    /**
     *
     * @param ref The time you want to convert from.
     * @param refTimeUnit The time unit of ref.
     * @return
     */
    @JvmOverloads
    fun convert(ref: Long, refTimeUnit: Time = Time.NANOSECONDS): TimeString {
        return TimeString(this, ref, refTimeUnit)
    }
}