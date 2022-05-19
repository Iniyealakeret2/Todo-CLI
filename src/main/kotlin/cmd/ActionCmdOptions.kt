package cmd

import java.nio.file.Path

interface ActionCmdOptions: CmdOptions {
    fun invoke(p: Path, arg: String)
}