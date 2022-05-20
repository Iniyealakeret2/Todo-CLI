package cmd

import org.apache.commons.cli.Option
import java.nio.file.Path

class RemoveATaskFromPath:AbstractCmdOptions(), ActionCmdOptions {

    private val option = Option("rv", "remove", false, "Remove a task from file path")

    override fun invoke(p: Path, arg: String) {
        TODO("Not yet implemented")
    }

    override fun getOption(): Option = option
}