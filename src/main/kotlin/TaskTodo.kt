import util.SEPARATOR

data class TaskTodo(var nameOfTask: String, var isTaskDone: Boolean = false) {
    override fun toString(): String {
        val done = if (isTaskDone) "completed" else "not completed"
        println()
        return " * $nameOfTask ----------->> \t$done"
    }

    fun serialize(): String {
        return "$nameOfTask$SEPARATOR$isTaskDone"
    }
}


