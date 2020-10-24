package com.acrylic.commands.defaultcommands

import com.acrylic.commands.AbstractCommand
import com.acrylic.commands.AbstractExecutedCommand
import kotlin.system.exitProcess

class StopCommand : AbstractCommand("/stop") {

    override var description: String = "Ends the entire programme."
    override var usage: String = "/stop"

    init {
        addAlias("/end")
    }

    override fun isAllowedToUseThisCommand(command: AbstractExecutedCommand): Boolean {
        return command.getExecutor().hasPermission("command.stop")
    }

    override fun disallowedToUseAction(command: AbstractExecutedCommand) {
        command.getExecutor().sendMessage("You may not use this command!")
    }

    override fun action(command: AbstractExecutedCommand): Boolean {
        exitProcess(0)
    }

}