package utils

import app.TaskToDo
import cmd.CmdOptionsAction
import configurations.ApplicationConfigurations
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

fun deSerialize(line: String): TaskToDo{
    val array = line.split(";")
    if (array.size < 2){
        return TaskToDo("", false)
    }
    return TaskToDo(parseLine(array[0]), parseLine(array[1]).toBoolean())
}

fun parseLine(value: String): String = value.replace("\n","")

fun loadApplicationConfiguration(): ApplicationConfigurations{
    val properties = Properties()
        properties.load(ClassLoader.getSystemResourceAsStream("application.properties"))
    val cmdOptionsAction : List<CmdOptionsAction> = listOf(
        ADD_CMD, CMD_OPTIONS, DONE_CMD
    )
    val commandActions = cmdOptionsAction + listOf(
        CONFIGURATION
    )
    return ApplicationConfigurations(commandActions, cmdOptionsAction)
}

fun createFilePathIfDoesNotExist(filePath: String): Path{
    val paths = Paths.get(filePath)
    if (!Files.exists(paths)) Files.createFile(paths)
    return paths
}

fun debugger(message: String) {
    if (DEBUG_ENABLED) {
        println("[DEBUG] $message")
    }
}
