package com.acrylic.commands.builder

import com.acrylic.commands.AbstractExecutedCommand

/**
 * Functional interface for commands executions.
 * This is mainly used for CommandBuilder.
 *
 * @see CommandBuilder
 */
fun interface CommandHandler<T : AbstractExecutedCommand> {

    fun run(command: T)

}