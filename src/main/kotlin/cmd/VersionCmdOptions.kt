package cmd

import configuration.loadApplicationConfiguration
import org.apache.commons.cli.Option

class VersionCmdOptions: AbstractCmdOptions() {
    private val option = Option("v", "version", false, "print the application version")

    override fun getOption(): Option = option

    fun execute() {
        val applicationConfiguration = loadApplicationConfiguration()
        println("Todo CLI App version ${applicationConfiguration.version}")
    }
}
