import com.acrylic.text.send
import com.acrylic.users.PermissionNode
import com.acrylic.users.User
import java.util.*
import kotlin.collections.HashSet

/**
 * There can only be 1 console user instance.
 */
open class Console() : User {

    private val permissions: HashSet<PermissionNode> = HashSet()
    private val id: UUID = UUID.randomUUID()

    override fun getName(): String {
        return "Console"
    }

    override fun getId(): UUID {
        return id
    }

    override fun sendMessage(text: String) {
        send(text)
    }

    override fun hasAllPermissionAccess(): Boolean {
        return true
    }

    override fun getPermissions(): HashSet<PermissionNode> {
        return permissions
    }

    override fun savePermissions() {
        throw IllegalAccessError("You may not save console permissions.")
    }
}
