package files.editor

interface Configurable {

    operator fun set(`var`: String, `val`: Any): Configurable
    fun getBoolean(`var`: String): Boolean
    fun getNumber(`var`: String): Number
    fun getWholeNumber(`var`: String): Number
    fun getDecimalNumber(`var`: String): Number
    fun getByte(`var`: String): Byte
    fun getShort(`var`: String): Short
    fun getInt(`var`: String): Int
    fun getLong(`var`: String): Long
    fun getFloat(`var`: String): Float
    fun getDouble(`var`: String): Double
    fun getChar(`var`: String): Char
    fun getString(`var`: String): String?
    fun getObject(`var`: String): Any?
    fun getList(`var`: String): List<*>?
    fun <T> getList(`var`: String, type: Class<T>): List<T>

}