package com.acrylic.users

import java.util.*

open class PermissionNode(private var permission: String) {

    init {
        permission = permission.toLowerCase(Locale.ENGLISH)
    }

    fun getPermission() : String {
        return permission
    }

    override fun equals(other: Any?): Boolean {
        return (other is String && other == permission) || (other is PermissionNode && other.getPermission() == permission)
    }

    override fun hashCode(): Int {
        return permission.hashCode()
    }

    override fun toString(): String {
        return "PermissionNode(permission='$permission')"
    }

}