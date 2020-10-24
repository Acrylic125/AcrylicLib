package com.acrylic.commands

import java.util.*

/**
 * This class ensures the input command is usable for
 * comparison.
 */
class InputCommand(var inputCommand: String) {

    private var command: String = ""
    private val arguments: Array<String>

    init {
        inputCommand = inputCommand.toLowerCase(Locale.ENGLISH)
        val strs = inputCommand.split(" ")
        arguments = Array(strs.size - 1){""}
        for ((i, str) in strs.withIndex()) {
            if (i <= 0) {
                command = str
            } else {
                arguments[i-1] = str
            }
        }
    }

    fun getCommand() : String {
        return command
    }

    fun getArguments() : Array<String> {
        return arguments
    }

    override fun toString(): String {
        return "InputCommand(inputCommand='$inputCommand', command='$command', arguments=${arguments.contentToString()})"
    }


}

fun getInputCommand(command: String) : InputCommand {
    return InputCommand(command)
}

