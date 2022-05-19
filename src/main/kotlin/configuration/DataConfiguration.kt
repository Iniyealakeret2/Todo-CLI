package configuration

import util.DATA_FILE
import util.DATA_FOLDER
import java.io.Reader
import java.util.*


data class DataConfiguration(val dataFilePath: String)

fun getConfigurationFromFile(reader: Reader): DataConfiguration {
    val properties = Properties()
    properties.load(reader)
    val dataFolder = properties.getProperty(DATA_FOLDER, "/tmp")
    return DataConfiguration("$dataFolder/$DATA_FILE")
}