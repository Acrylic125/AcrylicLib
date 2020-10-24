package com.acrylic.commands

import com.acrylic.commands.senders.CommandSender
import com.acrylic.paginatedcollection.PaginatedHashSet
import com.acrylic.threads.RunningLoop
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * The CommandMap manages all command inputs.
 */
open class CommandSet : RunningLoop {

    override var isRunning: Boolean = false

    private val commandSet: PaginatedHashSet<Command> = PaginatedHashSet(10)
    /** Set this to false if you want to end the reader. **/
    private val reader = BufferedReader(InputStreamReader(System.`in`))

    private fun register(command: Command) {
        commandSet.add(command)
        command.commandRegister()
    }

    fun register(vararg commands: Command) {
        commands.forEach { register(it) }
    }

    fun checkCommand(executor: CommandSender, inputCommand: InputCommand, ) {
        commandSet.forEach {
            if (it.isThisCommand(inputCommand)) {
                it.runCommand(executor, inputCommand.getCommand(), true, *inputCommand.getArguments())
                return
            }
        }
    }

    fun getRegisteredCommands() : PaginatedHashSet<Command> {
        return commandSet
    }

    /**
     * Handles the command inputs into console.
     * This method starts the reader.
     */
    override fun run() {
        val cmd = reader.readLine()
        if (cmd != null) {
            checkCommand(AcrylicLib.console, getInputCommand(cmd))
        }
    }

}