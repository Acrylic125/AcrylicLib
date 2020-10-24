package com.acrylic.users

import java.util.*

interface BaseEntity {

    fun getName() : String

    fun getId() : UUID

    fun sendMessage(text: String)

}