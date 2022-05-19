package cmd

import org.apache.commons.cli.Option
import util.parse
import java.nio.file.Path

class ListAllTaskCmdOptions : AbstractCmdOptions(), ActionCmdOptions {
    private val option = Option("l", "list", false, "list of todo items")

    override fun getOption(): Option = option
    override fun invoke(p: Path, arg: String) = p.toFile().readLines().map { parse(it) }.forEach { println(it) }

}