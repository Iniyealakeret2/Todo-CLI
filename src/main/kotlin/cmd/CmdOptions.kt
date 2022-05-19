package cmd


import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.Option

interface CmdOptions {
    fun getOption(): Option
    fun isEnabled(line: CommandLine): Boolean
    fun getCmdOptionValue(line: CommandLine): String?
}

