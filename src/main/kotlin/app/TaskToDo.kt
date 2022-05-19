package app

data class TaskToDo(val nameOfTask: String, var isTaskDone: Boolean = false) {
    override fun toString(): String {
        val done = if(isTaskDone) "*" else ""
        return "$done $nameOfTask"
    }
    fun serialize(): String = "$nameOfTask;$isTaskDone"
}


