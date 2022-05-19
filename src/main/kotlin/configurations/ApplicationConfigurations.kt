package configurations

import cmd.CmdOptions
import cmd.CmdOptionsAction
import org.apache.commons.cli.Options

class ApplicationConfigurations(val commands: List<CmdOptions>, val commandActions: List<CmdOptionsAction>) {
    fun getOptions(): Options{
        val options = Options()
        commands.forEach { options.addOption(it.getCmdOptions()) }
        return options
    }
}