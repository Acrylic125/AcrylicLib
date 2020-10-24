package com.acrylic.time

enum class Time(val nanoScale: Long) {
    DAYS(86400000000000L), HOURS(3600000000000L), MINUTES(60000000000L), SECONDS(1000000000L), MILLISECONDS(1000000L), MICROSECONDS(1000L), NANOSECONDS(1L);

    fun toNano(value: Long): Long {
        return value * nanoScale
    }
}