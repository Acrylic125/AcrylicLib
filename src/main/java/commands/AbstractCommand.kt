package com.acrylic.commands

import com.acrylic.text.send

abstract class AbstractCommand(private var command: String, vararg aliases: String) : Command {

    init {
        command = command.toLowerCase()
        addAlias(*aliases)
    }

    override val aliases: ArrayList<String> = ArrayList()
    override val arguments: ArrayList<Command> = ArrayList()

    override fun commandRegister() {
        send("${getCommand()} Command Registered!")
    }

    override fun getCommand(): String {
        return command
    }


}