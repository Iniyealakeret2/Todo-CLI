package cmd

import TaskTodo
import org.apache.commons.cli.Option
import util.parse
import java.io.File
import java.nio.file.Path

class UnmarkedTaskCmd: AbstractCmdOptions(), ActionCmdOptions {

    private val option = Option("un", "undo", true, "mark task as not done")

    override fun invoke(p: Path, arg: String) {
        val task = TaskTodo(arg)
        val tasks = p.toFile().readLines().map { parse(it) }
        tasks.filter { it.nameOfTask == task.nameOfTask }.forEach { it.isTaskDone = false }
        File(p.toString()).printWriter().use { out ->
            tasks.forEach { out.println(it.serialize()) }
        }
    }

    override fun getOption(): Option = option
}