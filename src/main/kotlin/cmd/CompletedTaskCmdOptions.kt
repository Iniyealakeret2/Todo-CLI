package cmd

import TaskTodo
import org.apache.commons.cli.Option
import util.parse
import java.io.File
import java.nio.file.Path

class CompletedTaskCmdOptions : AbstractCmdOptions(), ActionCmdOptions {
    private val option = Option("d", "done", true, "mark task completed")
    override fun getOption(): Option = option

    override fun invoke(p: Path, arg: String) {
        val task = TaskTodo(arg)
        val tasks = p.toFile().readLines().map { parse(it) }
        tasks.filter { it.nameOfTask == task.nameOfTask }.forEach { it.isTaskDone = true }
        File(p.toString()).printWriter().use { out ->
            tasks.forEach { out.println(it.serialize()) }
        }
    }
}