import com.acrylic.Console
import com.acrylic.commands.CommandSet
import com.acrylic.commands.builder.CommandBuilder
import com.acrylic.commands.defaultcommands.RegisteredCommandsCommand
import com.acrylic.commands.defaultcommands.StopCommand
import com.acrylic.text.TextFormat
import com.acrylic.text.createTextBuilder
import com.acrylic.text.send
import com.acrylic.time.Time
import com.acrylic.time.TimeConverter
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import files.FileFactory
import files.JSONFile
import org.yaml.snakeyaml.Yaml


object AcrylicLib {

    @JvmStatic
    val console = Console()
    @JvmStatic
    val commandMap = CommandSet()
    @JvmStatic
    fun main(args: Array<String>) {
        val time = System.nanoTime()
        send(
                createTextBuilder()
                        .append("           [ ", TextFormat.BOLD, TextFormat.AQUA).append("General Utilities ", TextFormat.LIGHT_BLUE).appendThenClear("]", TextFormat.AQUA)
                        .nextLine().append("Developed by ", TextFormat.LIGHT_GRAY).appendThenClear("Acrylic", TextFormat.LIGHT_BLUE).append(". This text uses the ", TextFormat.LIGHT_GRAY).appendThenClear("TextBuilder", TextFormat.WHITE, TextFormat.UNDERLINE).append(".", TextFormat.LIGHT_GRAY)
                        .nextLine().append("This utilities is developed with Java and Kotlin.")
        )

        val timeConverter = TimeConverter.GLOBAL
        commandMap.register(StopCommand(), RegisteredCommandsCommand())
        send(
                createTextBuilder()
                        .appendThenClear("Start Up took ", TextFormat.YELLOW)
                        .appendThenClear(timeConverter.convert(System.nanoTime() - time, Time.NANOSECONDS).toString() + "", TextFormat.LIGHT_GRAY)
                        .append("!", TextFormat.YELLOW)
        )
        commandMap.startRunning()
    }

}