package files

import com.fasterxml.jackson.databind.ObjectMapper
import files.editor.DefaultFileEditor
import files.editor.FileEditor
import java.io.File
import java.io.IOException
import java.util.logging.Level
import java.util.logging.Logger

abstract class AbstractFile(path: String, private val mapper: ObjectMapper) : BaseFile {

    final override val file: File = File(path)
    final override val fileEditor: FileEditor

    override fun saveFile() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, fileEditor.contents)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    init {
        var fileEditor: FileEditor = DefaultFileEditor()
        try {
            if (!file.exists()) {
                val logger = Logger.getGlobal()
                val parent = file.parentFile
                if (parent != null) {
                    if (!file.parentFile.mkdirs()) logger.log(Level.WARNING, "Failed to create parent path for $path!")
                }
                if (!file.createNewFile()) logger.log(Level.WARNING, "Failed to create file for $path!")
            }
            mapper.findAndRegisterModules()
            fileEditor = DefaultFileEditor(file, mapper)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        this.fileEditor = fileEditor
    }
}