package com.acrylic.text

open class TextBuilder {

    private var concatString : String = ""

    fun append(text : String) : TextBuilder {
        concatString = concatString.plus(text)
        return this
    }

    fun append(text : Any, vararg color : TextFormat) : TextBuilder {
        var colorFormats = ""
        color.forEach {
            colorFormats += "${it.getFormat()}"
        }
        return append("$colorFormats$text")
    }

    fun appendThenClear(text : Any) : TextBuilder {
        return append(text).clear()
    }

    fun appendThenClear(text : Any, vararg color : TextFormat) : TextBuilder {
        return append(text, *color).clear()
    }

    fun clear() : TextBuilder {
        concatString += "${TextFormat.RESET.getFormat()}"
        return this
    }

    fun nextLine() : TextBuilder {
        concatString += "\n"
        return this
    }

    override fun toString() : String {
        clear()
        return concatString
    }

}