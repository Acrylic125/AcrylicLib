package com.acrylic.commands.defaultcommands

import com.acrylic.commands.AbstractCommand
import com.acrylic.commands.AbstractExecutedCommand
import com.acrylic.text.TextBuilder
import com.acrylic.text.TextFormat

class RegisteredCommandsCommand : AbstractCommand("/registeredcommands") {

    override var description: String = "Shows this list."
    override var usage: String = "/registeredcommands <page>"

    init {
        addAlias("/registeredcommand","/rcmds","/regcmds")
    }

    override fun isAllowedToUseThisCommand(command: AbstractExecutedCommand): Boolean {
        return command.getExecutor().hasPermission("command.registeredcommand")
    }

    override fun disallowedToUseAction(command: AbstractExecutedCommand) {
        command.getExecutor().sendMessage("You may not use this command!")
    }

    override fun action(command: AbstractExecutedCommand): Boolean {
        var page = 1
        val argument = command.getArgument(0)
        if (argument != null) {
            try {
                page = Integer.parseInt(argument)
            } catch (ex: NumberFormatException) {
            }
        }
        val set = AcrylicLib.commandMap.getRegisteredCommands()
        val textBuilder = TextBuilder().appendThenClear("Commands : [ ${set.getPage(page)} / ${set.maxPage} ]", TextFormat.LIGHT_BLUE, TextFormat.BOLD).nextLine()
        set.iterate(page) {
             textBuilder.appendThenClear(it.usage, TextFormat.LIGHT_BLUE)
                    .appendThenClear(" ${it.description}", TextFormat.LIGHT_GRAY)
                    .nextLine()
        }
        command.getExecutor().sendMessage(textBuilder.toString())
        return true
    }

}