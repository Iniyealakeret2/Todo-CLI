package configuration

import cmd.*
import org.apache.commons.cli.Options
import util.*
import java.util.*

class ApplicationConfiguration(val version: String, val commands: List<CmdOptions>, val actionCommands: List<ActionCmdOptions>) {
    fun getOptions(): Options {
        val options = Options()
        commands.forEach { options.addOption(it.getOption()) }
        return options
    }
}

fun loadApplicationConfiguration(): ApplicationConfiguration {
    val properties = Properties()
    properties.load(ClassLoader.getSystemResourceAsStream("application.properties"))
    val actionCmd: List<ActionCmdOptions> = listOf(
            ADD_TASK,
            LIST_ALL_TASK,
            DONE,
            UNMARKED_TASK,
            REMOVE_TASK
    )
    val commands = actionCmd + listOf(
            CONFIGURATION,
            HELP,
            APP_VERSION,
    )
    return ApplicationConfiguration(properties.getProperty("version"), commands, actionCmd)
}
