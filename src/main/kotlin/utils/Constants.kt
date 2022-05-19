package utils

import cmd.AddTaskCmd
import cmd.CmdConfiguration
import cmd.DoneTaskCmd
import cmd.ShowCmdOptions

val CMD_OPTIONS = ShowCmdOptions()
val ADD_CMD = AddTaskCmd()
val DONE_CMD = DoneTaskCmd()
val CONFIGURATION = CmdConfiguration()

const val DATA_FOLDER = "data.folder"
const val DATA_FILE = "mainModule"
var DEBUG_ENABLED = false
