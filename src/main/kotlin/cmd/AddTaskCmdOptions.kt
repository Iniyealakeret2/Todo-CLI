package cmd

import TaskTodo
import org.apache.commons.cli.Option
import java.nio.file.Path

class AddTaskCmdOptions: AbstractCmdOptions(), ActionCmdOptions {

    private val option = Option("a", "add", true, "add a todo item")

    override fun getOption(): Option = option
    override fun invoke(p: Path, arg: String) = p.toFile().appendText(TaskTodo(arg).serialize() + "\n")

}