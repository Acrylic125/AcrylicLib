package com.acrylic.users

interface PermissionHolder {

    fun hasAllPermissionAccess() : Boolean

    fun getPermissions() : HashSet<PermissionNode>

    fun savePermissions()

    fun addPermission(permission: String) {
        getPermissions().add(PermissionNode(permission))
    }

    fun addPermission(permission: PermissionNode) {
        getPermissions().add(permission)
    }

    fun addPermission(vararg permission: PermissionNode) {
        getPermissions().addAll(permission)
    }

    fun removePermission(permission: String) {
        val perm = getPermission(permission)
        if (perm != null) getPermissions().remove(perm)
    }

    fun removePermission(permission: PermissionNode) {
        removePermission(permission.getPermission())
    }

    fun getPermission(permission: String) : PermissionNode? {
        getPermissions().forEach { if (it.equals(permission)) return it }
        return null
    }

    fun getPermission(permission: PermissionNode) : PermissionNode? {
        return getPermission(permission.getPermission())
    }

    fun hasPermission(permission: PermissionNode) : Boolean {
        return hasPermission(permission.getPermission())
    }

    fun hasPermission(permission: String) : Boolean {
        val permission = permission.toLowerCase()
        return hasAllPermissionAccess() || getPermission(permission) != null
    }

}