
import configuration.loadApplicationConfiguration
import org.apache.commons.cli.DefaultParser
import util.*
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val applicationConfiguration = loadApplicationConfiguration()

    val parser = DefaultParser()
    val line = parser.parse(applicationConfiguration.getOptions(), args)

    if (HELP.isEnabled(line)) {
        HELP.execute(applicationConfiguration.getOptions())
        exitProcess(0)
    }
    if (APP_VERSION.isEnabled(line)) {
        APP_VERSION.execute()
        exitProcess(0)
    }

    val configurationPath: String
    val homeFolder = System.getProperty("user.home")
    configurationPath = CONFIGURATION.getCmdOptionValue(line)?: "$homeFolder/.todoApp.properties"
    val configuration = CONFIGURATION.invoke(configurationPath)

    val path = createFileIfNotExists(configuration.dataFilePath)

    val cmd = applicationConfiguration.actionCommands.find { it.isEnabled(line) }
    cmd?.invoke(path, cmd.getCmdOptionValue(line)?: "")
}



