package util

import TaskTodo
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

fun parse(line: String): TaskTodo {
    val array = line.split(SEPARATOR)
    if (array.size < 2) {
        return TaskTodo("", false)
    }
    return TaskTodo(deSerialize(array[0]), deSerialize(array[1]).toBoolean())
}

fun deSerialize(str: String): String {
    return str.replace("\n", "")
}

fun createFileIfNotExists(filePath: String): Path {
    val path = Paths.get(filePath)
    if (!Files.exists(path)) {
        Files.createFile(path)
    }
    return path
}

fun debug(message: String) {
    if (DEBUG_ENABLED) {
        println("[DEBUG] $message")
    }
}