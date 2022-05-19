package cmd

import org.apache.commons.cli.CommandLine

abstract class AbstractCmdOptions: CmdOptions {
    override fun isEnabled(line: CommandLine): Boolean = line.hasOption(getOption().longOpt)
    override fun getCmdOptionValue(line: CommandLine): String? = line.getOptionValue(getOption().longOpt)
}