package com.acrylic.text

fun send(string : String) {
    println(string)
}

fun send(vararg strings : String) {
    strings.forEach { send(it) }
}

fun send(vararg texts : TextBuilder) {
    texts.forEach { send(it.toString()) }
}

fun createTextBuilder() : TextBuilder {
    return TextBuilder()
}