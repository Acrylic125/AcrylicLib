package com.acrylic.commands

import com.acrylic.commands.senders.CommandSender

class ExecutedCommand(private val executor: CommandSender, private vararg val args: String) : AbstractExecutedCommand {

    override fun getExecutor(): CommandSender {
        return executor
    }

    override fun getArguments(): Array<out String> {
        return args
    }
}