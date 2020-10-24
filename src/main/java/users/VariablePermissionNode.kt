package com.acrylic.users

open class VariablePermissionNode<T>(permission: String, private var value: T) : PermissionNode(permission) {

    fun setValue(value: T) {
        this.value = value
    }

    fun getValue() : T {
        return value
    }

    override fun toString(): String {
        return "VariablePermissionNode(permission=${getPermission()}, value=$value)"
    }


}