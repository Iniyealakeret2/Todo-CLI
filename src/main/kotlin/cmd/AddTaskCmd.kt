package cmd

import app.TaskToDo
import org.apache.commons.cli.Option
import java.nio.file.Path

class AddTaskCmd: CmdOptionsImpl(), CmdOptionsAction {
    private val cmdListOptions = Option("a","add", true,"add todo item")

    override fun invoke(path: Path, task: String) = path.toFile().appendText(TaskToDo(task).serialize() + "\n")

    override fun getCmdOptions(): Option = cmdListOptions
}