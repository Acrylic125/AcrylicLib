package files

import files.editor.FileEditor
import java.io.File

interface BaseFile {

    val file: File

    val fileEditor: FileEditor?

    fun saveFile()

}