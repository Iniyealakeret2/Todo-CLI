package cmd

import configurations.DataConfiguration
import configurations.getConfigurationFromFile
import org.apache.commons.cli.Option
import utils.createFilePathIfDoesNotExist
import utils.debugger
import java.nio.file.Files

class CmdConfiguration: CmdOptionsImpl() {

    private val cmdListOption = Option("c", "config", true, "set the config file path")

    fun invoke(filePath: String): DataConfiguration {
        val path = createFilePathIfDoesNotExist(filePath)
        debugger("Reading from config '$path'...")
        val configuration = getConfigurationFromFile(Files.newBufferedReader(path))
        debugger("DataConfig loaded with the following values: $configuration")
        return  configuration
    }

    override fun getCmdOptions(): Option =  cmdListOption
}