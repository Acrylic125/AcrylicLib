package com.acrylic.commands.builder

import com.acrylic.commands.AbstractCommand
import com.acrylic.commands.AbstractExecutedCommand
import com.acrylic.commands.Command
import com.acrylic.commands.CommandSet
import com.acrylic.text.TextBuilder
import com.acrylic.text.TextFormat
import java.util.function.Predicate

/**
 * This implementation allows for more compact command
 * creation.
 *
 * This package does not use the command builder
 * but extends AbstractCommand.
 *
 * @see com.acrylic.commands.defaultcommands.RegisteredCommandsCommand for an example.
 * @see com.acrylic.commands.AbstractCommand for the command implementation.
 */
class CommandBuilder private constructor(command: String) : AbstractCommand(command) {

    override var description: String = "???"
    override var usage: String = command
    private var isAllowedAction : Predicate<AbstractExecutedCommand>? = null
    private var action : CommandHandler<AbstractExecutedCommand> = CommandHandler{}
    private var disallowedAction : CommandHandler<AbstractExecutedCommand> = CommandHandler{
        it.getExecutor().sendMessage("You may not use this command!")
    }
    private var failedCommandAction : CommandHandler<AbstractExecutedCommand> = CommandHandler{
        it.getExecutor().sendMessage(TextBuilder().append(usage, TextFormat.ORANGE).toString())}

    /**
     * @param command The main command.
     */
    companion object class Builder(command: String) {
        private val cmd = CommandBuilder(command)

        fun setDescription(description: String) : Builder {
            cmd.description = description
            return this
        }

        fun setUsage(usage: String) : Builder {
            cmd.usage = usage
            return this
        }

        fun addAlias(vararg alias: String) : Builder {
            cmd.addAlias(*alias)
            return this
        }

        fun addArgument(vararg arguments: Command) : Builder {
            cmd.addArgument(*arguments)
            return this
        }

        fun handle(action: CommandHandler<AbstractExecutedCommand>) : Builder {
            cmd.action = action
            return this
        }

        fun handleFailedCommandAction(action: CommandHandler<AbstractExecutedCommand>) : Builder {
            cmd.failedCommandAction = action
            return this
        }

        fun handleDisallowedAction(action: CommandHandler<AbstractExecutedCommand>) : Builder {
            cmd.disallowedAction = action
            return this
        }

        fun filter(predicate: Predicate<AbstractExecutedCommand>) : Builder {
            cmd.isAllowedAction = predicate
            return this
        }

        fun build() {
            build(AcrylicLib.commandMap)
        }

        fun build(commandSet: CommandSet) {
            commandSet.register(cmd)
        }

    }

    override fun isAllowedToUseThisCommand(command: AbstractExecutedCommand): Boolean {
        return isAllowedAction == null || isAllowedAction!!.test(command)
    }

    override fun disallowedToUseAction(command: AbstractExecutedCommand) {
        disallowedAction.run(command)
    }

    override fun failedCommandAction(command: AbstractExecutedCommand) {
        failedCommandAction.run(command)
    }

    override fun action(command: AbstractExecutedCommand): Boolean {
        action.run(command)
        return true
    }

}
