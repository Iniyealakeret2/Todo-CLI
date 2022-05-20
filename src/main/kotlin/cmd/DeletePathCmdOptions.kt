package cmd


import org.apache.commons.cli.Option
import java.nio.file.Path
import kotlin.io.path.deleteIfExists

class DeletePathCmdOptions: AbstractCmdOptions(), ActionCmdOptions {

    private val option = Option("del", "delete", false, "delete file path")

    override fun getOption(): Option = option
    override fun invoke(p: Path, arg: String) {
        p.deleteIfExists()
    }
}

