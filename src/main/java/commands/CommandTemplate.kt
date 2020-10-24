package com.acrylic.commands

/**
 * This is the most basic command interface.
 *
 * It is suggested you do not directly modify the
 * variables but use the associated functions.
 */
interface CommandTemplate {

    /** The main command. For example, "/help" **/
    fun getCommand() : String

    /** The other aliases used for this commands. For example,
     for the command "/help", you can have "/?" as an alias.**/
    val aliases : ArrayList<String>

    /** CommandExecution will handle
     * any arguments within this array list.
     *
     * @see CommandExecution
     **/
    val arguments: ArrayList<Command>

    /** The command description. **/
    var description: String

    /** The command usage. **/
    var usage: String

    /**
     * This method is used to check whether the {@param executor}
     * can use this command.
     *
     * Do note that there is a hierarchical check for argument
     * commands associated with the main command.
     * This means that:
     * If the main command, "/help", has the argument "page",
     * in order to use "/help page", the isAllowedToUseThisCommand()
     * condition for "/help page" AND "/help" must be satisfied.
     */
    fun isAllowedToUseThisCommand(command: AbstractExecutedCommand) : Boolean

    fun addAlias(vararg alias: String) {
        alias.forEach { addAlias(it) }
    }

    fun addAlias(alias: String) {
        aliases.add(alias.toLowerCase())
    }

    fun addArgument(vararg argument: Command) {
        argument.forEach { addArgument(it) }
    }

    fun addArgument(argument: Command) {
        arguments.add(argument)
    }

    fun isThisCommand(inputCommand: InputCommand) : Boolean {
        val command = inputCommand.getCommand()
        return this.getCommand() == command || aliases.contains(command)
    }

}