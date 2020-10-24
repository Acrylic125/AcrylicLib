package com.acrylic.commands

/**
 * Implement this interface to create a command.
 */
interface Command : CommandExecution {

    /**
     * This function will run upon the command being
     * registered to the command map.
     *
     * @see CommandSet
     */
    fun commandRegister()

}