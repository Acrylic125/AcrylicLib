package files.editor

import com.fasterxml.jackson.databind.ObjectMapper
import math.isWholeNumber
import java.io.File
import java.io.IOException
import java.lang.Math.round
import kotlin.math.roundToInt

class DefaultFileEditor : FileEditor {

    override val contents: HashMap<String, Any>?
    override val parent: FileEditor?

    constructor(file: File?, objectMapper: ObjectMapper) {
        parent = null
        contents = try {
            objectMapper.readValue(file, HashMap::class.java) as HashMap<String, Any>?
        } catch (ex: IOException) {
            HashMap()
        }
    }

    private constructor(contents: HashMap<String, Any>, parent: FileEditor?) {
        this.parent = parent
        this.contents = contents
    }

    constructor() : this(HashMap(),null)

    override fun getObject(`var`: String): Any? {
        return contents!![`var`]
    }

    override fun set(`var`: String, `val`: Any): FileEditor {
        contents!![`var`] = `val`
        return this
    }

    override fun getBoolean(`var`: String): Boolean {
        val o = getObject(`var`)
        return if (o is Boolean) o else false
    }

    override fun getDecimalNumber(`var`: String): Number {
        return getNumber(`var`)
    }

    override fun getWholeNumber(`var`: String): Number {
        val o = getNumber(`var`)
        return if (isWholeNumber(o)) o else (o as Double).roundToInt()
    }

    override fun getNumber(`var`: String): Number {
        val o = getObject(`var`)
        return if (o !is Number) 0 else o
    }

    override fun getFileEditor(`var`: String): FileEditor {
        val o = getObject(`var`)
        if (o is HashMap<*,*>) {
            val map: HashMap<String,Any> = HashMap()
            o.forEach{ (key, value) ->
                if (key is String) {
                    map[key] = value
                }
            }
            return DefaultFileEditor(map,this)
        }
        return DefaultFileEditor(HashMap(),this)
    }

    override fun getByte(`var`: String): Byte {
        val o = getObject(`var`)
        return if (o !is Byte) 0 else o
    }

    override fun getShort(`var`: String): Short {
        val o = getObject(`var`)
        return if (o !is Short) 0 else o
    }

    override fun getInt(`var`: String): Int {
        val o = getObject(`var`)
        return if (o !is Int) 0 else o
    }

    override fun getLong(`var`: String): Long {
        val o = getObject(`var`)
        return if (o !is Long) 0 else o
    }

    override fun getFloat(`var`: String): Float {
        val o = getObject(`var`)
        return if (o !is Float) 0f else o
    }

    override fun getDouble(`var`: String): Double {
        val o = getObject(`var`)
        return if (o !is Double) 0.0 else o
    }

    override fun getChar(`var`: String): Char {
        val o = getObject(`var`)
        return if (o !is Char) 'a' else o
    }

    override fun getString(`var`: String): String? {
        val o = getObject(`var`)
        return (o as? String)?.toString()
    }

    override fun getList(`var`: String): List<*> {
        val o = getObject(`var`)
        return if (o !is List<*>) ArrayList<Any?>() else (o as List<*>?)!!
    }

    override fun <T> getList(`var`: String, type: Class<T>): List<T> {
        val o = getObject(`var`) as? List<*> ?: return ArrayList()
        val list: MutableList<T> = ArrayList()
        for (o1 in o) if (type.isInstance(o1)) {
            list.add(o as T)
        }
        return list
    }

    override fun toString(): String {
        return "FileEditor{" +
                "parent=" + parent +
                ", contents=" + contents +
                '}'
    }


}