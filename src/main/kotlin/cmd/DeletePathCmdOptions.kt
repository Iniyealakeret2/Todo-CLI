package cmd

import TaskTodo
import org.apache.commons.cli.Option
import util.parse
import java.io.*
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.deleteIfExists

class DeletePathCmdOptions: AbstractCmdOptions(), ActionCmdOptions {

    private val option = Option("del", "delete", false, "delete file path")

    override fun getOption(): Option = option
    override fun invoke(p: Path, arg: String) {
        p.deleteIfExists()
    }
}
/**
 * val task = TaskTodo(arg)
val tasks = ArrayList<TaskTodo>()
val readerStream = Files.newBufferedReader(p)
readerStream.buffered().lines().forEach { line ->
val t = parse(line)
if (t.nameOfTask == task.nameOfTask) {
tasks.remove(task)
}
File(p.toString()).printWriter().use { out ->
tasks.forEach { out.println(it.serialize()) }
}
}


val tasks = ArrayList<Task>()
val stream = Files.newBufferedReader(p)
stream.buffered().lines().forEach { line -> tasks.add(parse(line)) }
tasks.forEach { println(it) }
 */

