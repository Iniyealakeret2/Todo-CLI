package util

import cmd.*
import cmd.DeletePathCmdOptions

var DEBUG_ENABLED = false
const val SEPARATOR = ";"
const val DATA_FOLDER = "data.folder"
const val DATA_FILE = "todoApp"
val HELP = HelpCmdOptions()
val APP_VERSION = VersionCmdOptions()
val CONFIGURATION = CmdOptionsConfiguration()
val LIST_ALL_TASK = ListAllTaskCmdOptions()
val ADD_TASK = AddTaskCmdOptions()
val DONE = CompletedTaskCmdOptions()
val REMOVE_TASK = DeletePathCmdOptions()
val UNMARKED_TASK = UnmarkedTaskCmd()