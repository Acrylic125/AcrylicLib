package files

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper

class JSONFile(path: String) : AbstractFile(path, ObjectMapper(JsonFactory())) {
}