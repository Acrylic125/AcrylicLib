package files

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvFactory

@Deprecated("Temporary")
class CSVFile(path: String) : AbstractFile(path, ObjectMapper(CsvFactory())) {
}