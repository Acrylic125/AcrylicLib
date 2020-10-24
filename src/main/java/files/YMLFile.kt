package files

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory

class YMLFile(path: String) : AbstractFile(path, ObjectMapper(YAMLFactory())) {

}