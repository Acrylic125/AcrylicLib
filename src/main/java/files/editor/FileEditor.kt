package files.editor

interface FileEditor : Configurable {

    val contents: HashMap<String, Any>?
    val parent: FileEditor?
    fun getFileEditor(`var`: String): FileEditor

    fun getInstance() : FileEditor {
        return this
    }

}