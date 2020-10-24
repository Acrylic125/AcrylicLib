package com.acrylic.commands

import com.acrylic.commands.senders.CommandSender
import com.acrylic.text.TextBuilder
import com.acrylic.text.TextFormat
import com.acrylic.time.TimeConverter

interface CommandExecution : CommandTemplate {

    /**
     * If the user cannot use this command, this
     * method will be ran.
     */
    fun disallowedToUseAction(command: AbstractExecutedCommand)

    fun action(command: AbstractExecutedCommand) : Boolean

    /**
     * This is a fallback command in the event that
     * the action() returns false.
     */
    fun failedCommandAction(command: AbstractExecutedCommand) {
        command.getExecutor().sendMessage(TextBuilder().append(usage, TextFormat.ORANGE).toString())
    }

    private fun decomposeCommand(ran: String, command: AbstractExecutedCommand) : String {
        val stringBuilder = StringBuilder("${command.getExecutor().getName()} [${getCommand()}] $ran")
        command.getArguments().forEach { stringBuilder.append(" $it") }
        return stringBuilder.toString()
    }

    fun runCommand(executor: CommandSender, ran: String, shouldLog: Boolean, vararg arguments: String) {
        val command = ExecutedCommand(executor,*arguments)
        if (shouldLog) println("Command: ${decomposeCommand(ran, command)} was ran.")
        val time = System.nanoTime()
        try {
            if (!isAllowedToUseThisCommand(command)) {
                disallowedToUseAction(command)
            } else {
                if (!(queryAndActivateArgument(command)
                        || action(command))) failedCommandAction(command)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        println("Took ${TimeConverter.GLOBAL.convert(System.nanoTime() - time)}")
    }

    private fun queryAndActivateArgument(command: AbstractExecutedCommand) : Boolean {
        val arguments = command.getArguments()
        val argument = queryNextArgument(*arguments)
        if (argument != null) {
            val max = arguments.size - 1
            val newSetOfArgs : Array<String> = Array(max){""}
            if (max > 0) {
                for (i in 0 until max) {
                    newSetOfArgs[i] = arguments[i + 1]
                }
            }
            argument.runCommand(command.getExecutor(), arguments[0], false, *newSetOfArgs)
            return true
        }
        return false
    }

    private fun queryNextArgument(vararg arguments: String) : Command? {
        if (arguments.isEmpty()) return null
        val arg = getInputCommand(arguments[0])
        for (argument in this.arguments) {
            if (argument.isThisCommand(arg)) return argument
        }
        return null
    }

}