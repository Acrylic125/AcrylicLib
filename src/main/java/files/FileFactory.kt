package files

import com.acrylic.exceptions.UnsupportedFileTypeException

/**
 * FileFactory is a utility class that retrieves the AbstractFile
 * of the given path.
 *
 * As of now, it only supports (.yml, and .json)
 */
object FileFactory {
    /**
     * @param path The parent path of the targeted file. Use null if there is no
     * designated path of the file.
     * @param file The main file.
     * @return The AbstractFile obtained.
     * @throws UnsupportedFileTypeException if the given file extension is not
     * a supported file extension.
     *
     * Example:
     * If:   The full path of the file is src/main/resources/test.yml,
     * Then: getAbstractFile("src/main/resources", "test.yml")
     */
    fun getAbstractFile(path: String?, file: String): AbstractFile {
        val realPath = if (path != null) "$path/$file" else file
        if (!file.contains(".")) throw UnsupportedFileTypeException()
        val patchConstruct = file.split(".").toTypedArray()
        val fileExtension = patchConstruct[patchConstruct.size - 1].toLowerCase()
        println(fileExtension)
        when (fileExtension) {
            "yml"        -> return YMLFile(realPath)
            "json"       -> return JSONFile(realPath)
            "properties" -> return PropertiesFile(realPath)
           // "csv"        -> return CSVFile(realPath)
        }
        throw UnsupportedFileTypeException()
    }

    /**
     *
     * @param path The full path of the file.
     * @return The AbstractFile obtained.
     *
     * Example:
     * If:   The full path of the file is src/main/resources/test.yml,
     * Then: getAbstractFile("src/main/resources/test.yml")
     */
    fun getAbstractFile(path: String): AbstractFile {
        if (path.contains("/")) {
            val strings = path.split("/").toTypedArray()
            val file = strings[strings.size - 1]
            val newPath = path.replace("/$file", "")
            return getAbstractFile(newPath, file)
        }
        return getAbstractFile(null, path)
    }
}