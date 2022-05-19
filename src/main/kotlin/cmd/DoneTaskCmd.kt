package cmd

import app.TaskToDo
import org.apache.commons.cli.Option
import utils.deSerialize
import java.io.File
import java.nio.file.Path

class DoneTaskCmd: CmdOptionsImpl(), CmdOptionsAction {

    private val cmdListOption = Option("f","done",true,"Task Done")

    override fun invoke(path: Path, task: String) {
        val singleTask = TaskToDo(task)
        val tasks = path.toFile().readLines().map { deSerialize(it) }
        tasks.filter { it.nameOfTask == singleTask.nameOfTask }.forEach { it.isTaskDone = true }
        File(path.toString()).printWriter().use { value ->
            tasks.forEach { value.println(it.serialize()) }
        }
    }

    override fun getCmdOptions(): Option = cmdListOption
}