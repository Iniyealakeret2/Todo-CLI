
package cmd

import java.nio.file.Path

interface CmdOptionsAction: CmdOptions {
    fun invoke(path: Path, task: String)
}