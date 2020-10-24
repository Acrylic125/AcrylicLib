package com.acrylic.text

abstract class TextTemplate {

    private var valueTextFormat : Array<out TextFormat> = emptyArray()
    private var suffixFormat : Array<out TextFormat> = emptyArray()

    fun setValueFormat(vararg textFormat: TextFormat) : TextTemplate {
        valueTextFormat = textFormat
        return this
    }

    fun setSuffixFormat(vararg textFormat: TextFormat) : TextTemplate {
        suffixFormat = textFormat
        return this
    }

    fun getValueTextFormats() : Array<out TextFormat> {
        return valueTextFormat
    }

    fun getSuffixTextFormats() : Array<out TextFormat> {
        return suffixFormat
    }

}
