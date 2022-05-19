package cmd



import configuration.DataConfiguration
import configuration.getConfigurationFromFile
import org.apache.commons.cli.Option
import util.createFileIfNotExists
import util.debug
import java.nio.file.Files

class CmdOptionsConfiguration : AbstractCmdOptions() {
    private val option = Option("c", "configuration", true, "set file configuration path")
    override fun getOption(): Option =  option


    fun invoke(filePathStr: String): DataConfiguration {
        val path = createFileIfNotExists(filePathStr)
        debug("Reading from configuration '$path'...")
        val config = getConfigurationFromFile(Files.newBufferedReader(path))
        debug("DataConfiguration loaded with the following values: $config")
        return config
    }
}