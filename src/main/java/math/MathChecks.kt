package math

fun isWholeNumber(number : Number) : Boolean {
    return (number is Byte || number is Short || number is Int || number is Long)
}

fun isDecimalNumber(number : Number) : Boolean {
    return !isWholeNumber(number)
}