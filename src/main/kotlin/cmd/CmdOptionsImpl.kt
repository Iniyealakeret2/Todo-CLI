package cmd

import org.apache.commons.cli.CommandLine

abstract class CmdOptionsImpl: CmdOptions {

    override fun isEnabled(line: CommandLine): Boolean = line.hasOption(getCmdOptions().longOpt)

    override fun getCmdOptionValue(line: CommandLine): String? = line.getOptionValue(getCmdOptions().longOpt)
}