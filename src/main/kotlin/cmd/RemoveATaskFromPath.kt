package cmd

import org.apache.commons.cli.Option
import java.io.*
import java.nio.file.Path

class RemoveATaskFromPath: AbstractCmdOptions(), ActionCmdOptions {

    private val option = Option("rv", "remove", true, "Remove a task from file path")

    override fun invoke(p: Path, arg: String) {
        val home:String? = System.getProperty("user.home")
        val inputFile = File(home + File.separator.toString() + "Desktop" + File.separator.toString() + ".todoApp.properties")
        val tempFile = File(home + File.separator.toString() + "Desktop" + File.separator.toString() + ".tempTodoApp.properties")
        val reader = BufferedReader(FileReader(inputFile))
        val writer = BufferedWriter(FileWriter(tempFile))
        val lineToRemove = arg
        var currentLine: String
        while (reader.readLine().also { currentLine = it } != null) {
            // trim newline when comparing with lineToRemove
            val trimmedLine = currentLine.trim { it <= ' ' }
            if (trimmedLine == lineToRemove) continue
            writer.write(currentLine + System.getProperty("line.separator"))
        }
        writer.close()
        reader.close()
        tempFile.renameTo(inputFile)
    }

    override fun getOption(): Option = option
}