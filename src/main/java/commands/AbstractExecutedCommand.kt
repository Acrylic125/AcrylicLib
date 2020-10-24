package com.acrylic.commands

import com.acrylic.commands.senders.CommandSender

interface AbstractExecutedCommand {

    fun getExecutor() : CommandSender

    fun getArguments() : Array<out String>

    fun getArgument(index: Int) : String? {
        val args = getArguments()
        if (args.isEmpty()) return null
        return args[index.coerceAtMost(args.size - 1)]
    }

}