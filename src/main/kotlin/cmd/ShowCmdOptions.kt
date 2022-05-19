package cmd

import org.apache.commons.cli.Option
import utils.deSerialize
import java.nio.file.Path

class ShowCmdOptions: CmdOptionsImpl(), CmdOptionsAction {

    private val cmdListOptions = Option("l", true,"print todo items")

    override fun invoke(path: Path, task: String) = path.toFile().readLines().map { deSerialize(it) }.forEach { println(it) }

    override fun getCmdOptions(): Option = cmdListOptions
}