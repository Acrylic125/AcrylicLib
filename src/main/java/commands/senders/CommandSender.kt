package com.acrylic.commands.senders

import com.acrylic.commands.getInputCommand
import com.acrylic.users.BaseEntity
import com.acrylic.users.PermissionHolder

interface CommandSender : PermissionHolder, BaseEntity {

    fun execute(text: String) {
        AcrylicLib.commandMap.checkCommand(this,getInputCommand(text))
    }


}