package cmd

import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options

class HelpCmdOptions: AbstractCmdOptions() {
    private val option = Option("h", "help", false, "show command options")
    override fun getOption(): Option = option

    fun execute(options: Options) {
        val formatter = HelpFormatter()
        formatter.printHelp("java -jar todoApp.jar", options)
    }
}