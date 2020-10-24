package files

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory

class PropertiesFile(path: String) : AbstractFile(path, ObjectMapper(JavaPropsFactory())) {

}