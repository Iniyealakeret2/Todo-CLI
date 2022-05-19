import org.apache.commons.cli.DefaultParser
import utils.CONFIGURATION
import utils.createFilePathIfDoesNotExist
import utils.loadApplicationConfiguration

fun main(args: Array<String>){
    val applicationConfiguration = loadApplicationConfiguration()
    val parser = DefaultParser()
    val line = parser.parse(applicationConfiguration.getOptions(), args)

    var configurationPath  = ""
    val folder = System.getProperty("user.home")
    if (CONFIGURATION.getCmdOptionValue(line) == null){
        configurationPath = "$folder/.mainModule.properties"
    }
    val configuration = CONFIGURATION.invoke(configurationPath)

    val path = createFilePathIfDoesNotExist(configuration.dataFilePath)
    val cmd = applicationConfiguration.commandActions.find {
        it.isEnabled(line)
    }
    cmd?.invoke(path, cmd.getCmdOptionValue(line)?:"")
}

